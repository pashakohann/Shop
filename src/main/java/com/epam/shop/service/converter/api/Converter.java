package com.epam.shop.service.converter.api;

import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.AbstractModel;
import com.epam.shop.service.dto.model.AbstractModelDto;

/**
 *
 * @param <T> our model from AbstractModelDto
 * @param <K>our model from AbstractModel
 * @param <V>general parameter id
 */
public interface Converter<T extends AbstractModelDto<V>, K extends AbstractModel<V>, V> {
    /**
     *
     * @param model to convert to modelDto
     * @returnconverted model
     * @throws DaoException if failed to convert
     */
    T convert(K model) throws DaoException;

    /**
     *
     * @param modelDto to convert to model
     * @return converted model
     * @throws DaoException if failed to convert
     */
    K convert(T modelDto) ;
}
