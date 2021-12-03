package com.epam.shop.service.validation.impl;


import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.validation.api.Validator;



public class OrderValidatorImpl implements Validator<OrderDto,Integer> {
    private static OrderValidatorImpl instance;

    private OrderValidatorImpl() {
    }


    public static OrderValidatorImpl getInstance() {
        if (instance == null) {
            instance = new OrderValidatorImpl();
        }
        return instance;
    }
    @Override
    public void validate(OrderDto dto) throws ServiceException {

    }
}
