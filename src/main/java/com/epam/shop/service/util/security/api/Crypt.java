package com.epam.shop.service.util.security.api;

public interface Crypt {
    String encrypt(String password);
    boolean verify(String user,String password);
}
