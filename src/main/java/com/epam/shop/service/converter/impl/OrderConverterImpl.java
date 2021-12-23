package com.epam.shop.service.converter.impl;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.Order;
import com.epam.shop.dao.model.Product;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.dto.model.ProductDto;


import java.util.HashMap;
import java.util.Map;
/**
 * @see Converter
 */
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
    public OrderDto convert(Order order) throws DaoException {
        OrderDto orderDto = new OrderDto();
        Map<ProductDto, Integer> map = new HashMap<>();
        for (Map.Entry<Product, Integer> entry : order.getMapProducts().entrySet()) {
            map.put(converterProduct.convert(entry.getKey()), entry.getValue());
        }
        orderDto.setId(order.getId());
        orderDto.setMapProducts(map);
        orderDto.setOrderCost(order.getOrderCost());
        orderDto.setOrderDate(order.getOrderDate());
        orderDto.setUserId(order.getUserId());

        return orderDto;
    }

    @Override
    public Order convert(OrderDto orderDto) {
        Order order = new Order();
        Map<Product, Integer> map = new HashMap<>();
        for (Map.Entry<ProductDto, Integer> entry : orderDto.getMapProducts().entrySet()) {
            map.put(converterProduct.convert(entry.getKey()), entry.getValue());
        }
        order.setId(orderDto.getId());
        order.setMapProducts(map);
        order.setOrderCost(orderDto.getOrderCost());
        order.setOrderDate(orderDto.getOrderDate());
        order.setUserId(orderDto.getUserId());

        return order;
    }
}
