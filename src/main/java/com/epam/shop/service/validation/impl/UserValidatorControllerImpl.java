package com.epam.shop.service.validation.impl;

import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceUserExceptionString;
import com.epam.shop.service.validation.api.ValidatorController;
import com.epam.shop.service.validation.validation_string.UserValidationString;

public class UserValidatorControllerImpl implements ValidatorController {
    private static ValidatorController instance;

    private UserValidatorControllerImpl() {
    }

    public static ValidatorController getInstance() {
        if (instance == null) {
            instance = new UserValidatorControllerImpl();
            return instance;
        }
        return instance;
    }

    @Override
    public void validate(String parameter) throws ServiceException {
        checkId(parameter);
    }

    private void checkId(String id) throws ServiceException {

        if (id == null || id.matches(UserValidationString.ID_REGEX)) {
            throw new ServiceException(ServiceUserExceptionString.USER_ID_EXCEPTION);

        }
    }
}
