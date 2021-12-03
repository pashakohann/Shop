package com.epam.shop.service.factory;


public class FactoryService {
    private static FactoryService instance;

    private FactoryService() {

    }

    public static FactoryService getInstance() {
        if (instance != null) {
            instance = new FactoryService();
        }
        return instance;
    }
}
