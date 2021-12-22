package com.epam.shop.service.api;


import com.epam.shop.service.exception.ServiceException;

public interface ConnectionService {
     void init() throws ServiceException;


     void destroy() throws ServiceException; ;


}
