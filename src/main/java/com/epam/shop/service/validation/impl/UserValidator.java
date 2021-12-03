package com.epam.shop.service.validation.impl;

import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.validation.api.Validator;

import java.rmi.ServerException;

public class UserValidator implements Validator<UserDto, Integer> {
    @Override
    public void validate(UserDto dto) throws ServerException {

    }

    private void checkUserName(String userName) {

    }

    private void checkPassword(String userName) {

    }


}
