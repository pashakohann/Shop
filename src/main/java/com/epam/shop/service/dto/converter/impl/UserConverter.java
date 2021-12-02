package com.epam.shop.service.dto.converter.impl;

import com.epam.shop.dao.model.User;
import com.epam.shop.service.dto.model.UserDto;

public class UserConverter {

    public UserDto convert(User user){
        UserDto userDto = new UserDto();
        userDto.setAccount(user.getAccount());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        return userDto;
    }

    public User convert(UserDto userDto){
    User user = new User();
    user.setAccount(userDto.getAccount());
    user.setPassword(userDto.getPassword());

    return user;
    }
}
