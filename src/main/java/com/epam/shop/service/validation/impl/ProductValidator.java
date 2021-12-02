package com.epam.shop.service.validation.impl;

import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.validation.api.Validator;

import java.rmi.ServerException;

public class ProductValidator  implements Validator<ProductDto,Integer> {
    @Override
    public void validate(ProductDto dto) throws ServerException {

    }
}
