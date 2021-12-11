package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.exception.ServiceException;

import javax.servlet.http.HttpSession;

public class SignInCommand implements Command {
    public static Command command;
    private static final String SIGN_IN_PAGE_PATH = "/jsp/sign_in.jsp";


    private SignInCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new SignInCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_SIGN_IN_PAGE = new ResponseContext() {

        @Override
        public String getPath() {
            return SIGN_IN_PAGE_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }
    };

    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        HttpSession session = requestContext.getCurrentSession().get();



        //session.setAttribute("products","sdad");
        return SHOW_SIGN_IN_PAGE;
    }
}
