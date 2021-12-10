package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.exception.ServiceException;

import javax.servlet.http.HttpSession;

public class AuthorizationPageCommand implements Command {
    public static Command command;
    private static final String AUTHORIZATION_PAGE_PATH = "/jsp/registration/registration.jsp";


    private AuthorizationPageCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new AuthorizationPageCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_AUTHORIZATION_PAGE = new ResponseContext() {

        @Override
        public String getPath() {
            return AUTHORIZATION_PAGE_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }
    };

    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        HttpSession session = requestContext.getCurrentSession().get();
        System.out.println("privet iz authorization!");
        return SHOW_AUTHORIZATION_PAGE;
    }
}
