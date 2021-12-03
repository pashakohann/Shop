package com.epam.shop.service.impl;

import com.epam.shop.service.api.AccountService;
import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.validation.api.Validator;
import com.epam.shop.service.validation.impl.AccountValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AccountServiceImpl implements AccountService {
    private static AccountService instance;
    private Validator validatorInstance = AccountValidatorImpl.getInstance();
    private static Logger logger = LogManager.getLogger(AccountServiceImpl.class);

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
           validatorInstance.validate(model);
        return null;
    }

    @Override
    public AccountDto update(AccountDto model) {
        return null;
    }

    @Override
    public void delete(AccountDto model) {

    }

    @Override
    public AccountDto getById(Integer id) {
        return null;
    }

    @Override
    public AccountDto getAll() {
        return null;
    }
}
