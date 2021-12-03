package com.epam.shop.service.dto.converter.impl;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.Product;
import com.epam.shop.service.dto.converter.api.Converter;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;

public class ProductConverterImpl implements Converter<ProductDto, Product,Integer> {
    @Override
    public ProductDto convert(Product model) throws ServiceException {
        return null;
    }

    @Override
    public Product convert(ProductDto modelDto) throws DaoException {
        return null;
    }
}
