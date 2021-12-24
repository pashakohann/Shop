package com.epam.shop.service.validation.impl;

import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceProductExceptionString;
import com.epam.shop.service.validation.api.Validator;

import com.epam.shop.service.validation.validation_string.ProductValidationString;


public class ProductValidatorImpl implements Validator<ProductDto, Integer> {

    private static Validator<ProductDto, Integer> instance;

    private ProductValidatorImpl() {
    }


    public static Validator<ProductDto, Integer> getInstance() {
        if (instance == null) {
            instance = new ProductValidatorImpl();
        }
        return instance;
    }

    @Override
    public void validate(ProductDto dto) throws ServiceException {

        checkFillFields(dto);
        checkCostProduct(dto.getCost().toString());
        checkProductNameSymbols(dto.getName().length());
        checkSymbolsInLink(dto.getPhotoLink());
        checkFormatPhoto(dto.getPhotoLink());

    }

    private void checkCostProduct(String cost) throws ServiceException {

        if (!cost.matches(ProductValidationString.PRODUCT_COST_REGEX)) {
            throw new ServiceException(ServiceProductExceptionString.PRODUCT_COST_EXCEPTION);
        }
    }

    private void checkProductNameSymbols(int product) throws ServiceException {

        if (product < ProductValidationString.PRODUCT_NAME_SYMBOLS) {
            throw new ServiceException(ServiceProductExceptionString.PRODUCT_NAME_SYMBOLS_EXCEPTION);
        }
    }

    private void checkFillFields(ProductDto productDto) throws ServiceException {

        if (productDto.getBrandId() == null || productDto.getCategoryId() == null
                || productDto.getCost() == null || productDto.getName() == null) {
            throw new ServiceException(ServiceProductExceptionString.FILL_ALL_FIELDS_EXCEPTION);
        }
    }

    private void checkSymbolsInLink(String photoLink) throws ServiceException {
        if (photoLink.length() > ProductValidationString.SYMBOLS_IN_LINK){
            throw new ServiceException(ServiceProductExceptionString.SYMBOLS_IN_LINK_EXCEPTION);
        }
    }

    private void checkFormatPhoto(String photoLink) throws ServiceException {

        if(!photoLink.matches(ProductValidationString.LINK_REGEX)){
            throw new ServiceException(ServiceProductExceptionString.FORMAT_PHOTO_EXCEPTION);

        }

    }
}
