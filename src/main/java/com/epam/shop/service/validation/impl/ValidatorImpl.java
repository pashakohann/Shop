package com.epam.shop.service.validation.impl;

import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.validation.api.Validator;

import java.rmi.ServerException;

public class ValidatorImpl implements Validator<UserDto> {
    private static final int MIN_ACCOUNT_LENGTH = 5;
    private static final int MIN_PASSWORD_LENGTH = 8;
    @Override
    public void validate(UserDto userDto) throws ServerException {
     validateAccount(userDto.getAccount());
     validatePassword(userDto.getPassword());
    }

    private void validateAccount(String account) throws ServerException {
          if(account.length() < 5){
        throw new ServerException("Account must more 5 symbols");
          }
    }

    private void validatePassword(String password){
        if(password.length() < 8){

        }
    }
}
