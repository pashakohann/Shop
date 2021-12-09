package com.epam.shop.dao.model;


import java.util.Arrays;
import java.util.List;

public enum UserRole {
    USER(2), ADMIN(1),
    UNAUTHORIZED(3);
    private Integer id;

    UserRole(Integer id) {
        this.id = id;
    }

    public static final List<UserRole> ALL_AVAILABLE_ROLES = Arrays.asList(values());

    public static List<UserRole> valuesAsList() {
        return ALL_AVAILABLE_ROLES;
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
