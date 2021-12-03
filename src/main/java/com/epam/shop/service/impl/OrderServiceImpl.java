package com.epam.shop.service.impl;

import com.epam.shop.service.api.OrderService;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.converter.impl.OrderConverterImpl;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.validation.api.Validator;
import com.epam.shop.service.validation.impl.OrderValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderServiceImpl implements OrderService {
    private static OrderService instance;
    private Validator validatorInstance = OrderValidatorImpl.getInstance();
    private static Logger logger = LogManager.getLogger(OrderServiceImpl.class);
    private Converter converter = OrderConverterImpl.getConverterInstance();

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
