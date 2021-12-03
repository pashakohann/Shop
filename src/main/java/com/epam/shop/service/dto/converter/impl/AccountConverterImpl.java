package com.epam.shop.service.dto.converter.impl;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.Account;
import com.epam.shop.service.dto.converter.api.Converter;
import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.exception.ServiceException;

public class AccountConverterImpl implements Converter<AccountDto, Account,Integer> {
    @Override
    public AccountDto convert(Account model) throws ServiceException {
        return null;
    }

    @Override
    public Account convert(AccountDto modelDto) throws DaoException {
        return null;
    }
}
