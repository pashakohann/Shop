package com.epam.shop.service.impl;

import com.epam.shop.service.api.ProductService;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.converter.impl.ProductConverterImpl;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.validation.api.Validator;
import com.epam.shop.service.validation.impl.ProductValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductServiceImpl implements ProductService {
    private static ProductService instance;
    private Validator validatorInstance = ProductValidatorImpl.getInstance();
    private static Logger logger = LogManager.getLogger(ProductServiceImpl.class);
    private Converter converter = ProductConverterImpl.getConverterInstance();

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
