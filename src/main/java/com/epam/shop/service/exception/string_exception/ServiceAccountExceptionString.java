package com.epam.shop.service.exception.string_exception;

/**
 * Strings for our exceptions from Service account
 */
public interface ServiceAccountExceptionString {
    String CHECK_EMAIL_EXCEPTION = "You entered an invalid email... Example : 'super@gmail.com'";
    String CHECK_TELEPHONE_NUMBER_EXCEPTION = "You entered an invalid mobile phone number...Example : +375291142342 or 80293245421";
    String FIRST_NAME_EXCEPTION = "You entered an invalid first name...First name must start with a capital letter and select one language to enter. Example:Pasha or Паша";
    String LAST_NAME_EXCEPTION = "You entered an invalid last name...Last name must start with a capital letter and select one language to enter. Example:Popov or Попов";
    String CITY_NAME_EXCEPTION = "You entered an invalid city name...City name must start with a capital letter and select one language to enter. Example:Minsk or Минск";
    String STREET_NAME_EXCEPTION = "You entered an invalid street name...Street name must start with a capital letter and select one language to enter. Example:Lomonosova or Ломоносова";
    String FLAT_OR_HOUSE_NUMBER_EXCEPTION = "You entered an invalid number flat or house....Flat or House number must have 1-999";
    String ACCOUNT_AMOUNT_EXCEPTION = "You entered an invalid amount....Your amount must be 1.0 to 999999.0. Example:99.0 or 13.7 or the amount without the remainder";
    String DATE_OF_BIRTH_EXCEPTION = "You entered an invalid date of birth... You must enter the year first, then the month, and then the day, separating everything with a dash. Example:1990-01-14";
    String YEARS_OF_BIRTH_EXCEPTION = "You entered an invalid year. Your year of birth must be over 18 years old";
    String CREATE_ACCOUNT_FOR_USER = "Failed to create account";
    String FIND_ALL_ACCOUNTS = "Failed to find all account";
    String FIND_BY_ID_ACCOUNT = "Failed to find account";
    String FIND_BY_USER_ID_ACCOUNT = "Failed to find account";
    String DELETE_ACCOUNT = "Failed to delete account";
    String UPDATE_ACCOUNT = "Failed to update information in account";
    String FILL_FIELDS_EXCEPTION  = "You must fill in all fields";
}
