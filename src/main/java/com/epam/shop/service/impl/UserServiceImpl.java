package com.epam.shop.service.impl;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.factory.FactoryDao;
import com.epam.shop.dao.model.User;
import com.epam.shop.service.api.UserService;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.converter.impl.UserConverterImpl;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceUserExceptionString;
import com.epam.shop.service.security.api.Crypt;
import com.epam.shop.service.security.impl.CryptImpl;
import com.epam.shop.service.validation.api.Validator;
import com.epam.shop.service.validation.impl.UserValidatorImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserService instance;
    private final Validator<UserDto, Integer> validatorInstance = UserValidatorImpl.getInstance();
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private final Converter<UserDto, User, Integer> converter = UserConverterImpl.getConverterInstance();
    private final Crypt crypt = CryptImpl.getInstance();


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

        try {
            validatorInstance.validate(model);
            if (checkDuplicateUserName(model.getAccount())) {
                model.setPassword(crypt.encrypt(model.getPassword()));
                model.setRegistrationDate(LocalDateTime.now());
                model = converter.convert(FactoryDao.getUserImpl().save(converter.convert(model)));

                return model;

            } else {
                throw new ServiceException(ServiceUserExceptionString.CHECK_DUPLICATE_USER_NAME_EXCEPTION);
            }
        } catch (DaoException e) {
            logger.error(ServiceUserExceptionString.SAVE_USER_EXCEPTION, e);
            throw new ServiceException(ServiceUserExceptionString.SAVE_USER_EXCEPTION, e);
        }

    }

    @Override
    public UserDto update(UserDto userDto) throws ServiceException {

        try {
            validatorInstance.validate(userDto);
            userDto.setPassword(crypt.encrypt(userDto.getPassword()));
            FactoryDao.getUserImpl().update(converter.convert(userDto));

            return userDto;
        } catch (DaoException e) {
            logger.error(ServiceUserExceptionString.UPDATE_USER_EXCEPTION, e);
            throw new ServiceException(ServiceUserExceptionString.UPDATE_USER_EXCEPTION);
        }
    }

    @Override
    public void deleteUserById(int userId) throws ServiceException {

        try {

            FactoryDao.getUserImpl().delete(userId);

        } catch (DaoException e) {
            logger.error(ServiceUserExceptionString.DELETE_USER_EXCEPTION, e);
            throw new ServiceException(ServiceUserExceptionString.DELETE_USER_EXCEPTION, e);
        }
    }

    @Override
    public UserDto getById(Integer id) throws ServiceException {

        try {

            return converter.convert(FactoryDao.getUserImpl().findById(id));

        } catch (DaoException e) {
            logger.error(ServiceUserExceptionString.FIND_USER_BY_ID_EXCEPTION, e);
            throw new ServiceException(ServiceUserExceptionString.FIND_USER_BY_ID_EXCEPTION, e);
        }

    }

    @Override
    public List<UserDto> getAll() throws ServiceException {

        try {
            List<UserDto> listUserDto = new ArrayList<>();

            for (User user : FactoryDao.getUserImpl().findAll()) {
                listUserDto.add(converter.convert(user));
            }

            return listUserDto;

        } catch (DaoException e) {
            logger.error(ServiceUserExceptionString.FIND_ALL_USERS_EXCEPTION, e);
            throw new ServiceException(ServiceUserExceptionString.FIND_ALL_USERS_EXCEPTION, e);
        }

    }


    @Override
    public UserDto findUser(UserDto user) throws ServiceException {

        try {
            validatorInstance.validate(user);
            return checkPasswordAndUserName(user);

        } catch (ServiceException e) {
            logger.error(ServiceUserExceptionString.FIND_USER_EXCEPTION, e);
            throw new ServiceException(ServiceUserExceptionString.FIND_USER_EXCEPTION, e);
        }


    }

    private boolean checkDuplicateUserName(String userName) throws ServiceException {

        try {

            List<User> list = FactoryDao.getUserImpl().findAll();
            return list.stream().filter(user -> user.getAccount().equals(userName)).findFirst().isEmpty();

        } catch (DaoException e) {
            logger.error(ServiceUserExceptionString.FIND_ALL_USERS_EXCEPTION, e);
            throw new ServiceException(ServiceUserExceptionString.FIND_ALL_USERS_EXCEPTION, e);
        }

    }

    private UserDto checkPasswordAndUserName(UserDto user) throws ServiceException {

        try {
            UserDto userDto = converter.convert((FactoryDao.getUserImpl().findByUserName(converter.convert(user))));
            if (userDto.getId() == null) {
                throw new ServiceException(ServiceUserExceptionString.USER_IS_NOT_FOUND);
            } else if (!crypt.verify(user.getPassword(), userDto.getPassword())) {
                throw new ServiceException(ServiceUserExceptionString.CHECK_PASSWORD_EXCEPTION);
            }
            return userDto;
        } catch (DaoException e) {
            logger.error(ServiceUserExceptionString.FIND_USER_EXCEPTION, e);
            throw new ServiceException(ServiceUserExceptionString.FIND_USER_EXCEPTION, e);
        }

    }
}
