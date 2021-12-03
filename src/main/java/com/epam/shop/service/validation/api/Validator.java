package com.epam.shop.service.validation.api;

import com.epam.shop.service.dto.model.AbstractModelDto;
import com.epam.shop.service.exception.ServiceException;



public interface Validator<T extends AbstractModelDto<K>,K> {
     void validate(T dto) throws ServiceException;
}
