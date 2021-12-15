package com.epam.shop.controller.command;


import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.command.impl.AuthorizationCommand;
import com.epam.shop.controller.command.impl.LanguageCommand;
import com.epam.shop.controller.command.impl.SignOutCommand;
import com.epam.shop.controller.command.impl.show_page.ShowDefaultPageCommand;
import com.epam.shop.controller.command.impl.FindProductsByCategoryBrandCommand;
import com.epam.shop.controller.command.impl.FindProductsByCategoryCommand;
import com.epam.shop.controller.command.impl.RegistrationCommand;
import com.epam.shop.controller.command.impl.show_page.ShowSignInPageCommand;
import com.epam.shop.controller.command.impl.show_page.ShowSignUpPageCommand;
import com.epam.shop.service.dto.model.UserRole;

import java.util.Arrays;
import java.util.List;

public enum Commands {
    DEFAULT(ShowDefaultPageCommand.getInstance(), UserRole.UNAUTHORIZED),
    FIND_PRODUCTS_CATEGORY_BRAND(FindProductsByCategoryBrandCommand.getInstance()),
    FIND_PRODUCTS_CATEGORY(FindProductsByCategoryCommand.getInstance()),
    SHOW_SIGN_UP_PAGE(ShowSignUpPageCommand.getInstance()),
    SHOW_SIGN_IN_PAGE(ShowSignInPageCommand.getInstance()),
    REGISTRATION(RegistrationCommand.getInstance()),
    LANGUAGE_COMMAND(LanguageCommand.getInstance()),
    AUTHORIZATION_COMMAND(AuthorizationCommand.getInstance()),
    SIGN_OUT_COMMAND(SignOutCommand.getInstance());
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




