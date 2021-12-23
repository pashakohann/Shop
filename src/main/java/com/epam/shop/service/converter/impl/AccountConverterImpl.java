package com.epam.shop.service.converter.impl;


import com.epam.shop.dao.model.Account;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.dto.model.AccountDto;

/**
 * @see Converter
 */
public class AccountConverterImpl implements Converter<AccountDto, Account, Integer> {
    private static Converter<AccountDto, Account, Integer> converterInstance;


    private AccountConverterImpl() {
    }

    public static Converter<AccountDto, Account, Integer> getConverterInstance() {
        if (converterInstance == null) {
            converterInstance = new AccountConverterImpl();
        }
        return converterInstance;
    }

    @Override
    public AccountDto convert(Account account) {
        return new AccountDto.Builder().withId(account.getId()).
                withFirstName(account.getFirstName()).withLastName(account.getLastName()).
                withDateOfBirth(account.getDateOfBirth()).withEmail(account.getEmail()).withCity(account.getCity()).
                withFlat(account.getFlat()).withTelephoneNumber(account.getTelephoneNumber()).withAmount(account.getAmount()).
                withAmount(account.getAmount()).withUserId(account.getUserId()).withStreet(account.getStreet()).build();
    }

    @Override
    public Account convert(AccountDto accountDto) {
        return new Account.Builder().withId(accountDto.getId()).
                withFirstName(accountDto.getFirstName()).withLastName(accountDto.getLastName()).
                withDateOfBirth(accountDto.getDateOfBirth()).withEmail(accountDto.getEmail()).withCity(accountDto.getCity()).
                withFlat(accountDto.getFlat()).withTelephoneNumber(accountDto.getTelephoneNumber()).withAmount(accountDto.getAmount()).
                withAmount(accountDto.getAmount()).withUserId(accountDto.getUserId()).withStreet(accountDto.getStreet()).build();
    }
}
