package com.epam.shop.dao.factory;

import com.epam.shop.dao.api.AccountDao;
import com.epam.shop.dao.api.OrderDao;
import com.epam.shop.dao.api.ProductDao;
import com.epam.shop.dao.api.UserDao;
import com.epam.shop.dao.impl.AccountDaoImpl;
import com.epam.shop.dao.impl.OrderDaoImpl;
import com.epam.shop.dao.impl.ProductDaoImpl;
import com.epam.shop.dao.impl.UserDaoImpl;

/**
 * The factory pattern has been implemented
 * for a convenient opportunity to use different implementations at the dao level.
 * And The Factory Method pattern allows the
 * system to remain independent of both the process of generating objects and their types.
 */
public class FactoryDao {

    private static FactoryDao factoryDao;
    private static final AccountDao accountImpl = AccountDaoImpl.getInstance();
    private static final ProductDao productImpl = ProductDaoImpl.getInstance();
    private static final UserDao userImpl = UserDaoImpl.getInstance();
    private static final OrderDao orderImpl = OrderDaoImpl.getInstance();


    private FactoryDao() {

    }

    public static FactoryDao getInstance() {
        if (factoryDao != null) {
            factoryDao = new FactoryDao();
        }
        return factoryDao;
    }


    public static AccountDao getAccountImpl() {
        return accountImpl;
    }

    public static ProductDao getProductImpl() {
        return productImpl;
    }

    public static OrderDao getOrderImpl() {
        return orderImpl;
    }

    public static UserDao getUserImpl() {
        return userImpl;
    }
}
