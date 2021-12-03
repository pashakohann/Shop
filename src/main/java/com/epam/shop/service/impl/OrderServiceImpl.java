package com.epam.shop.service.impl;

import com.epam.shop.service.api.OrderService;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.exception.ServiceException;

public class OrderServiceImpl implements OrderService {
    private static OrderService instance;

    private OrderServiceImpl() {
    }

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderServiceImpl();
        }
        return instance;
    }

    @Override
    public OrderDto create(OrderDto model) throws ServiceException {
        return null;
    }

    @Override
    public OrderDto update(OrderDto model) {
        return null;
    }

    @Override
    public void delete(OrderDto model) {

    }

    @Override
    public OrderDto getById(Integer id) {
        return null;
    }

    @Override
    public OrderDto getAll() {
        return null;
    }
}
