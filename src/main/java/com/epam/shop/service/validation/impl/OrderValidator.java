package com.epam.shop.service.validation.impl;


import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.validation.api.Validator;

import java.rmi.ServerException;

public class OrderValidator implements Validator<OrderDto,Integer> {
    @Override
    public void validate(OrderDto dto) throws ServerException {

    }
}
