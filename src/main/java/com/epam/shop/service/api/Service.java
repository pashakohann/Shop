package com.epam.shop.service.api;

import com.epam.shop.service.dto.model.AbstractDto;
import com.epam.shop.service.exception.ServiceException;



public interface Service <T extends AbstractDto<K>,K>{
    T create(T model) throws ServiceException;
    T update(T model);
    void delete(T model);
    T getById(K id);
    T getAll();
}
