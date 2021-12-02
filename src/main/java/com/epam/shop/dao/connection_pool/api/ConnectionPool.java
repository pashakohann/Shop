package com.epam.shop.dao.connection_pool.api;

import com.epam.shop.dao.exception.DaoException;

import java.sql.Connection;

public interface ConnectionPool {

        boolean init() throws DaoException;

        boolean shutDown()throws DaoException;

        Connection takeConnection();

        void returnConnection(Connection connection);
    }


