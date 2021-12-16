package com.epam.shop.controller.command.impl.show_page;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.exception.ServiceException;

public class ShowErrorPageCommand implements Command {
    public static Command command;
    private static final String ERROR_PAGE_PATH = "/jsp/404.jsp";

    private ShowErrorPageCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new ShowErrorPageCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_ERROR_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return ERROR_PAGE_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }

    };

    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {

        return SHOW_ERROR_PAGE;
    }
}
