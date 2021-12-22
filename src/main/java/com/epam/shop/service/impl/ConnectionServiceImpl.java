package com.epam.shop.service.impl;

import com.epam.shop.dao.connection_pool.impl.ConnectionPoolImpl;
import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.service.api.ConnectionService;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceConnectionExceptionString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionServiceImpl implements ConnectionService {
    private static ConnectionService instance;
    private final Logger logger = LogManager.getLogger(ConnectionServiceImpl.class);

    private ConnectionServiceImpl() {
    }

    public static ConnectionService getInstance() {
        if (instance == null) {
            instance = new ConnectionServiceImpl();
        }
        return instance;
    }

    @Override
    public void init() throws ServiceException {
        try {
            ConnectionPoolImpl.getInstance().init();
        } catch (DaoException e) {
            logger.error(ServiceConnectionExceptionString.CONNECTION_EXCEPTION, e);
            throw new ServiceException(ServiceConnectionExceptionString.CONNECTION_EXCEPTION, e);
        }
    }

    @Override
    public void destroy() throws ServiceException {
        try {
            ConnectionPoolImpl.getInstance().shutDown();
        } catch (DaoException e) {
            logger.error(ServiceConnectionExceptionString.DESTROY_CONNECTION_EXCEPTION, e);
            throw new ServiceException(ServiceConnectionExceptionString.DESTROY_CONNECTION_EXCEPTION, e);
        }
    }
}
