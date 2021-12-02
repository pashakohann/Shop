package com.epam.shop.dao.util.security.api;

public interface Crypt {
    String encrypt(String password);
    boolean verify(String user,String password);
}
