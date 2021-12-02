package com.epam.shop.dao.model;


import java.util.Arrays;

public enum UserRole {
    USER(2), ADMIN(1);
    private Integer id;

    UserRole(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static UserRole getById(Integer id) {
        return Arrays.stream(UserRole.values())
                .filter(role -> role.getId() == id)
                .findFirst().orElse(null);
    }
}
