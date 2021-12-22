package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;


import javax.servlet.http.HttpSession;

public class LanguageCommand implements Command {
    private static Command command;
    private static final String LANGUAGE_PARAM = "language";
    private static String RETURN_PAGE_WITH_NEW_LANGUAGE;

    private LanguageCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new LanguageCommand();
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
    public ResponseContext execute(RequestContext requestContext)  {

        String language = requestContext.getParameter(LANGUAGE_PARAM);
        HttpSession httpSession = requestContext.getCurrentSession().get();

        httpSession.setAttribute(LANGUAGE_PARAM, language);
        RETURN_PAGE_WITH_NEW_LANGUAGE = requestContext.getContextPath() + requestContext.getHeader();
        return CHANGE_LANGUAGE_PAGE;
    }
}
