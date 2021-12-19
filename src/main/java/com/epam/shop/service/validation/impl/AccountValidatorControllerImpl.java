package com.epam.shop.service.validation.impl;

import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceAccountExceptionString;
import com.epam.shop.service.validation.api.ValidatorController;
import com.epam.shop.service.validation.validation_string.AccountValidationString;

public class AccountValidatorControllerImpl implements ValidatorController {
    private static ValidatorController INSTANCE;
    private static final int QUANTITY_FIELDS = 8;
    private static final String SPLIT_STRING_REGEX = "&&&";
    private static final String QUANTITY_FIELDS_EXCEPTION = "You need to fill in all the fields ";


    private AccountValidatorControllerImpl() {

    }

    public static ValidatorController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AccountValidatorControllerImpl();
        }
        return INSTANCE;
    }

    @Override
    public void validate(String parameter) throws ServiceException {
        String[] fields = parameter.split(SPLIT_STRING_REGEX);
        validateQuantity(fields.length);
        validateDateOfBirth(fields[2]);
        validateFlat(fields[7]);


    }

    private void validateQuantity(int quantity) throws ServiceException {
        if (quantity < QUANTITY_FIELDS) {
            throw new ServiceException(QUANTITY_FIELDS_EXCEPTION);
        }
    }


    private void validateDateOfBirth(String dateOfBirth) throws ServiceException {
        if (!dateOfBirth.matches(AccountValidationString.DATE_OF_BIRTH_REGEX)) {
            throw new ServiceException(ServiceAccountExceptionString.DATE_OF_BIRTH_EXCEPTION);
        }
    }

    private void validateFlat(String flat) throws ServiceException {
        if (!flat.matches(AccountValidationString.FLAT_OR_HOUSE_NUMBER_REGEX)) {
            throw new ServiceException(ServiceAccountExceptionString.FLAT_OR_HOUSE_NUMBER_EXCEPTION);
        }
    }
}
