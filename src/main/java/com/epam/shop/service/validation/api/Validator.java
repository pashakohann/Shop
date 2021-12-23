package com.epam.shop.service.validation.api;

import com.epam.shop.service.dto.model.AbstractModelDto;
import com.epam.shop.service.exception.ServiceException;


/**
 *
 * @param <T> must inherit  AbstractModelDto
 * @param <K> the value in which id is stored
 */
public interface Validator<T extends AbstractModelDto<K>,K> {
     /**
      *
      * @param dto  this is for data validation
      * @throws ServiceException if the entered data is not correct
      */
     void validate(T dto) throws ServiceException;
}
