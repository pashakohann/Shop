package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;

import com.epam.shop.service.exception.ServiceException;

import javax.servlet.http.HttpSession;


public class ReturnBackActionCommand implements Command {
    private static Command command;
    private static String BASKET_PAGE = "/jsp/personal_acc.jsp";
    private static final String ERROR_PARAM = "error";
    private static final String MESSAGE_PARAM = "message";


    private ReturnBackActionCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new ReturnBackActionCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_PAGE = new ResponseContext() {
        public String getPath() {
            return BASKET_PAGE;
        }

        public boolean isRedirect() {
            return true;
        }

    };

    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        HttpSession httpSession = requestContext.getCurrentSession().get();
        httpSession.getAttribute("basketSize");



        System.out.println(BASKET_PAGE);
        return SHOW_PAGE;
    }


}
