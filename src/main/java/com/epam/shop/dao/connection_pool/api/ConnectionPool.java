package com.epam.shop.dao.connection_pool.api;

import com.epam.shop.dao.exception.ConnectionException;


import java.sql.Connection;

public interface ConnectionPool {

        boolean init() throws ConnectionException;

        boolean shutDown()throws ConnectionException;

        Connection takeConnection();

        void returnConnection(Connection connection);
    }


