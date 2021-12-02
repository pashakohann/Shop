package com.epam.shop.service.exception.string_exception;

public interface ServiceProductExceptionString {
    String CHECK_EMAIL_EXCEPTION = "You entered an invalid email... Example : 'super@gmail.com'";
    String CHECK_TELEPHONE_NUMBER_EXCEPTION = "You entered an invalid mobile phone number...Example : +375291142342 or 80293245421";
    String USER_NAME_EXCEPTION = "You entered an invalid user name...User name must have 5 to 12 characters such as 1-9, a-z, A-Z. Example: pappi1";
    String PASSWORD_USER_EXCEPTION = "You entered an invalid password...Password must have 5 to 12 characters such as 1-9, a-z, A-Z. Example: Qa3dfg45 ";
    String FIRST_NAME_EXCEPTION = "You entered an invalid first name...First name must start with a capital letter and select one language to enter. Example:Pasha or Паша";
    String LAST_NAME_EXCEPTION = "You entered an invalid last name...Last name must start with a capital letter and select one language to enter. Example:Popov or Попов";
    String CITY_NAME_EXCEPTION = "You entered an invalid city name...City name must start with a capital letter and select one language to enter. Example:Minsk or Минск";
    String STREET_NAME_EXCEPTION = "You entered an invalid street name...Street name must start with a capital letter and select one language to enter. Example:Lomonosova or Ломоносова";
    String FLAT_EXCEPTION = "You entered an invalid number flat or house....Flat or House number must have 1-999";
    String ACCOUNT_AMOUNT_EXCEPTION = "You entered an invalid amount....Your amount must be 1.00 to 999999.00. Example:99.00 or 13.75";
    String PRODUCT_COST_EXCEPTION = "You entered an invalid product cost...You should enter 1.00 to 999999.00 Example:99.00 or 111.23";
    String DATE_OF_BIRTH_EXCEPTION = "You entered an invalid date of birth... You must enter the year first, then the month, and then the day, separating everything with a dash. Example:1990-01-14";
    String YEARS_OF_BIRTH_EXCEPTION = "You entered an invalid year. Your year of birth must be over 18 years old";

}
