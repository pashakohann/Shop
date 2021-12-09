package com.epam.shop.service.api;

import com.epam.shop.dao.connection_pool.api.ConnectionPool;
import com.epam.shop.dao.connection_pool.impl.ConnectionPoolImpl;
import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.service.dto.model.AbstractModelDto;
import com.epam.shop.service.exception.ServiceException;

import java.util.List;


public interface Service<T extends AbstractModelDto<K>, K> {
    T create(T model) throws ServiceException;

    T update(T model) throws ServiceException;

    void delete(T model) throws ServiceException;

    T getById(K id) throws ServiceException;

    List<T> getAll() throws ServiceException;

}
