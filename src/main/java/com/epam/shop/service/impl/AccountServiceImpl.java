package com.epam.shop.service.impl;

import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.factory.FactoryDao;
import com.epam.shop.dao.model.Account;
import com.epam.shop.service.api.AccountService;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.converter.impl.AccountConverterImpl;
import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceAccountExceptionString;
import com.epam.shop.service.validation.api.Validator;
import com.epam.shop.service.validation.impl.AccountValidatorImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @see AccountService
 * @see com.epam.shop.service.api.Service
 * this class is assigned default values when creating.
 */
public class AccountServiceImpl implements AccountService {
    private static AccountService instance;
    private final Validator<AccountDto, Integer> validatorInstance = AccountValidatorImpl.getInstance();
    private static final Logger logger = LogManager.getLogger(AccountServiceImpl.class);
    private final Converter<AccountDto, Account, Integer> converter = AccountConverterImpl.getConverterInstance();

    private static final String DEFAULT_VALUE_FOR_NAME = "default";
    private static final String DEFAULT_VALUE_FOR_LAST_NAME = "default";
    private static final String DEFAULT_VALUE_FOR_STREET = "default";
    private static final String DEFAULT_VALUE_FOR_TELEPHONE_NUMBER = "default";
    private static final String DEFAULT_VALUE_FOR_EMAIL = "default";
    private static final String DEFAULT_VALUE_FOR_CITY = "default";
    private static final Integer DEFAULT_VALUE_FOR_FLAT = 0;

    private AccountServiceImpl() {
    }

    public static AccountService getInstance() {
        if (instance == null) {
            instance = new AccountServiceImpl();
        }
        return instance;
    }

    @Override
    public AccountDto create(AccountDto account) throws ServiceException {
        try {

            account.setDateOfBirth(LocalDate.now());
            account.setStreet(DEFAULT_VALUE_FOR_STREET);
            account.setFirstName(DEFAULT_VALUE_FOR_NAME);
            account.setLastName(DEFAULT_VALUE_FOR_LAST_NAME);
            account.setFlat(DEFAULT_VALUE_FOR_FLAT);
            account.setEmail(DEFAULT_VALUE_FOR_EMAIL);
            account.setTelephoneNumber(DEFAULT_VALUE_FOR_TELEPHONE_NUMBER);
            account.setCity(DEFAULT_VALUE_FOR_CITY);
            account.setAmount(BigDecimal.ZERO);
            account.setId(0);
            account = converter.convert(FactoryDao.getAccountImpl().save(converter.convert(account)));
        } catch (DaoException e) {

            logger.error(ServiceAccountExceptionString.CREATE_ACCOUNT_FOR_USER, e);
            throw new ServiceException(ServiceAccountExceptionString.CREATE_ACCOUNT_FOR_USER, e);
        }

        return account;
    }

    @Override
    public AccountDto update(AccountDto accountDto) throws ServiceException {

        try {

            FactoryDao.getAccountImpl().update(converter.convert(accountDto));

        } catch (DaoException e) {

            logger.error(ServiceAccountExceptionString.UPDATE_ACCOUNT, e);
            throw new ServiceException(ServiceAccountExceptionString.UPDATE_ACCOUNT, e);
        }

        return accountDto;
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

        try {
            return converter.convert(FactoryDao.getAccountImpl().findById(id));
        } catch (DaoException e) {
            logger.error(ServiceAccountExceptionString.FIND_BY_ID_ACCOUNT, e);
            throw new ServiceException(ServiceAccountExceptionString.FIND_BY_ID_ACCOUNT, e);
        }

    }

    public AccountDto findByUserId(int userId) throws ServiceException {

        try {
            return converter.convert(FactoryDao.getAccountImpl().findByUserId(userId));
        } catch (DaoException e) {
            logger.error(ServiceAccountExceptionString.FIND_BY_USER_ID_ACCOUNT, e);
            throw new ServiceException(ServiceAccountExceptionString.FIND_BY_USER_ID_ACCOUNT, e);
        }

    }

    @Override
    public List<AccountDto> getAll() throws ServiceException {

        try {
            List<Account> listAccount = FactoryDao.getAccountImpl().findAll();
            List<AccountDto> listAccountDto = new ArrayList<>();

            for (Account account : listAccount) {
                listAccountDto.add(converter.convert(account));
            }

            return listAccountDto;

        } catch (DaoException e) {
            logger.error(ServiceAccountExceptionString.FIND_ALL_ACCOUNTS, e);
            throw new ServiceException(ServiceAccountExceptionString.FIND_ALL_ACCOUNTS, e);
        }

    }
}
