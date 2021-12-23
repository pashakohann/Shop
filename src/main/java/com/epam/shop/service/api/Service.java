package com.epam.shop.service.api;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.AbstractModel;
import com.epam.shop.service.dto.model.AbstractModelDto;
import com.epam.shop.service.exception.ServiceException;

import java.util.List;

/**
 *
 * @param <T>Entity that inherits from {@link AbstractModelDto}
 * @param <K>id for inherited entities
 */
public interface Service<T extends AbstractModelDto<K>, K> {
    /**
     *
     * @param model
     * @return returns the saved model
     * @throws ServiceException if saving failed
     */
    T create(T model) throws ServiceException;
    /**
     *
     * @param model to update
     * @return updated model
     * @throws ServiceException if the update failed
     */
    T update(T model) throws ServiceException;
    /**
     *
     * @param model to be deleted
     * @throws ServiceException if there was an error
     */
    default void delete(T model) throws ServiceException{}
    /**
     *
     * @param id from our model to find it
     * @return our model if it was found
     * @throws ServiceException if there was an error
     */
    T getById(K id) throws ServiceException;
    /**
     *
     * @return List our models from db
     * @throws ServiceException if there was an error
     */
    List<T> getAll() throws ServiceException;

}
