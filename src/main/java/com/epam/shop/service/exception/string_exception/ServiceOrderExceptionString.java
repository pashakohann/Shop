package com.epam.shop.service.exception.string_exception;


/**
 * Exception strings for our order implementation on the services layer
 */
public interface ServiceOrderExceptionString {
    String NUMBER_OF_PRODUCTS_IN_ORDER_EXCEPTION = "The order must contain products";
    String SAVE_ORDER_EXCEPTION = "Failed to save order";
    String DELETE_PRODUCT_FROM_ORDER_EXCEPTION = "Failed to delete product from order";
    String DELETE_ORDER_EXCEPTION = "Failed to delete order";
    String UPDATE_ORDER_EXCEPTION = "Failed to update order";
    String FIND_BY_ID_EXCEPTION = "Failed to find order";
    String FIND_ALL_ORDERS_EXCEPTION = "Failed to find orders";
    String FIND_ALL_USER_ORDERS_EXCEPTION = "Failed to find orders";
    String ACCOUNT_AMOUNT_EXCEPTION = "You don't have enough money in your account";
    String FILL_PROFILE_EXCEPTION = "You need to fill profile before order";


}
