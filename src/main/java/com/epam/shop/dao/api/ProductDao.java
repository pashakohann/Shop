package com.epam.shop.dao.api;

import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.Product;

import java.util.List;

/**
 * @see Dao
 */
public interface ProductDao extends Dao<Product, Integer> {
    /**
     *
     * @param brandId product search by brand
     * @return all products with this brand
     * @throws DaoException if there was a failure
     */
    List<Product> findAllByBrand(int brandId) throws DaoException;

    /**
     *
     * @param categoryId product search by category id
     * @param brandId product search by brand id
     * @return products with this match
     * @throws DaoException if there was a failure
     */
    List<Product> findAllByCategoryAndBrand(int categoryId, int brandId) throws DaoException;

    /**
     *
     * @param categoryId product search by category
     * @return all products with this category
     * @throws DaoException if there was a failure
     */
    List<Product> findAllByCategory(int categoryId) throws DaoException;




}
