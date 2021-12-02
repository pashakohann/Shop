package com.epam.shop.service.validation.impl;

import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.validation.api.Validator;

import java.rmi.ServerException;

public class AccountValidator implements Validator<AccountDto,Integer> {
    @Override
    public void validate(AccountDto dto) throws ServerException {

    }
}
