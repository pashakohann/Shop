package com.epam.shop.service.factory;


import com.epam.shop.service.api.AccountService;
import com.epam.shop.service.api.OrderService;
import com.epam.shop.service.api.ProductService;
import com.epam.shop.service.api.UserService;
import com.epam.shop.service.impl.AccountServiceImpl;
import com.epam.shop.service.impl.OrderServiceImpl;
import com.epam.shop.service.impl.ProductServiceImpl;
import com.epam.shop.service.impl.UserServiceImpl;
/**
 * The factory pattern has been implemented
 * for a convenient opportunity to use different implementations at the dao level.
 * And The Factory Method pattern allows the
 * system to remain independent of both the process of generating objects and their types.
 */
public class FactoryService {
    private static FactoryService instance;
    private static final AccountService accountServiceInstance = AccountServiceImpl.getInstance();
    private static final UserService userServiceInstance = UserServiceImpl.getInstance();
    private static final ProductService productServiceInstance = ProductServiceImpl.getInstance();
    private static final OrderService orderServiceInstance = OrderServiceImpl.getInstance();

    private FactoryService() {

    }

    public static FactoryService getInstance() {
        if (instance != null) {
            instance = new FactoryService();
        }
        return instance;
    }

    public static AccountService getAccountServiceInstance() {
        return accountServiceInstance;
    }

    public static UserService getUserServiceInstance() {
        return userServiceInstance;
    }

    public static ProductService getProductServiceInstance() {
        return productServiceInstance;
    }

    public static OrderService getOrderServiceInstance() {
        return orderServiceInstance;
    }
}
