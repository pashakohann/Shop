package com.epam.shop.service.dto.converter.api;

import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.AbstractModel;
import com.epam.shop.service.dto.model.AbstractDto;
import com.epam.shop.service.exception.ServiceException;


public interface Converter<T extends AbstractDto<V>, K extends AbstractModel<V>, V> {
    T convert(K model) throws ServiceException;


    K convert(T modelDto) throws DaoException;
}
