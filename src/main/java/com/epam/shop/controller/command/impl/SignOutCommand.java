package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;

import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.exception.ServiceException;

public class SignOutCommand implements Command {
    public static Command command;
    private static final String SHOW_DEFAULT_PAGE = "/jsp/main.jsp";


    private SignOutCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new SignOutCommand();
        }
        return command;
    }

    private static final ResponseContext REDIRECT_MAIN_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return SHOW_DEFAULT_PAGE;
        }

        @Override
        public boolean isRedirect() {
            return true;
        }
    };


    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        requestContext.invalidateCurrentSession();
        return REDIRECT_MAIN_PAGE;
    }
}
