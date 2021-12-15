package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;

import javax.servlet.http.HttpSession;


public class AuthorizationCommand implements Command {
    private static Command command;
    private static final String PANEL_USER_PAGE_PATH = "/jsp/personal_acc.jsp";
    private static final String ADMINISTRATION_PAGE_PATH = "/jsp/admin_panel.jsp";
    private static final String ERROR_PAGE = "/jsp/sign_in.jsp";
    private static final String USER_ROLE_ATTRIBUTE_NAME = "userId";
    private static final String LOGIN_PARAM = "login";
    private static final String PASSWORD_PARAM = "password";
    private static final String ERROR_ATTRIBUTE = "error";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message";
    private static final String ACCOUNT_ID = "userId";


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

    private static final ResponseContext ADMINISTRATION_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return ADMINISTRATION_PAGE_PATH;
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
        UserDto userDto = new UserDto();
        userDto.setAccount(userName);
        userDto.setPassword(userPassword);
        UserDto userDtoResponse = null;
        boolean isError = false;
        try {

            userDtoResponse = FactoryService.getUserServiceInstance().findUser(userDto);


        } catch (ServiceException e) {
            requestContext.setAttribute(ERROR_ATTRIBUTE, MESSAGE_ERROR_ATTRIBUTE + ":" + e.getMessage());
            isError = true;
        }

        if (isError) {
            return SHOW_ERROR_PAGE;
        } else if (userDtoResponse.getRole().getId() == 1) {
            HttpSession httpSession = requestContext.getCurrentSession().get();
            httpSession.setAttribute(ACCOUNT_ID, userDtoResponse.getId());
            httpSession.setAttribute(USER_ROLE_ATTRIBUTE_NAME, userDtoResponse.getRole().getId());
            return ADMINISTRATION_PAGE;
        } else if (userDtoResponse.getRole().getId() == 2) {
            HttpSession httpSession = requestContext.getCurrentSession().get();
            httpSession.setAttribute(ACCOUNT_ID, userDtoResponse.getId());
            httpSession.setAttribute(USER_ROLE_ATTRIBUTE_NAME, userDtoResponse.getRole().getId());
            return LOGIN_SUCCESS_PAGE;
        }


        return SHOW_ERROR_PAGE;
    }


}
