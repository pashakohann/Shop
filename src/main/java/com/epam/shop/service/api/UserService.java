package com.epam.shop.service.api;

import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;

/**
 * @see Service
 *
 */
public interface UserService extends Service<UserDto, Integer> {
    /**
     *
     * @param userDto will search for a user by id but need to pass object
     * @return if found this user
     * @throws ServiceException if failed to find user
     */
    UserDto findUser(UserDto userDto) throws ServiceException;

    /**
     *
     * @param userId delete by user id
     * @throws ServiceException if failed to delete user
     */
    void deleteUserById(int userId) throws ServiceException;


}
