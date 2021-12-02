package com.epam.shop.service.validation.validation_string;

import java.time.LocalDate;

public interface ValidationString {
    String CHECK_EMAIL_REGEX = "^([1-9a-zA-Z]+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}$)";
    String CHECK_TELEPHONE_NUMBER_REGEX = "^(\\+375|80)(29|25|44|33)([1-9]{1})(\\d){6}$";
    String USER_NAME_REGEX = "^[\\w]{5,12}$";
    String PASSWORD_USER_REGEX = "^[\\w]{5,12}$";
    String FIRST_NAME_REGEX = "^(([A-Z][a-z]{1,20})|([А-Я][а-я]{1,20}))$";
    String LAST_NAME_REGEX = "^(([A-Z][a-z]{1,20})|([А-Я][а-я]{1,20}))$";
    String CITY_NAME_REGEX = "^(([A-Z][a-z]{1,30})|([А-Я][а-я]{3,30}))$";
    String STREET_NAME_REGEX = "^(([A-Z][a-z]{1,40})|([А-Я][а-я]{2,50}))$";
    String FLAT_REGEX = "^[1-9]([0-9]{0,2})$";
    String ACCOUNT_AMOUNT_REGEX = "^[1-9]([0-9]{0,5})[.][0-9]{2}$";
    String PRODUCT_COST_REGEX = "^[1-9]([0-9]{0,5})[.][0-9]{2}$";
    String DATE_OF_BIRTH_REGEX = "^(19|20)\\d\\d-((0[1-9]|1[012])-(0[1-9]|[12]\\d)|(0[13-9]|1[012])-30|(0[13578]|1[02])-31)$";
    Integer AGE = 18;

}
