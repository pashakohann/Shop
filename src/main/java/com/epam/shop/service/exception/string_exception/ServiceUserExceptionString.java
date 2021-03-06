package com.epam.shop.service.exception.string_exception;


/**
 * Exception strings for our user implementation on the services layer
 */
public interface ServiceUserExceptionString {
    String USER_NAME_EXCEPTION = "You entered an invalid user name...User name must have 5 to 12 characters such as 1-9, a-z, A-Z. Example: pappi1";
    String USER_PASSWORD_EXCEPTION = "You entered an invalid password...Password must have 5 to 12 characters such as 1-9, a-z, A-Z. Example: Qa3dfg45 ";
    String SAVE_USER_EXCEPTION = "Failed to save user";
    String UPDATE_USER_EXCEPTION  = "Failed to update user";
    String DELETE_USER_EXCEPTION = "Failed to delete user";
    String FIND_USER_BY_ID_EXCEPTION = "Failed to find user";
    String FIND_ALL_USERS_EXCEPTION = "Failed to find users";
    String CHECK_DUPLICATE_USER_NAME_EXCEPTION = "Name is taken ... Please come up with another";
    String CHECK_PASSWORD_EXCEPTION = "Incorrect password";
    String USER_IS_NOT_FOUND = "user is not found";
    String FIND_USER_EXCEPTION = "failed to find user";
    String USER_ID_EXCEPTION =  "User doesn't exist";


}
