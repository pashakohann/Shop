package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;


public class ReturnBackActionCommand implements Command {
    private static Command command;
    private static String BASKET_PAGE = "WEB-INF/jsp/personal_acc.jsp";
    private static final String ERROR_PARAM = "error";
    private static final String MESSAGE_PARAM = "message";
    private static final String SIZE_BASKET_ATTRIBUTE = "basketSize";


    private static final Logger log = LogManager.getLogger( ReturnBackActionCommand.class);


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
            return false;
        }

    };

    @Override
    public ResponseContext execute(RequestContext requestContext)  {
        HttpSession httpSession = requestContext.getCurrentSession().get();
        httpSession.getAttribute(SIZE_BASKET_ATTRIBUTE);


        return SHOW_PAGE;
    }


}
