package com.epam.shop.dao.api;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.Order;
import com.epam.shop.dao.model.Product;

import java.util.Map;

public interface OrderDao extends Dao<Order,Integer> {
    Map<Product,Integer> findAllProductsFromOrder(Integer idOrder) throws DaoException;
    void addProductsInOrder(Order order)throws DaoException;
    void deleteAllProductInOrder(Integer orderId) throws DaoException;

}
