package com.epam.shop.service.util.security.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.epam.shop.service.util.security.api.Crypt;

public class CryptImpl implements Crypt {
    private static Crypt instance;

    private CryptImpl() {
    }

    public static Crypt getInstance() {
         if(instance == null){
             instance = new CryptImpl();

         }
         return instance;
    }

    @Override
    public String encrypt(String password) {

        return BCrypt.withDefaults().hashToString(4, password.toCharArray());
    }

    @Override
    public boolean verify(String user, String password) {

        return BCrypt.verifyer().verify(password.toCharArray(),password).verified;
    }
}
