package com.epam.shop.service.validation.api;

import com.epam.shop.service.dto.model.AbstractDto;
import com.epam.shop.service.exception.ServiceException;



public interface Validator<T extends AbstractDto<K>,K> {
     void validate(T dto) throws ServiceException;
}
