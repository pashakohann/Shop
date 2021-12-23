package com.epam.shop.service.converter.impl;


import com.epam.shop.dao.model.User;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.dto.model.UserDto;

/**
 * @see Converter
 */
public class UserConverterImpl implements Converter<UserDto, User, Integer> {
    private static Converter<UserDto, User, Integer> converterInstance;


    private UserConverterImpl() {
    }

    public static Converter<UserDto, User, Integer> getConverterInstance() {
        if (converterInstance == null) {
            converterInstance = new UserConverterImpl();
        }
        return converterInstance;
    }


    @Override
    public UserDto convert(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setRegistrationDate(user.getRegistrationDate());
        userDto.setRole(user.getRole());
        userDto.setAccount(user.getAccount());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setRegistrationDate(userDto.getRegistrationDate());
        user.setRole(userDto.getRole());
        user.setAccount(userDto.getAccount());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
