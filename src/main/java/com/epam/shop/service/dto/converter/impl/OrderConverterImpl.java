package com.epam.shop.service.dto.converter.impl;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.Order;
import com.epam.shop.service.dto.converter.api.Converter;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.exception.ServiceException;

public class OrderConverterImpl implements Converter<OrderDto, Order,Integer> {
    @Override
    public OrderDto convert(Order model) throws ServiceException {
        return null;
    }

    @Override
    public Order convert(OrderDto modelDto) throws DaoException {
        return null;
    }
}
