package com.epam.shop.service.security.api;


public interface Crypt {

    String encrypt(String password);

    boolean verify(String user, String password);
}
