package com.epam.shop.service.validation.impl;


import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceOrderExceptionString;
import com.epam.shop.service.validation.api.Validator;
import com.epam.shop.service.validation.validation_string.OrderValidationString;


public class OrderValidatorImpl implements Validator<OrderDto, Integer> {
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
        checkOrder(dto);
    }

    private void checkOrder(OrderDto orderDto) throws ServiceException {
        if (orderDto.getListProducts()==null ||orderDto.getListProducts().size() < OrderValidationString.CHECK_ORDER) {
            throw new ServiceException(ServiceOrderExceptionString.NUMBER_OF_PRODUCTS_IN_ORDER_EXCEPTION);
        }
    }
}
