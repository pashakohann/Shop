package com.epam.shop.service.validation.validation_string;

public interface AccountValidationString {

    String CHECK_EMAIL_REGEX = "^([1-9a-zA-Z]+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}$)";
    String CHECK_TELEPHONE_NUMBER_REGEX = "^(\\+375|80)(29|25|44|33)([1-9]{1})(\\d){6}$";
    String FIRST_NAME_REGEX = "^(([A-Z][a-z]{1,40})|([А-Я][а-я]{1,40}))$";
    String LAST_NAME_REGEX = "^(([A-Z][a-z]{1,70})|([А-Я][а-я]{1,70}))$";
    String CITY_NAME_REGEX = "^(([A-Z][a-z]{1,30})|([А-Я][а-я]{3,30}))$";
    String STREET_NAME_REGEX = "^(([A-Z][a-z]{1,40})|([А-Я][а-я]{2,50}))$";
    String FLAT_OR_HOUSE_NUMBER_REGEX = "^[1-9]([0-9]{0,2})$";
    String ACCOUNT_AMOUNT_REGEX = "^(([1-9]([0-9]{0,5})[.][0-9]{1})|([1-9]([0-9]{0,5})))$";
    String DATE_OF_BIRTH_REGEX = "^(19|20)\\d\\d-((0[1-9]|1[012])-(0[1-9]|[12]\\d)|(0[13-9]|1[012])-30|(0[13578]|1[02])-31)$";
    String SPLIT_STRING_REGEX = "&&&";
    int AGE = 18;
    int QUANTITY_FIELDS = 8;


}
