package com.epam.shop.service.converter.impl;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.Order;
import com.epam.shop.dao.model.Product;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.dto.model.ProductDto;

import java.util.ArrayList;
import java.util.List;

public class OrderConverterImpl implements Converter<OrderDto, Order, Integer> {
    private static Converter converterInstance;

    private OrderConverterImpl() {
    }

    public static OrderConverterImpl getConverterInstance() {
        if (converterInstance == null) {
            converterInstance = new OrderConverterImpl();
        }
        return (OrderConverterImpl) converterInstance;
    }


    @Override
    public OrderDto convert(Order model) throws DaoException {
        OrderDto orderDto = new OrderDto();
        List<ProductDto> listProducts = new ArrayList<>();
        for (Product product : model.getListProducts()) {
            listProducts.add((ProductDto) ProductConverterImpl.getConverterInstance().convert(product));
        }
        orderDto.setId(model.getId());
        orderDto.setListProducts(listProducts);
        orderDto.setOrderCost(model.getOrderCost());
        orderDto.setOrderDate(model.getOrderDate());
        orderDto.setUserId(model.getUserId());

        return orderDto;
    }

    @Override
    public Order convert(OrderDto modelDto) {
        Order order = new Order();
        List<Product> listProducts = new ArrayList<>();
        for (ProductDto product : modelDto.getListProducts()) {
            listProducts.add((Product) ProductConverterImpl.getConverterInstance().convert(product));
        }
        order.setId(modelDto.getId());
        order.setListProducts(listProducts);
        order.setOrderCost(modelDto.getOrderCost());
        order.setOrderDate(modelDto.getOrderDate());
        order.setUserId(modelDto.getUserId());

        return order;
    }
}
