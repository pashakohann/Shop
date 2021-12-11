package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class SignUpCommand implements Command {
    public static Command command;
    private static final String SHOW_SIGN_IN_PATH = "/jsp/sign_up.jsp";


    private SignUpCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new SignUpCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_SIGN_IN_PAGE = new ResponseContext() {

        @Override
        public String getPath() {
            return SHOW_SIGN_IN_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }
    };

    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        HttpSession session = requestContext.getCurrentSession().get();


        //  session.setAttribute("products","sdad");
        return SHOW_SIGN_IN_PAGE;
    }
}
