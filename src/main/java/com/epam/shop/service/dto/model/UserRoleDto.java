package com.epam.shop.service.dto.model;


import java.util.Arrays;
import java.util.List;

public enum UserRoleDto {
    USER(2), ADMIN(1),
    UNAUTHORIZED(3);
    private Integer id;

    UserRoleDto(Integer id) {
        this.id = id;
    }

    public static final List<UserRoleDto> ALL_AVAILABLE_ROLES = Arrays.asList(values());

    public static List<UserRoleDto> valuesAsList() {
        return ALL_AVAILABLE_ROLES;
    }


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static UserRoleDto getById(Integer id) {
        return Arrays.stream(UserRoleDto.values())
                .filter(role -> role.getId() == id)
                .findFirst().orElse(null);
    }
}

