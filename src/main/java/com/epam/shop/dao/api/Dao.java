package com.epam.shop.dao.api;

import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.AbstractModel;

import java.util.List;

public interface Dao<T extends AbstractModel<K>, K> {
    T save(T model) throws DaoException;
    T update(T model) throws DaoException;
   void delete(K id)throws DaoException;
    T findById(K id)throws DaoException;
    List<T> findAll()throws DaoException;
}
