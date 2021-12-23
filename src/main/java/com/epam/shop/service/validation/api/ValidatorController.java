package com.epam.shop.service.validation.api;

import com.epam.shop.service.exception.ServiceException;

/**
 * to check lines from controller
 */
public interface ValidatorController {

    /**
     *
     * @param parameter a string with many parameters and they are separated by certain characters
     * @throws ServiceException if the entered data is not correct
     */
    void validate(String parameter) throws ServiceException;
}
