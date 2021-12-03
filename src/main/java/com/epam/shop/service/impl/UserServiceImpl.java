package com.epam.shop.service.impl;


import com.epam.shop.service.api.UserService;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.validation.api.Validator;
import com.epam.shop.service.validation.impl.UserValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserServiceImpl implements UserService {
    private static UserService instance;
    private Validator validatorInstance = UserValidatorImpl.getInstance();
    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);

    private UserServiceImpl() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public UserDto create(UserDto model) throws ServiceException {
        return null;
    }

    @Override
    public UserDto update(UserDto model) {
        return null;
    }

    @Override
    public void delete(UserDto model) {

    }

    @Override
    public UserDto getById(Integer id) {
        return null;
    }

    @Override
    public UserDto getAll() {
        return null;
    }
}
