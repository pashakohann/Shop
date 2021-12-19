package com.epam.shop.service.validation.api;

import com.epam.shop.service.exception.ServiceException;

public interface ValidatorController {

    void validate(String parameter) throws ServiceException;
}
