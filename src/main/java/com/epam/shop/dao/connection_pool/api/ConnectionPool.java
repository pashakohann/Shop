package com.epam.shop.dao.connection_pool.api;

import com.epam.shop.dao.exception.DaoException;


import java.sql.Connection;

/**
 * The interface provide to create connections,shut down pool connections,take connections and return them
 */
public interface ConnectionPool {
    /**
     *method that creates connections
     * @return true. if it was possible to create connections and connect to the database
     * @throws DaoException if failed to create connections to DB and get connections
     */
        boolean init() throws DaoException;

    /**
     *
     * @return closes all connections
     * @throws DaoException if failed to close connections
     */
    boolean shutDown()throws DaoException;

    /**
     *
     * @return  connection from connection pool
     */
        Connection takeConnection();

    /**
     *
     * @param connection to be returned to connection pool
     */
    void returnConnection(Connection connection);
    }


