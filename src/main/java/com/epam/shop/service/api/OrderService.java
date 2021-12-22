package com.epam.shop.service.api;

import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.exception.ServiceException;


import java.util.List;


public interface OrderService extends Service<OrderDto, Integer> {

    OrderDto deleteProductFromOrder( int orderId,int productId) throws ServiceException;

    List<OrderDto> findAccountOrders(AccountDto accountDto) throws ServiceException;


}
