package com.epam.shop.service.api;

import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;

import java.rmi.ServerException;
import java.util.List;


public interface OrderService extends Service<OrderDto, Integer> {
    OrderDto addProductInOrder(ProductDto productDto, OrderDto orderDto) throws ServiceException;

    OrderDto deleteProductFromOrder(ProductDto productDto, OrderDto orderDto) throws ServiceException;

    List<OrderDto> findAccountOrders(AccountDto accountDto) throws ServiceException;


}
