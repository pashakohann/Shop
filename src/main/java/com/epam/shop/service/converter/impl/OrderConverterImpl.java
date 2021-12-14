package com.epam.shop.service.converter.impl;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.Order;
import com.epam.shop.dao.model.Product;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.dto.model.ProductDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderConverterImpl implements Converter<OrderDto, Order, Integer> {
    private static Converter<OrderDto, Order, Integer> converterInstance;
    private static Converter<ProductDto, Product, Integer> converterProduct = ProductConverterImpl.getConverterInstance();

    private OrderConverterImpl() {
    }

    public static Converter<OrderDto, Order, Integer> getConverterInstance() {
        if (converterInstance == null) {
            converterInstance = new OrderConverterImpl();
        }
        return converterInstance;
    }


    @Override
    public OrderDto convert(Order model) throws DaoException {
        OrderDto orderDto = new OrderDto();
        Map<ProductDto, Integer> map = new HashMap<>();
        for (Map.Entry<Product, Integer> entry : model.getMapProducts().entrySet()) {
            map.put(converterProduct.convert(entry.getKey()), entry.getValue());
        }
        orderDto.setId(model.getId());
        orderDto.setMapProducts(map);
        orderDto.setOrderCost(model.getOrderCost());
        orderDto.setOrderDate(model.getOrderDate());
        orderDto.setUserId(model.getUserId());

        return orderDto;
    }

    @Override
    public Order convert(OrderDto modelDto) {
        Order order = new Order();
        Map<Product, Integer> map = new HashMap<>();
        for (Map.Entry<ProductDto, Integer> entry : modelDto.getMapProducts().entrySet()) {
            map.put(converterProduct.convert(entry.getKey()), entry.getValue());
        }
        order.setId(modelDto.getId());
        order.setMapProducts(map);
        order.setOrderCost(modelDto.getOrderCost());
        order.setOrderDate(modelDto.getOrderDate());
        order.setUserId(modelDto.getUserId());

        return order;
    }
}
