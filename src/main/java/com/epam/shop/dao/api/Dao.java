package com.epam.shop.dao.api;

import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.AbstractModel;

import java.util.List;

/**
 *
 * @param <T>Entity that inherits from {@link AbstractModel}
 * @param <K>id for inherited entities
 */
public interface Dao<T extends AbstractModel<K>, K> {
    /**
     *
     * @param model
     * @return returns the saved model
     * @throws DaoException if saving failed
     */
    T save(T model) throws DaoException;

    /**
     *
     * @param model to update
     * @return updated model
     * @throws DaoException if the update failed
     */
    T update(T model) throws DaoException;

    /**
     *
     * @param id from our model to delete
     * @throws DaoException if there was a delete error
     */
   void delete(K id)throws DaoException;

    /**
     *
     * @param id from our model to find it
     * @return our model if it was found
     * @throws DaoException if there was an error
     */
    T findById(K id)throws DaoException;

    /**
     *
     * @return List our models from db
     * @throws DaoException if if there was an error
     */
    List<T> findAll()throws DaoException;
}
