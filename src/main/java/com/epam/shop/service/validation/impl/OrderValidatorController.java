package com.epam.shop.service.validation.impl;

import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceOrderExceptionString;
import com.epam.shop.service.validation.api.ValidatorController;
import com.epam.shop.service.validation.validation_string.OrderValidationString;

public class OrderValidatorController implements ValidatorController {

    private static ValidatorController instance;


    private OrderValidatorController() {
    }

    public static ValidatorController getInstance() {
        if (instance == null) {
            instance = new OrderValidatorController();
        }
        return instance;
    }

    @Override
    public void validate(String parameter) throws ServiceException {

        validateDefaultField(parameter);
    }


    private void validateDefaultField(String name) throws ServiceException {

        if (name.matches(OrderValidationString.DEFAULT_PROFILE_BY_NAME)) {

            throw new ServiceException(ServiceOrderExceptionString.FILL_PROFILE_EXCEPTION);
        }
    }
}
