package com.epam.shop.service.validation.api;

import java.rmi.ServerException;

public interface Validator<T> {
     void validate(T dto) throws ServerException;
}
