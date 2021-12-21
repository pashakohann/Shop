package com.epam.shop.dao.api;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.Order;
import com.epam.shop.dao.model.Product;

import java.util.Map;

public interface OrderDao extends Dao<Order,Integer> {
    Map<Product,Integer> findAllProductsFromOrder(int idOrder) throws DaoException;


}
