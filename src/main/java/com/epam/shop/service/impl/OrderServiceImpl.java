package com.epam.shop.service.impl;

import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.factory.FactoryDao;
import com.epam.shop.dao.model.Order;
import com.epam.shop.service.api.OrderService;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.converter.impl.OrderConverterImpl;
import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceOrderExceptionString;
import com.epam.shop.service.factory.FactoryService;
import com.epam.shop.service.validation.api.Validator;
import com.epam.shop.service.validation.impl.OrderValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private static OrderService instance;
    private final Validator<OrderDto, Integer> validatorInstance = OrderValidatorImpl.getInstance();
    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);
    private final Converter<OrderDto, Order, Integer> converter = OrderConverterImpl.getConverterInstance();


    private OrderServiceImpl() {
    }

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderServiceImpl();
        }
        return instance;
    }

    @Override
    public OrderDto create(OrderDto orderDto) throws ServiceException {

        try {

            validatorInstance.validate(orderDto);
            orderDto = calculateTheOrder(orderDto);
            AccountDto accountDto = FactoryService.getAccountServiceInstance().getById(orderDto.getUserId());
            accountDto.setAmount(accountDto.getAmount().subtract(orderDto.getOrderCost()));

            if (accountDto.getAmount().compareTo(BigDecimal.valueOf(0)) < 0) {

                throw new ServiceException(ServiceOrderExceptionString.ACCOUNT_AMOUNT_EXCEPTION);

            }
            FactoryService.getAccountServiceInstance().update(accountDto);
            orderDto = converter.convert(FactoryDao.getOrderImpl().save(converter.convert(orderDto)));

        } catch (DaoException e) {
            logger.error(ServiceOrderExceptionString.SAVE_ORDER_EXCEPTION, e);
            throw new ServiceException(ServiceOrderExceptionString.SAVE_ORDER_EXCEPTION, e);
        }

        return orderDto;
    }

    @Override
    public OrderDto update(OrderDto orderDto) throws ServiceException {

        try {

            orderDto = converter.convert(FactoryDao.getOrderImpl().update(converter.convert(orderDto)));

        } catch (DaoException e) {
            logger.error(ServiceOrderExceptionString.UPDATE_ORDER_EXCEPTION, e);
            throw new ServiceException(ServiceOrderExceptionString.UPDATE_ORDER_EXCEPTION, e);
        }

        return orderDto;
    }

    @Override
    public void delete(OrderDto orderDto) throws ServiceException {

        try {

            FactoryDao.getOrderImpl().delete(orderDto.getId());

        } catch (DaoException e) {
            logger.error(ServiceOrderExceptionString.DELETE_ORDER_EXCEPTION, e);
            throw new ServiceException(ServiceOrderExceptionString.DELETE_ORDER_EXCEPTION, e);
        }
    }

    @Override
    public OrderDto getById(Integer id) throws ServiceException {

        try {

            return converter.convert(FactoryDao.getOrderImpl().findById(id));

        } catch (DaoException e) {
            logger.error(ServiceOrderExceptionString.FIND_BY_ID_EXCEPTION);
            throw new ServiceException(ServiceOrderExceptionString.FIND_BY_ID_EXCEPTION);
        }

    }

    @Override
    public List<OrderDto> getAll() throws ServiceException {
        List<OrderDto> list = new ArrayList<>();
        try {

            for (Order order : FactoryDao.getOrderImpl().findAll()) {

                list.add(converter.convert(order));

            }
        } catch (DaoException e) {
            logger.error(ServiceOrderExceptionString.FIND_ALL_ORDERS_EXCEPTION);
            throw new ServiceException(ServiceOrderExceptionString.FIND_ALL_ORDERS_EXCEPTION);
        }
        return list;
    }

    @Override
    public OrderDto deleteProductFromOrder(int orderId, int productId) throws ServiceException {

        try {

            OrderDto order = converter.convert(FactoryDao.getOrderImpl().findById(orderId));

            order = FactoryService.getOrderServiceInstance().update(deleteProductFromMap(order, productId));

            return order;
        } catch (DaoException e) {
            logger.error(ServiceOrderExceptionString.DELETE_PRODUCT_FROM_ORDER_EXCEPTION);
            throw new ServiceException(ServiceOrderExceptionString.DELETE_PRODUCT_FROM_ORDER_EXCEPTION);
        }

    }

    @Override
    public List<OrderDto> findAccountOrders(AccountDto accountDto) throws ServiceException {

        try {
            List<OrderDto> list = new ArrayList<>();
            for (Order order : FactoryDao.getOrderImpl().findAll()) {
                if (order.getUserId().equals(accountDto.getId())) {
                    list.add(converter.convert(order));
                }
            }
            return list;
        } catch (DaoException e) {
            logger.error(ServiceOrderExceptionString.FIND_ALL_USER_ORDERS_EXCEPTION);
            throw new ServiceException(ServiceOrderExceptionString.FIND_ALL_USER_ORDERS_EXCEPTION);
        }


    }

    private OrderDto calculateTheOrder(OrderDto orderDto) {
        orderDto.setOrderCost(BigDecimal.ZERO);
        for (Map.Entry<ProductDto, Integer> entry : orderDto.getMapProducts().entrySet()) {
            int iteration = 0;

            while (entry.getValue() > iteration) {
                orderDto.setOrderCost(orderDto.getOrderCost().add(entry.getKey().getCost()));
                iteration++;
            }
        }
        return orderDto;
    }

    private OrderDto deleteProductFromMap(OrderDto orderDto, int productId) {
        boolean duplicate = false;
        ProductDto productDto = null;
        for (Map.Entry<ProductDto, Integer> entry : orderDto.getMapProducts().entrySet()) {
            if (entry.getKey().getId().equals(productId) && entry.getValue() > 1) {
                entry.setValue(entry.getValue() - 1);
                duplicate = true;
            }
            if (entry.getKey().getId().equals(productId)) {
                productDto = entry.getKey();
            }
        }
        if (!duplicate) {
            orderDto.getMapProducts().remove(productDto);
        }
        return orderDto;
    }

}
