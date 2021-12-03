package com.epam.shop.service.validation.impl;

import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.validation.api.Validator;

import java.rmi.ServerException;

public class AccountValidator implements Validator<AccountDto, Integer> {
    @Override
    public void validate(AccountDto dto) throws ServerException {

    }





    private void checkFirstName(String firstName) {

    }

    private void checkLastName(String lastName) {

    }

    private void checkStreet(String street) {

    }

    private void checkCity(String city) {

    }

    private void checkFlatOrHouse(String FlatOrHouse) {

    }

    private void checkTelephoneNumber(String telephoneNumber) {

    }

    private void checkEmail(String email) {

    }

    private void checkDateOfBirth(String dateOfBirth) {

    }

    private void checkAge(String age) {

    }

    private void checkAccountAmount(String amount) {

    }

}
