package com.epam.shop.dao.api;

import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.Product;

import java.util.List;

public interface ProductDao extends Dao<Product, Integer> {
    List<Product> findAllByBrand(int brandId) throws DaoException;
    List<Product> findAllByCategoryAndBrand(int categoryId, int brandId) throws DaoException;
    List<Product> findAllByCategory(int categoryId) throws DaoException;




}
