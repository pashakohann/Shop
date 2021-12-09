package com.epam.shop.service.impl;

import com.epam.shop.dao.connection_pool.impl.ConnectionPoolImpl;
import com.epam.shop.service.api.ConnectionService;

public class ConnectionServiceImpl implements ConnectionService {
    private static ConnectionService instance;


    private ConnectionServiceImpl() {
    }

    public static ConnectionService getInstance() {
        if (instance == null) {
            instance = new ConnectionServiceImpl();
        }
        return instance;
    }

    @Override
    public void init() {
        ConnectionPoolImpl.getInstance().init();
    }

    @Override
    public void destroy() {
        ConnectionPoolImpl.getInstance().shutDown();
    }
}
