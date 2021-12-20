package com.epam.shop.service.validation.validation_string;

public interface ProductValidationString {
    String PRODUCT_COST_REGEX = "^(([1-9]([0-9]{0,5})[.][0-9]{1})|([1-9]([0-9]{0,5})))$";
    Integer PRODUCT_NAME_SYMBOLS = 5;
    Integer SYMBOLS_IN_LINK = 200;
    String LINK_REGEX = "(.jpeg)$";
}
