package com.epam.shop.service.validation.impl;

import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.exception.string_exception.ServiceAccountExceptionString;
import com.epam.shop.service.validation.api.Validator;
import com.epam.shop.service.validation.validation_string.AccountValidationString;

import java.rmi.ServerException;
import java.time.LocalDate;

public class AccountValidator implements Validator<AccountDto, Integer> {
    private static  AccountValidator instance;



    private AccountValidator() {
    }


    public static AccountValidator getInstance() {
        if (instance == null) {
            instance = new AccountValidator();
        }
        return instance;
    }

    @Override
    public void validate(AccountDto dto) throws ServerException {

    }


    private void checkFirstName(String firstName) throws ServerException {
        if (!firstName.matches(AccountValidationString.FIRST_NAME_REGEX)) {
            throw new ServerException(ServiceAccountExceptionString.FIRST_NAME_EXCEPTION);
        }
    }

    private void checkLastName(String lastName) throws ServerException {
        if (!lastName.matches(AccountValidationString.LAST_NAME_REGEX)) {
            throw new ServerException(ServiceAccountExceptionString.LAST_NAME_EXCEPTION);
        }
    }

    private void checkStreet(String street) throws ServerException {
        if (!street.matches(AccountValidationString.STREET_NAME_REGEX)) {
            throw new ServerException(ServiceAccountExceptionString.STREET_NAME_EXCEPTION);
        }
    }

    private void checkCity(String city) throws ServerException {
        if (!city.matches(AccountValidationString.CITY_NAME_REGEX)) {
            throw new ServerException(ServiceAccountExceptionString.CITY_NAME_EXCEPTION);
        }

    }

    private void checkFlatOrHouse(String flatOrHouse) throws ServerException {
        if (!flatOrHouse.matches(AccountValidationString.FLAT_OR_HOUSE_NUMBER_REGEX)) {
            throw new ServerException(ServiceAccountExceptionString.FLAT_OR_HOUSE_NUMBER_EXCEPTION);
        }

    }

    private void checkTelephoneNumber(String telephoneNumber) throws ServerException {
        if (!telephoneNumber.matches(AccountValidationString.CHECK_TELEPHONE_NUMBER_REGEX)) {
            throw new ServerException(ServiceAccountExceptionString.CHECK_TELEPHONE_NUMBER_EXCEPTION);
        }

    }

    private void checkEmail(String email) throws ServerException {
        if (!email.matches(AccountValidationString.CHECK_EMAIL_REGEX)) {
            throw new ServerException(ServiceAccountExceptionString.CHECK_EMAIL_EXCEPTION);
        }

    }

    private void checkDateOfBirth(String dateOfBirth) throws ServerException {
        Integer yearNow = LocalDate.now().getYear();
        LocalDate yearsOfBirth;
        if (!dateOfBirth.matches(AccountValidationString.DATE_OF_BIRTH_REGEX)) {
            throw new ServerException(ServiceAccountExceptionString.DATE_OF_BIRTH_EXCEPTION);
        }
        yearsOfBirth = LocalDate.parse(dateOfBirth);

        checkAge(yearNow - yearsOfBirth.getYear());


    }

    private static void checkAge(Integer age) throws ServerException {
        if (age < AccountValidationString.AGE) {
            throw new ServerException(ServiceAccountExceptionString.YEARS_OF_BIRTH_EXCEPTION);
        }

    }

    private void checkAccountAmount(String amount) throws ServerException {
        if (!amount.matches(AccountValidationString.ACCOUNT_AMOUNT_REGEX)) {
            throw new ServerException(ServiceAccountExceptionString.ACCOUNT_AMOUNT_EXCEPTION);
        }

    }

}
