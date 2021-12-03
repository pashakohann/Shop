package com.epam.shop.service.converter.impl;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.User;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.dto.model.UserDto;

public class UserConverterImpl implements Converter<UserDto, User,Integer> {
    private static Converter converterInstance;


    private UserConverterImpl() {
    }

    public static Converter getConverterInstance() {
        if (converterInstance == null) {
            converterInstance = new UserConverterImpl();
        }
        return converterInstance;
    }


    @Override
    public UserDto convert(User model) throws DaoException {
        return null;
    }

    @Override
    public User convert(UserDto modelDto)  {
        return null;
    }
}
