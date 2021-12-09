package com.epam.shop.controller.command;


import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.command.impl.DefaultCommand;
import com.epam.shop.service.dto.model.UserRole;

import java.util.Arrays;
import java.util.List;

public enum Commands {
    DEFAULT(DefaultCommand.getInstance(), UserRole.UNAUTHORIZED);
//    SHOW_USERS(),
//    SHOW_ACCOUNTS(),
//    SHOW_PRODUCTS(),
//    REGISTRATION(),
//    SIGN_IN(),
//    SIGN_OUT(),
//    ORDER_PRDUCTS();

    private final Command command;
    private final List<UserRole> allowedRoles;

    Commands(Command command, UserRole... roles) {
        this.command = command;
        this.allowedRoles = roles != null && roles.length > 0 ? Arrays.asList(roles) : UserRole.valuesAsList();
    }

    public Command getCommand() {
        return command;
    }

    public List<UserRole> getAllowedRoles() {
        return allowedRoles;
    }

    public static Commands of(String name) {
        for (Commands command : values()) {
            if (command.name().equalsIgnoreCase(name)) {
                return command;
            }
        }
        return DEFAULT;
    }

}




