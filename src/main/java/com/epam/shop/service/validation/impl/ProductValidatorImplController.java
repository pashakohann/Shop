package com.epam.shop.service.validation.impl;

import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceProductExceptionString;
import com.epam.shop.service.validation.api.ValidatorController;
import com.epam.shop.service.validation.validation_string.ProductValidationString;

public class ProductValidatorImplController implements ValidatorController {
    private static ValidatorController instance;

    private ProductValidatorImplController() {
    }

    public static ValidatorController getInstance() {
        if (instance == null) {
            instance = new ProductValidatorImplController();
            return instance;
        }
        return instance;
    }

    @Override
    public void validate(String parameter) throws ServiceException {
        String[] fields = parameter.split(ProductValidationString.SPLIT_STRING_REGEX);

        checkQuantityFields(fields.length);

    }


    private void checkQuantityFields(int quantity) throws ServiceException {
        if (quantity < ProductValidationString.QUANTITY_FIELDS) {
            throw new ServiceException(ServiceProductExceptionString.FILL_FIELDS_EXCEPTION);
        }
    }
}
