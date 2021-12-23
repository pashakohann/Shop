package com.epam.shop.dao.api;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.Order;
import com.epam.shop.dao.model.Product;

import java.util.Map;

/**
 *extend {@link Dao}
 */
public interface OrderDao extends Dao<Order,Integer> {
    /**
     *
     * @param idOrder - for order search
     * @return products. where the product is the key and value - the number of identical products in the order.

     * @throws DaoException if the search fails
     */
    Map<Product,Integer> findAllProductsFromOrder(int idOrder) throws DaoException;


}
