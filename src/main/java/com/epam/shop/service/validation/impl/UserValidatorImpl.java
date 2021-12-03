package com.epam.shop.service.validation.impl;

import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.validation.api.Validator;



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

    private void checkUserName(String userName) {

    }

    private void checkPassword(String userName) {

    }


}
