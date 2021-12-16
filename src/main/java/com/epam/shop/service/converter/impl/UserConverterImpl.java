package com.epam.shop.service.converter.impl;


import com.epam.shop.dao.model.User;
import com.epam.shop.dao.model.UserRole;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.dto.model.UserRoleDto;

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
    public UserDto convert(User model) {
        UserDto userDto = new UserDto();
        userDto.setId(model.getId());
        userDto.setRegistrationDate(model.getRegistrationDate());
        userDto.setRole(UserRoleDto.getById(model.getRole().getId()));
        userDto.setAccount(model.getAccount());
        userDto.setPassword(model.getPassword());
        return userDto;
    }

    @Override
    public User convert(UserDto modelDto) {
        User user = new User();
        user.setId(modelDto.getId());
        user.setRegistrationDate(modelDto.getRegistrationDate());
        user.setRole(UserRole.getById(modelDto.getRole().getId()));
        user.setAccount(modelDto.getAccount());
        user.setPassword(modelDto.getPassword());
        return user;
    }
}
