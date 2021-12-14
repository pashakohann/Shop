package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.exception.ServiceException;



public class AuthorizationCommand implements Command {
    private static final String PANEL_USER_PAGE_PATH = "/jsp/personal_acc.jsp";
    public static Command command;
    private static final String USER_ROLE_ATTRIBUTE_NAME = "userRole";
    private static final String LOGIN_PARAM = "login";
    private static final String PASSWORD_PARAM = "password";
    private static final String INVALID_PASSWORD_OR_LOGIN = "Wrong password or login";
    private static final String ERROR_ATTRIBUTE = "error";
    private static final String ACCOUNT_ID = "account";


    private AuthorizationCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new AuthorizationCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_MAIN_PAGE = new ResponseContext() {

        @Override
        public String getPath() {
            return PANEL_USER_PAGE_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }
    };

    private static final ResponseContext LOGIN_SUCCESS_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return PANEL_USER_PAGE_PATH;
        }

        @Override
        public boolean isRedirect() {
            return true;
        }


    };


    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        final String userName = requestContext.getParameter(LOGIN_PARAM);
        final String userPassword = requestContext.getParameter(PASSWORD_PARAM);

        return SHOW_MAIN_PAGE;
    }

    private ResponseContext prepareErrorPage(RequestContext requestContext) {
        requestContext.setAttribute(ERROR_ATTRIBUTE, INVALID_PASSWORD_OR_LOGIN);
        return SHOW_MAIN_PAGE;

    }

//    private ResponseContext addUserToSession(RequestContext requestContext){
//
//    }
}
