package com.epam.shop.controller.command.impl.show_page;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.exception.ServiceException;




public class ShowSignUpPageCommand implements Command {
    public static Command command;
    private static final String SHOW_SIGN_IN_PATH = "/jsp/sign_up.jsp";


    private ShowSignUpPageCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new ShowSignUpPageCommand();
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


        return SHOW_SIGN_IN_PAGE;
    }
}
