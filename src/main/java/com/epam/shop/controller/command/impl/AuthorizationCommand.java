package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.dto.model.UserRoleDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;

import javax.servlet.http.HttpSession;


public class AuthorizationCommand implements Command {
    private static Command command;
    private static final String PANEL_USER_PAGE_PATH = "/jsp/personal_acc.jsp";

    private static final String ERROR_PAGE = "/jsp/sign_in.jsp";
    private static final String ERROR_404 = "/jsp/404.jsp";
    private static final String USER_ROLE_ATTRIBUTE_NAME = "currentUser";
    private static final String LOGIN_PARAM = "login";
    private static final String PASSWORD_PARAM = "password";
    private static final String ERROR_ATTRIBUTE = "error";
    private static final String ERROR_MESSAGE = "Your fields are empty. ";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message";
    private static final String ACCOUNT_ID_PARAM = "accountId";


    private AuthorizationCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new AuthorizationCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_ERROR_PAGE = new ResponseContext() {

        @Override
        public String getPath() {
            return ERROR_PAGE;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }
    };

    private static final ResponseContext SHOW_404 = new ResponseContext() {
        @Override
        public String getPath() {
            return ERROR_404;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }
    };

    private static final ResponseContext LOGIN_SUCCESS_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return PANEL_USER_PAGE_PATH;
        }

        @Override
        public boolean isRedirect() {
            return true;
        }


    };

    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {

        final String userName = requestContext.getParameter(LOGIN_PARAM);
        final String userPassword = requestContext.getParameter(PASSWORD_PARAM);
        HttpSession httpSession = requestContext.getCurrentSession().get();
        UserDto userDto = new UserDto();
        userDto.setAccount(userName);
        userDto.setPassword(userPassword);
        userDto.setRole(UserRoleDto.UNAUTHORIZED);
        boolean isError = false;
        try {

            userDto = FactoryService.getUserServiceInstance().findUser(userDto);

        } catch (ServiceException e) {
            requestContext.setAttribute(ERROR_ATTRIBUTE, MESSAGE_ERROR_ATTRIBUTE + ":" + e.getMessage());
            isError = true;
        }
        System.out.println(userDto);
        if (isError) {
            return SHOW_ERROR_PAGE;

        }
        System.out.println(FactoryService.getAccountServiceInstance().getById(userDto.getId()).getId() + " csssssss");
        httpSession.setAttribute(ACCOUNT_ID_PARAM, FactoryService.getAccountServiceInstance().getById(userDto.getId()).getId());
        httpSession.setAttribute(USER_ROLE_ATTRIBUTE_NAME, userDto);


        return LOGIN_SUCCESS_PAGE;

    }

}
