package com.epam.shop.service.api;

import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;


import java.util.List;
import java.util.Map;


public interface OrderService extends Service<OrderDto, Integer> {

    OrderDto deleteProductFromOrder( int orderId,int productId) throws ServiceException;

    List<OrderDto> findAccountOrders(AccountDto accountDto) throws ServiceException;

    List<ProductDto>returnListProduct(Map<ProductDto,Integer>mapProducts);

}
