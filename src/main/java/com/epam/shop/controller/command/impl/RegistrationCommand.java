package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;


public class RegistrationCommand implements Command {
    private static final String LOGIN_NAME_PARAM = "login";
    private static final String PASSWORD_PARAM  = "password";
    private static final String ROLE_ACCOUNT_PARAM = "role";
    //  private static final String IN
    public static Command command;

    private static final String PERSONAL_ACC_PAGE_PATH = "/jsp/personal_acc.jsp";


    private RegistrationCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new RegistrationCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_MAIN_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return PERSONAL_ACC_PAGE_PATH;
        }

        @Override
        public boolean isRedirect() {
            return true;
        }
    };


    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
//        String loginName = requestContext.getParameter("login");
//        String password = requestContext.getParameter("password");
//        UserDto userDto = new UserDto();
//        userDto.setRegistrationDate(LocalDateTime.now());
//        userDto.setAccount(loginName);
//        userDto.setPassword(password);
//        userDto = FactoryService.getUserServiceInstance().create(userDto);
//        HttpSession session = requestContext.createSession();
//        session.setAttribute("account_id", userDto.getId());
//        session.setAttribute("role", userDto.getRole().getId());
        return SHOW_MAIN_PAGE;
    }
}
