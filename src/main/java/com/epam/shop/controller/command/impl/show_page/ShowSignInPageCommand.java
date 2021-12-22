package com.epam.shop.controller.command.impl.show_page;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;


public class ShowSignInPageCommand implements Command {
    public static Command command;
    private static final String SIGN_IN_PATH = "WEB-INF/jsp/sign_in.jsp";

    private ShowSignInPageCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new ShowSignInPageCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_SIGN_IN_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return SIGN_IN_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }

    };

    @Override
    public ResponseContext execute(RequestContext requestContext)  {

        return SHOW_SIGN_IN_PAGE;
    }
}
