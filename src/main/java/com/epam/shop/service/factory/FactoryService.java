package com.epam.shop.service.factory;


import com.epam.shop.service.api.AccountService;
import com.epam.shop.service.api.OrderService;
import com.epam.shop.service.api.ProductService;
import com.epam.shop.service.api.UserService;
import com.epam.shop.service.impl.AccountServiceImpl;
import com.epam.shop.service.impl.OrderServiceImpl;
import com.epam.shop.service.impl.ProductServiceImpl;
import com.epam.shop.service.impl.UserServiceImpl;

public class FactoryService {
    private static FactoryService instance;
    private static AccountService accountServiceInstance = AccountServiceImpl.getInstance();
    private static UserService userServiceInstance = UserServiceImpl.getInstance();
    private static ProductService productServiceInstance = ProductServiceImpl.getInstance();
    private static OrderService orderServiceInstance = OrderServiceImpl.getInstance();

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
