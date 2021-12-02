package com.epam.shop.dao.api;

import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.Product;

import java.util.List;

public interface ProductDao extends Dao<Product, Integer> {
    List<Product> findAllByBrand(Integer brand) throws DaoException;
    List<Product> findAllByCategoryAndBrand(Integer category, Integer brand) throws DaoException;
    List<Product> findAllByCategory(Integer category) throws DaoException;




}
