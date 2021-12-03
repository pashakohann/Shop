package com.epam.shop.service.impl;

import com.epam.shop.service.api.ProductService;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;

public class ProductServiceImpl implements ProductService {
    private static ProductService instance;

    private ProductServiceImpl() {
    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    @Override
    public ProductDto create(ProductDto model) throws ServiceException {
        return null;
    }

    @Override
    public ProductDto update(ProductDto model) {
        return null;
    }

    @Override
    public void delete(ProductDto model) {

    }

    @Override
    public ProductDto getById(Integer id) {
        return null;
    }

    @Override
    public ProductDto getAll() {
        return null;
    }


}
