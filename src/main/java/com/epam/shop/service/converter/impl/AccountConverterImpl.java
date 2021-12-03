package com.epam.shop.service.converter.impl;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.Account;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.dto.model.AccountDto;


public class AccountConverterImpl implements Converter<AccountDto, Account, Integer> {
    private static Converter converterInstance;


    private AccountConverterImpl() {
    }

    public static Converter getConverterInstance() {
        if (converterInstance == null) {
            converterInstance = new AccountConverterImpl();
        }
        return converterInstance;
    }

    @Override
    public AccountDto convert(Account model) throws DaoException {
        return new AccountDto.Builder().withId(model.getId()).
                withFirstName(model.getFirstName()).withLastName(model.getLastName()).
                withDateOfBirth(model.getDateOfBirth()).withEmail(model.getEmail()).withCity(model.getCity()).
                withFlat(model.getFlat()).withTelephoneNumber(model.getTelephoneNumber()).withAmount(model.getAmount()).
                withAmount(model.getAmount()).withUserId(model.getUserId()).build();
    }

    @Override
    public Account convert(AccountDto modelDto) {
        return new Account.Builder().withId(modelDto.getId()).
                withFirstName(modelDto.getFirstName()).withLastName(modelDto.getLastName()).
                withDateOfBirth(modelDto.getDateOfBirth()).withEmail(modelDto.getEmail()).withCity(modelDto.getCity()).
                withFlat(modelDto.getFlat()).withTelephoneNumber(modelDto.getTelephoneNumber()).withAmount(modelDto.getAmount()).
                withAmount(modelDto.getAmount()).withUserId(modelDto.getUserId()).build();
    }
}
