package com.epam.shop.service.validation.impl;

import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.validation.api.Validator;



public class ProductValidatorImpl implements Validator<ProductDto, Integer> {
    private static ProductValidatorImpl instance;

    private ProductValidatorImpl() {
    }


    public static ProductValidatorImpl getInstance() {
        if (instance == null) {
            instance = new ProductValidatorImpl();
        }
        return instance;
    }

    @Override
    public void validate(ProductDto dto) throws ServiceException {
        String PRODUCT_COST_REGEX = "^[1-9]([0-9]{0,5})[.][0-9]{2}$";
    }
}
