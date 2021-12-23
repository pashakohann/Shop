package com.epam.shop.service.api;

import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;


import java.util.List;
import java.util.Map;

/**
 * @see Service
 */
public interface OrderService extends Service<OrderDto, Integer> {

    /**
     *
     * @param orderId order id
     * @param productId product id Which needs to be removed from this order
     * @return Returns an updated order
     * @throws ServiceException if to failed to delete product from order
     */
    OrderDto deleteProductFromOrder( int orderId,int productId) throws ServiceException;


    /**
     *
     * @param accountDto find by profile, all his orders
     * @return all orders
     * @throws ServiceException if failed to get orders
     */
    List<OrderDto> findAccountOrders(AccountDto accountDto) throws ServiceException;


    /**
     *
     * @param mapProducts converts to list
     * @return list with products
     */
    List<ProductDto>returnListProduct(Map<ProductDto,Integer>mapProducts);

}
