package com.epam.shop.service.validation.impl;

import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceUserExceptionString;
import com.epam.shop.service.validation.api.Validator;
import com.epam.shop.service.validation.validation_string.UserValidationString;


public class UserValidatorImpl implements Validator<UserDto, Integer> {
    private static Validator<UserDto, Integer> instance;

    private UserValidatorImpl() {
    }


    public static Validator<UserDto, Integer> getInstance() {
        if (instance == null) {
            instance = new UserValidatorImpl();
        }
        return instance;
    }

    @Override
    public void validate(UserDto dto) throws ServiceException {
        checkUserName(dto.getAccount());
        checkPassword(dto.getPassword());

    }

    private void checkUserName(String userName) throws ServiceException {
        if (!userName.matches(UserValidationString.USER_NAME_REGEX)) {
            throw new ServiceException(ServiceUserExceptionString.USER_NAME_EXCEPTION);
        }
    }

    private void checkPassword(String userPassword) throws ServiceException {
        if (!userPassword.matches(UserValidationString.USER_PASSWORD_REGEX)) {
            throw new ServiceException(ServiceUserExceptionString.USER_PASSWORD_EXCEPTION);
        }
    }


}
