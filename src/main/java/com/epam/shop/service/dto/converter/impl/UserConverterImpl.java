package com.epam.shop.service.dto.converter.impl;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.User;
import com.epam.shop.service.dto.converter.api.Converter;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;

public class UserConverterImpl implements Converter<UserDto, User,Integer> {


    @Override
    public UserDto convert(User model) throws ServiceException {
        return null;
    }

    @Override
    public User convert(UserDto modelDto) throws DaoException {
        return null;
    }
}
