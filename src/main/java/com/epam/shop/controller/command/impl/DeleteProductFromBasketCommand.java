package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.exception.ServiceException;

public class DeleteProductFromBasketCommand implements Command {
    private static Command command;
    private static final String LANGUAGE_PARAM = "language";
    private static String RETURN_PAGE_WITH_NEW_LANGUAGE;

    private DeleteProductFromBasketCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new DeleteProductFromBasketCommand();
        }
        return command;
    }

    private static final ResponseContext CHANGE_LANGUAGE_PAGE = new ResponseContext() {
        public String getPath() {
            return RETURN_PAGE_WITH_NEW_LANGUAGE;
        }

        public boolean isRedirect() {
            return true;
        }

    };

    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        return null;
    }
}
