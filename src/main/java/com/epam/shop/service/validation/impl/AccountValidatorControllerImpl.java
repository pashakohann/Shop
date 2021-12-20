package com.epam.shop.service.validation.impl;

import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceAccountExceptionString;
import com.epam.shop.service.validation.api.ValidatorController;
import com.epam.shop.service.validation.validation_string.AccountValidationString;

import java.time.LocalDate;

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
        for (String s: fields){
            System.out.println(s);
        }
        checkQuantityFields(fields.length);
        checkFirstName(fields[0]);
        checkLastName(fields[1]);
        checkDateOfBirth(fields[2]);
        checkTelephoneNumber(fields[3]);
        checkEmail(fields[4]);
        checkCity(fields[5]);
        checkStreet(fields[6]);
        checkFlatOrHouse(fields[7]);

    }

    private void checkQuantityFields(int quantity) throws ServiceException {
        if (quantity < QUANTITY_FIELDS) {
            throw new ServiceException(ServiceAccountExceptionString.FILL_FIELDS_EXCEPTION);
        }
    }



    private void checkFirstName(String firstName) throws ServiceException {
        if (!firstName.matches(AccountValidationString.FIRST_NAME_REGEX)) {
            throw new ServiceException(ServiceAccountExceptionString.FIRST_NAME_EXCEPTION);
        }
    }

    private void checkLastName(String lastName) throws ServiceException {
        if (!lastName.matches(AccountValidationString.LAST_NAME_REGEX)) {
            throw new ServiceException(ServiceAccountExceptionString.LAST_NAME_EXCEPTION);
        }
    }

    private void checkStreet(String street) throws ServiceException {
        if (!street.matches(AccountValidationString.STREET_NAME_REGEX)) {
            throw new ServiceException(ServiceAccountExceptionString.STREET_NAME_EXCEPTION);
        }
    }

    private void checkCity(String city) throws ServiceException {
        if (!city.matches(AccountValidationString.CITY_NAME_REGEX)) {
            throw new ServiceException(ServiceAccountExceptionString.CITY_NAME_EXCEPTION);
        }

    }

    private void checkFlatOrHouse(String flatOrHouse) throws ServiceException {
        if (!flatOrHouse.matches(AccountValidationString.FLAT_OR_HOUSE_NUMBER_REGEX)) {
            throw new ServiceException(ServiceAccountExceptionString.FLAT_OR_HOUSE_NUMBER_EXCEPTION);
        }

    }

    private void checkTelephoneNumber(String telephoneNumber) throws ServiceException {
        if (!telephoneNumber.matches(AccountValidationString.CHECK_TELEPHONE_NUMBER_REGEX)) {
            throw new ServiceException(ServiceAccountExceptionString.CHECK_TELEPHONE_NUMBER_EXCEPTION);
        }

    }

    private void checkEmail(String email) throws ServiceException {
        if (!email.matches(AccountValidationString.CHECK_EMAIL_REGEX)) {
            throw new ServiceException(ServiceAccountExceptionString.CHECK_EMAIL_EXCEPTION);
        }

    }

    private void checkDateOfBirth(String dateOfBirth) throws ServiceException {
        Integer yearNow = LocalDate.now().getYear();
        LocalDate yearsOfBirth;
        if (!dateOfBirth.matches(AccountValidationString.DATE_OF_BIRTH_REGEX)) {
            throw new ServiceException(ServiceAccountExceptionString.DATE_OF_BIRTH_EXCEPTION);
        }
        yearsOfBirth = LocalDate.parse(dateOfBirth);

        checkAge(yearNow - yearsOfBirth.getYear());


    }

    private void checkAge(Integer age) throws ServiceException {
        if (age < AccountValidationString.AGE) {
            throw new ServiceException(ServiceAccountExceptionString.YEARS_OF_BIRTH_EXCEPTION);
        }

    }

    public void checkAccountAmount(String amount) throws ServiceException {
        if (!amount.matches(AccountValidationString.ACCOUNT_AMOUNT_REGEX)) {
            throw new ServiceException(ServiceAccountExceptionString.ACCOUNT_AMOUNT_EXCEPTION);
        }

    }
}
