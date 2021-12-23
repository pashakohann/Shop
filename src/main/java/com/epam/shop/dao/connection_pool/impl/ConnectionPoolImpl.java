package com.epam.shop.dao.connection_pool.impl;


import com.epam.shop.dao.connection_pool.api.ConnectionPool;
import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.exception.string_exception.DaoConnectionExceptionString;
import com.epam.shop.dao.sql_query.ConfigSql;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @see ConnectionPool
 */
public final class ConnectionPoolImpl implements ConnectionPool {
    private static ConnectionPool instance;
    private boolean initialized = false;
    private final BlockingQueue<ProxyConnection> availableConnections;
    private final BlockingQueue<ProxyConnection> givenAwayConnections;

    private static final int INITIAL_POOL_SIZE = 7;

    private final Logger logger = LogManager.getLogger(ConnectionPoolImpl.class);

    /**
     * creates the maximum volume in blocking queues for connections
     */
    private ConnectionPoolImpl() {
        availableConnections = new ArrayBlockingQueue<>(INITIAL_POOL_SIZE);
        givenAwayConnections = new ArrayBlockingQueue<>(INITIAL_POOL_SIZE);
    }

    /**
     *
     * @return Instance from Connection pool
     */
    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPoolImpl();

        }
        return instance;
    }


    /**
     * @see ConnectionPool
     * @return
     * @throws DaoException
     */
    @Override
    public boolean init() throws DaoException {
        if (!initialized) {
            initializeConnections(INITIAL_POOL_SIZE);
            initialized = true;
            return true;
        }
        return false;
    }

    /**
     *
     * @return connection from Blocking Queue
     */
    @Override
    public Connection takeConnection() {
        final ProxyConnection connection;
        try {
            connection = availableConnections.take();
            givenAwayConnections.put(connection);
            return connection;
        } catch (InterruptedException e) {
            logger.error(DaoConnectionExceptionString.SQL_TAKE_CONNECTION_EXCEPTION, e);
        }

        return null;
    }

    /**
     *
     * @param connection to be returned to connection pool
     */
    @Override
    public void returnConnection(Connection connection) {
        try {
            availableConnections.put(givenAwayConnections.take());
        } catch (InterruptedException e) {
            logger.error(DaoConnectionExceptionString.SQL_RETURN_CONNECTION_EXCEPTION, e);

        }

    }

    /**
     *
     * @param amountOfConnections number of connections
     * @return if it was possible to create the given quantity
     */
    private boolean initializeConnections(int amountOfConnections) {
        try {
            for (int i = 0; i < amountOfConnections; i++) {
                Class.forName(ConfigSql.DRIVER);
                final Connection connection = DriverManager.getConnection(ConfigSql.DB_URL, ConfigSql.USER, ConfigSql.PASSWORD);
                final ProxyConnection proxyConnection = new ProxyConnection(connection, this);
                availableConnections.add(proxyConnection);
            }
            return true;

        } catch (SQLException e) {
            logger.error(DaoConnectionExceptionString.CREATE_CONNECTION_EXCEPTION, e);
        } catch (ClassNotFoundException e) {
            logger.error(DaoConnectionExceptionString.FIND_CLASS_EXCEPTION, e);

        }
        return false;
    }

    /**
     * @see ConnectionPool
     * @return
     * @throws DaoException
     */
    @Override
    public boolean shutDown() throws DaoException {
        if (initialized) {
            closeConnections();
            initialized = false;
            return true;
        }
        return false;
    }

    /**
     * close connection from Blocking Queues
     * @throws DaoException if there was a failure
     */
    private void closeConnections() throws DaoException {
        closeConnections(this.availableConnections);
        closeConnections(this.givenAwayConnections);
    }

    /**
     *
     * @param connections Connections to be closed
     * @throws DaoException if there was a failure
     */
    private void closeConnections(Collection<ProxyConnection> connections) throws DaoException {
        for (ProxyConnection connection : connections) {
            closeConnection(connection);
        }
    }

    /**
     *
     * @param connection here we close our connection, because before that we returned to our queues
     * @throws DaoException
     */
    private void closeConnection(ProxyConnection connection) throws DaoException {
        try {
            connection.realClose();
        } catch (SQLException e) {
            logger.error(DaoConnectionExceptionString.SQL_CLOSE_CONNECTION_EXCEPTION, e);
        }
    }


}
