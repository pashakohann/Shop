package com.epam.shop.service.validation.impl;

import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceUserExceptionString;
import com.epam.shop.service.validation.api.Validator;
import com.epam.shop.service.validation.validation_string.UserValidationString;

import java.rmi.ServerException;


public class UserValidatorImpl implements Validator<UserDto, Integer> {
    private static UserValidatorImpl instance;

    private UserValidatorImpl() {
    }


    public static UserValidatorImpl getInstance() {
        if (instance == null) {
            instance = new UserValidatorImpl();
        }
        return instance;
    }

    @Override
    public void validate(UserDto dto) throws ServiceException {

    }

    private void checkUserName(String userName) throws ServerException {
        if (!userName.matches(UserValidationString.USER_NAME_REGEX)) {
            throw new ServerException(ServiceUserExceptionString.USER_PASSWORD_EXCEPTION);
        }
    }

    private void checkPassword(String userPassword) throws ServerException {
        if (!userPassword.matches(UserValidationString.USER_PASSWORD_REGEX)) {
            throw new ServerException(ServiceUserExceptionString.USER_NAME_EXCEPTION);
        }
    }


}
