package com.epam.shop.service.dto.model;


import java.util.Arrays;
import java.util.List;

public enum UserRole {
    USER(2), ADMIN(1),
    UNAUTHORIZED(3);
    private Integer id;

    UserRole(Integer id) {
        this.id = id;
    }

    public static final List<com.epam.shop.service.dto.model.UserRole> ALL_AVAILABLE_ROLES = Arrays.asList(values());

    public static List<com.epam.shop.service.dto.model.UserRole> valuesAsList() {
        return ALL_AVAILABLE_ROLES;
    }


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static com.epam.shop.dao.model.UserRole getById(Integer id) {
        return Arrays.stream(com.epam.shop.dao.model.UserRole.values())
                .filter(role -> role.getId() == id)
                .findFirst().orElse(null);
    }
}

