package com.epam.shop.service.api;

import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;

public interface UserService extends Service<UserDto, Integer> {
    UserDto findUser(UserDto userDto) throws ServiceException;


}
