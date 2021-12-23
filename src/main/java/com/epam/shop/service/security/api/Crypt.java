package com.epam.shop.service.security.api;

/**
 * allows you to encrypt and verify the encrypted password, which is stored in a hash
 */
public interface Crypt {

    /**
     *
     * @param password password to decrypt
     * @return returns encrypted password
     */
    String encrypt(String password);

    /**
     *
     * @param user the password that the user entered
     * @param password the password that is in db
     * @return returns the correct password
     */
    boolean verify(String user, String password);
}
