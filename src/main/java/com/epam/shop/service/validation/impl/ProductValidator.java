package com.epam.shop.service.validation.impl;

import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.validation.api.Validator;

import java.rmi.ServerException;

public class ProductValidator implements Validator<ProductDto, Integer> {
    private static ProductValidator instance;

    private ProductValidator() {
    }


    public static ProductValidator getInstance() {
        if (instance == null) {
            instance = new ProductValidator();
        }
        return instance;
    }

    @Override
    public void validate(ProductDto dto) throws ServerException {
        String PRODUCT_COST_REGEX = "^[1-9]([0-9]{0,5})[.][0-9]{2}$";
    }
}
