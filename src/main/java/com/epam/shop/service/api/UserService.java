package com.epam.shop.service.api;

import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;

public interface UserService extends Service<UserDto, Integer> {
    UserDto signIn(UserDto userDto) throws ServiceException;


}
