package com.epam.shop.service.validation.impl;


import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.validation.api.Validator;



public class OrderValidator implements Validator<OrderDto,Integer> {
    private static  OrderValidator instance;

    private OrderValidator() {
    }


    public static OrderValidator getInstance() {
        if (instance == null) {
            instance = new OrderValidator();
        }
        return instance;
    }
    @Override
    public void validate(OrderDto dto) throws ServiceException {

    }
}
