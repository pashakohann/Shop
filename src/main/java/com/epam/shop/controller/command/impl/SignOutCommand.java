package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;

import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.exception.ServiceException;

public class SignOutCommand implements Command {
    public static Command command;
    private static final String SHOW_DEFAULT_PAGE = "/jsp/main.jsp";
    private static String RETURN_PAGE = "/jsp/personal_acc.jsp";
    private static String PRODUCT_ID_PARAM = "productId";
    private static final String ERROR_PARAM = "error";
    private static final String MESSAGE_PARAM = "message";
    private static final String BASKET_PARAM = "basketSize";
    private static final String BASKET_MAP_PARAM = "userBasket";
    private static final String BASKET_USER_OBJECT ="basketObject";

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
