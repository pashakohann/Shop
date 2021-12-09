package com.epam.shop.controller.command.impl;


import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;

public class DefaultCommand implements Command {
    public static Command command;
    private static final String MAIN_PAGE_PATH = "/jsp/main.jsp";


    private DefaultCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new DefaultCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_MAIN_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return MAIN_PAGE_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }
    };

    @Override
    public ResponseContext execute(RequestContext requestContext) {

        return SHOW_MAIN_PAGE;
    }
}
