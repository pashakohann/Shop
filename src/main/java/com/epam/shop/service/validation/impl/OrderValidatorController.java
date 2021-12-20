package com.epam.shop.service.validation.impl;

import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.validation.api.ValidatorController;

public class OrderValidatorController implements ValidatorController {
    private static final String DEFAULT_PROFILE = "You need to fill profile before order";
    private static final String DEFAULT_PROFILE_BY_NAME = "default";
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
        if (name.matches(DEFAULT_PROFILE_BY_NAME)) {
            throw new ServiceException(DEFAULT_PROFILE);
        }
    }
}
