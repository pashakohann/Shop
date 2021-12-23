package com.epam.shop.service.api;


import com.epam.shop.service.exception.ServiceException;

/**
 * Was created so that there was no direct interaction of the controller with the dao.
 */
public interface ConnectionService {
     /**
      * @see com.epam.shop.dao.connection_pool.api.ConnectionPool
      * @throws ServiceException if failed to connection to db and to get connections
      */
     void init() throws ServiceException;

     /**
      * @see com.epam.shop.dao.connection_pool.api.ConnectionPool
      * @throws ServiceException if connections failed to close
      */
     void destroy() throws ServiceException; ;


}
