package com.epam.shop.service.validation.api;

import com.epam.shop.service.dto.model.AbstractDto;

import java.rmi.ServerException;

public interface Validator<T extends AbstractDto<K>,K> {
     void validate(T dto) throws ServerException;
}
