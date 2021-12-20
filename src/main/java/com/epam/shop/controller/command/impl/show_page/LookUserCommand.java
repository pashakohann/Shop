package com.epam.shop.controller.command.impl.show_page;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;

import javax.servlet.http.HttpSession;

public class LookUserCommand implements Command {
    public static Command command;
    private static final String ORDER_PATH = "/jsp/user.jsp";
    private static final String ACCOUNT_USER_ID_ATTRIBUTE = "userIdView";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message: ";
    private static final String USER_OBJECT_VIEW = "userObjectView";
    private static final String ERROR_ATTRIBUTE = "error";

    private LookUserCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new LookUserCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_USER_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return ORDER_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }

    };

    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        HttpSession httpSession = requestContext.getCurrentSession().get();
        int userId = Integer.parseInt(requestContext.getParameter(ACCOUNT_USER_ID_ATTRIBUTE));
        try {
            UserDto userDto = FactoryService.getUserServiceInstance().getById(userId);
            httpSession.setAttribute(USER_OBJECT_VIEW , userDto);
        } catch (ServiceException e) {
            requestContext.setAttribute(ERROR_ATTRIBUTE, MESSAGE_ERROR_ATTRIBUTE + e.getMessage());
        }
        return SHOW_USER_PAGE;
    }
}
