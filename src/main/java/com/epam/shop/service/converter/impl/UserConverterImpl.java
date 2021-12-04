package com.epam.shop.service.converter.impl;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.User;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.dto.model.UserDto;

public class UserConverterImpl implements Converter<UserDto, User, Integer> {
    private static Converter converterInstance;


    private UserConverterImpl() {
    }

    public static UserConverterImpl getConverterInstance() {
        if (converterInstance == null) {
            converterInstance = new UserConverterImpl();
        }
        return (UserConverterImpl) converterInstance;
    }


    @Override
    public UserDto convert(User model) throws DaoException {
        UserDto userDto = new UserDto();
        userDto.setId(model.getId());
        userDto.setRegistrationDate(model.getRegistrationDate());
        userDto.setRole(model.getRole());
        userDto.setAccount(model.getAccount());
        userDto.setPassword(model.getPassword());
        return userDto;
    }

    @Override
    public User convert(UserDto modelDto) {

        User user = new User();
        user.setId(modelDto.getId());
        user.setRegistrationDate(modelDto.getRegistrationDate());
        user.setRole(modelDto.getRole());
        user.setAccount(modelDto.getAccount());
        user.setPassword(modelDto.getPassword());
        return user;
    }
}
