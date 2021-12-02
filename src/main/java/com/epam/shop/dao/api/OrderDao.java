package com.epam.shop.dao.api;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.Order;
import com.epam.shop.dao.model.Product;

import java.util.List;

public interface OrderDao extends Dao<Order,Integer> {
    List<Product> findAllProductsFromOrder(Integer idOrder) throws DaoException;
    void addProductsInOrder(Order order)throws DaoException;
    void deleteAllProductInOrder(Integer orderId) throws DaoException;

}
