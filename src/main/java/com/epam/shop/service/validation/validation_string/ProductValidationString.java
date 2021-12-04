package com.epam.shop.service.validation.validation_string;

public interface ProductValidationString {
    String PRODUCT_COST_REGEX = "^[1-9]([0-9]{0,5})[.][0-9]{1}$";
    Integer PRODUCT_NAME_SYMBOLS = 5;
}
