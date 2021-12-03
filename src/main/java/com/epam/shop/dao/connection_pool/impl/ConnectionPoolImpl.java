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


public final class ConnectionPoolImpl implements ConnectionPool {
    private static ConnectionPool instance;
    private boolean initialized = false;
    private final BlockingQueue<ProxyConnection> availableConnections;
    private final BlockingQueue<ProxyConnection> givenAwayConnections;

    private static final int INITIAN_POOL_SIZE = 7;

    private Logger logger = LogManager.getLogger(ConnectionPoolImpl.class);

    private ConnectionPoolImpl() {
        availableConnections = new ArrayBlockingQueue<>(INITIAN_POOL_SIZE);
        givenAwayConnections = new ArrayBlockingQueue<>(INITIAN_POOL_SIZE);
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPoolImpl();

        }
        return instance;
    }


    @Override
    public boolean init() throws DaoException {
        if (!initialized) {
            initializeConnections(INITIAN_POOL_SIZE);
            initialized = true;
            return true;
        }
        return false;
    }


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

    @Override
    public void returnConnection(Connection connection) {
        try {
            availableConnections.put(givenAwayConnections.take());
        } catch (InterruptedException e) {
            logger.error(DaoConnectionExceptionString.SQL_RETURN_CONNECTION_EXCEPTION, e);

        }

    }

    private boolean initializeConnections(int amountOfConnections) throws DaoException {
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

    @Override
    public boolean shutDown() throws DaoException {
        if (initialized) {
            closeConnections();
            initialized = false;
            return true;
        }
        return false;
    }

    private void closeConnections() throws DaoException {
        closeConnections(this.availableConnections);
        closeConnections(this.givenAwayConnections);
    }

    private void closeConnections(Collection<ProxyConnection> connections) throws DaoException {
        for (ProxyConnection connection : connections) {
            closeConnection(connection);
        }
    }

    private void closeConnection(ProxyConnection connection) throws DaoException {
        try {
            connection.realClose();
        } catch (SQLException e) {
            logger.error(DaoConnectionExceptionString.SQL_CLOSE_CONNECTION_EXCEPTION, e);
        }
    }


}
