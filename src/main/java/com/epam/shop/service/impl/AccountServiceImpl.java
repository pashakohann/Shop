package com.epam.shop.service.impl;

import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.factory.FactoryDao;
import com.epam.shop.dao.model.Account;
import com.epam.shop.service.api.AccountService;
import com.epam.shop.service.converter.impl.AccountConverterImpl;
import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceAccountExceptionString;
import com.epam.shop.service.validation.api.Validator;
import com.epam.shop.service.validation.impl.AccountValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private static AccountService instance;
    private Validator validatorInstance = AccountValidatorImpl.getInstance();
    private static Logger logger = LogManager.getLogger(AccountServiceImpl.class);
    private AccountConverterImpl converter = AccountConverterImpl.getConverterInstance();

    private AccountServiceImpl() {
    }

    public static AccountService getInstance() {
        if (instance == null) {
            instance = new AccountServiceImpl();
        }
        return instance;
    }

    @Override
    public AccountDto create(AccountDto model) throws ServiceException {
        try {
            FactoryDao.getAccountImpl().save(converter.convert(model));
        } catch (DaoException e) {
            logger.error(ServiceAccountExceptionString.CREATE_ACCOUNT_FOR_USER, e);
            throw new ServiceException(ServiceAccountExceptionString.CREATE_ACCOUNT_FOR_USER, e);

        }
        return model;
    }

    @Override
    public AccountDto update(AccountDto model) throws ServiceException {
        validatorInstance.validate(model);
        try {
            FactoryDao.getAccountImpl().update(converter.convert(model));
        } catch (DaoException e) {
            logger.error(ServiceAccountExceptionString.UPDATE_ACCOUNT, e);
            throw new ServiceException(ServiceAccountExceptionString.UPDATE_ACCOUNT, e);
        } catch (NullPointerException e) {
            logger.error(ServiceAccountExceptionString.FILL_FIELDS_EXCEPTION, e);
            throw new ServiceException(ServiceAccountExceptionString.FILL_FIELDS_EXCEPTION, e);
        }
        return model;
    }

    @Override
    public void delete(AccountDto model) throws ServiceException {
        try {
            FactoryDao.getAccountImpl().delete(model.getId());
        } catch (DaoException e) {
            logger.error(ServiceAccountExceptionString.DELETE_ACCOUNT, e);
            throw new ServiceException(ServiceAccountExceptionString.DELETE_ACCOUNT, e);
        }
    }

    @Override
    public AccountDto getById(Integer id) throws ServiceException {
        AccountDto accountDto;
        try {
            accountDto = converter.convert(FactoryDao.getAccountImpl().findById(id));
        } catch (DaoException e) {
            logger.error(ServiceAccountExceptionString.FIND_BY_ID_ACCOUNT, e);
            throw new ServiceException(ServiceAccountExceptionString.FIND_BY_ID_ACCOUNT, e);
        }
        return accountDto;
    }

    @Override
    public List<AccountDto> getAll() throws ServiceException {
        List<AccountDto> listAccountDto;
        List<Account> listAccount;
        try {
            listAccount = FactoryDao.getAccountImpl().findAll();
            listAccountDto = new ArrayList<>();
            for (Account account : listAccount) {
                listAccountDto.add(converter.convert(account));
            }
        } catch (DaoException e) {
            logger.error(ServiceAccountExceptionString.FIND_ALL_ACCOUNTS, e);
            throw new ServiceException(ServiceAccountExceptionString.FIND_ALL_ACCOUNTS, e);
        }

        return listAccountDto;
    }
}
