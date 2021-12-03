package com.epam.shop.service.validation.impl;

import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.validation.api.Validator;



public class UserValidator implements Validator<UserDto, Integer> {
    private static UserValidator instance;

    private UserValidator() {
    }


    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
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
