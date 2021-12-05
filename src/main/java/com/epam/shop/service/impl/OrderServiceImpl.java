package com.epam.shop.service.impl;

import com.epam.shop.dao.connection_pool.impl.ConnectionPoolImpl;
import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.factory.FactoryDao;
import com.epam.shop.dao.model.Order;
import com.epam.shop.dao.model.Product;
import com.epam.shop.service.api.OrderService;
import com.epam.shop.service.converter.impl.OrderConverterImpl;
import com.epam.shop.service.converter.impl.ProductConverterImpl;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceOrderExceptionString;
import com.epam.shop.service.validation.api.Validator;
import com.epam.shop.service.validation.impl.OrderValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static OrderService instance;
    private Validator validatorInstance = OrderValidatorImpl.getInstance();
    private static Logger logger = LogManager.getLogger(OrderServiceImpl.class);
    private OrderConverterImpl converter = OrderConverterImpl.getConverterInstance();
    private static ProductConverterImpl convertProduct = ProductConverterImpl.getConverterInstance();


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
        validatorInstance.validate(model);
        for (ProductDto product : model.getListProducts()) {
            model.setOrderCost(product.getCost() + model.getOrderCost());
        }
        try {
            model = converter.convert(FactoryDao.getOrderImpl().save(converter.convert(model)));
        } catch (DaoException e) {
            logger.error(ServiceOrderExceptionString.SAVE_ORDER_EXCEPTION, e);
            throw new ServiceException(ServiceOrderExceptionString.SAVE_ORDER_EXCEPTION, e);
        }


        return model;
    }

    @Override
    public OrderDto update(OrderDto model) throws ServiceException {
        validatorInstance.validate(model);
        try {
            for (ProductDto product : model.getListProducts()) {
                model.setOrderCost(0.0);
                model.setOrderCost(product.getCost() + model.getOrderCost());
            }
            model = converter.convert(FactoryDao.getOrderImpl().update(converter.convert(model)));
        } catch (DaoException e) {
            logger.error(ServiceOrderExceptionString.UPDATE_ORDER_EXCEPTION, e);
            throw new ServiceException(ServiceOrderExceptionString.UPDATE_ORDER_EXCEPTION, e);
        }

        return model;
    }

    @Override
    public void delete(OrderDto model) throws ServiceException {
        try {
            FactoryDao.getOrderImpl().delete(model.getUserId());
        } catch (DaoException e) {
            logger.error(ServiceOrderExceptionString.DELETE_ORDER_EXCEPTION, e);
            throw new ServiceException(ServiceOrderExceptionString.DELETE_ORDER_EXCEPTION, e);
        }
    }

    @Override
    public OrderDto getById(Integer id) throws ServiceException {
        OrderDto orderDto;
        try {
            orderDto = converter.convert(FactoryDao.getOrderImpl().findById(id));
        } catch (DaoException e) {
            logger.error(ServiceOrderExceptionString.FIND_BY_ID_EXCEPTION);
            throw new ServiceException(ServiceOrderExceptionString.FIND_BY_ID_EXCEPTION);
        }
        return orderDto;
    }

    @Override
    public List<OrderDto> getAll() throws ServiceException {
        List<OrderDto> list = new ArrayList<>();
        try {
            for (Order order : FactoryDao.getOrderImpl().findAll()
            ) {
                list.add(converter.convert(order));

            }
        } catch (DaoException e) {
            logger.error(ServiceOrderExceptionString.FIND_ALL_ORDERS_EXCEPTION);
            throw new ServiceException(ServiceOrderExceptionString.FIND_ALL_ORDERS_EXCEPTION);
        }
        return list;
    }

    @Override
    public OrderDto addProductInOrder(ProductDto productDto, OrderDto orderDto) throws ServiceException {
        List<ProductDto> list = orderDto.getListProducts();
        list.add(productDto);
        orderDto.setOrderCost(orderDto.getOrderCost() + productDto.getCost());
        orderDto.setListProducts(list);
        try {
            FactoryDao.getOrderImpl().addProductsInOrder(converter.convert(orderDto));
        } catch (DaoException e) {
            logger.error(ServiceOrderExceptionString.ADD_PRODUCT_IN_ORDER_EXCEPTION);
            throw new ServiceException(ServiceOrderExceptionString.ADD_PRODUCT_IN_ORDER_EXCEPTION);
        }


        return orderDto;
    }

    @Override
    public OrderDto deleteProductFromOrder(ProductDto productDto, OrderDto orderDto) throws ServiceException {
        List<ProductDto> listProduct = new ArrayList<>();
        OrderDto order;
        try {
            for (Product product : FactoryDao.getOrderImpl().findById(orderDto.getId()).getListProducts()) {
                if (!productDto.getId().equals(product.getId())) {
                    listProduct.add(convertProduct.convert(product));
                } else {
                    orderDto.setOrderCost(orderDto.getOrderCost() - product.getCost());
                }
            }
            order = converter.convert(FactoryDao.getOrderImpl().findById(orderDto.getId()));
        } catch (DaoException e) {
            logger.error(ServiceOrderExceptionString.DELETE_PRODUCT_FROM_ORDER_EXCEPTION);
            throw new ServiceException(ServiceOrderExceptionString.DELETE_PRODUCT_FROM_ORDER_EXCEPTION);
        }
        return order;
    }

    @Override
    public List<OrderDto> findUserOrders(UserDto userDto) throws ServiceException {
        List<OrderDto> list = new ArrayList<>();
        try {
            for (Order order : FactoryDao.getOrderImpl().findAll()) {
                if (order.getUserId().equals(userDto.getId())) {
                    list.add(converter.convert(order));
                }
            }
        } catch (DaoException e) {
            logger.error(ServiceOrderExceptionString.FIND_ALL_USER_ORDERS_EXCEPTION);
            throw new ServiceException(ServiceOrderExceptionString.FIND_ALL_USER_ORDERS_EXCEPTION);
        }


        return list;
    }
}
