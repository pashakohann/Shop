package com.epam.shop.service.dto.converter.api;

import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.AbstractModel;
import com.epam.shop.service.dto.model.AbstractModelDto;


public interface Converter<T extends AbstractModelDto<V>, K extends AbstractModel<V>, V> {
    T convert(K model) throws DaoException;


    K convert(T modelDto) ;
}
