package com.epam.shop.service.validation.impl;

import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.validation.api.ValidatorController;

public class UserValidatorControllerImpl implements ValidatorController {
    private static final String USER_ID_EXCEPTION = "User doesn't exist";
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

        if (id == null || id.matches("0")) {
            throw new ServiceException(USER_ID_EXCEPTION);
        }
    }
}
