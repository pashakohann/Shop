package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.api.BasketService;
import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.dto.model.UserRoleDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;
import com.epam.shop.service.impl.BasketServiceImpl;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;


public class RegistrationCommand implements Command {
    private static Command command;
    private static final String LOGIN_NAME_PARAM = "login";
    private static final String PASSWORD_PARAM = "password";
    private static final String ROLE_ACCOUNT_PARAM = "currentUser";
    private static final String ERROR = "error";
    private static final String MESSAGE_ERROR = "message";
    private static final String ACCOUNT_OBJECT_PARAM = "account";
    private static final String ERROR_PAGE = "/jsp/sign_up.jsp";
    private static final String PANEL_USER_PAGE_PATH = "/jsp/personal_acc.jsp";
    private static final String BASKET_USER_OBJECT ="basketObject";
    private static final String BASKET_PARAM = "basketSize";
    private static final String SECRET_ADMIN_PARAM = "secret";
    private BasketService<ProductDto, BasketServiceImpl> basket;

    private RegistrationCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new RegistrationCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_PERSONAL_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return PANEL_USER_PAGE_PATH;
        }

        @Override
        public boolean isRedirect() {
            return true;
        }
    };

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


    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        basket = new BasketServiceImpl();
        String loginName = requestContext.getParameter(LOGIN_NAME_PARAM);
        String password = requestContext.getParameter(PASSWORD_PARAM);
        boolean flagException = false;
        UserDto userDto = new UserDto();
        AccountDto accountDto = new AccountDto();
        userDto.setRegistrationDate(LocalDateTime.now());
        userDto.setAccount(loginName);
        userDto.setPassword(password);
        System.out.println(requestContext.getParameter(SECRET_ADMIN_PARAM));
        System.out.println(requestContext.getParameter(SECRET_ADMIN_PARAM).matches("epam"));
               if(requestContext.getParameter(SECRET_ADMIN_PARAM).matches("epam")){
                   userDto.setRole(UserRoleDto.ADMIN);
               }else {
                   userDto.setRole(UserRoleDto.USER);
               }

        try {

            userDto = FactoryService.getUserServiceInstance().create(userDto);
            accountDto.setUserId(userDto.getId());
            accountDto = FactoryService.getAccountServiceInstance().create(accountDto);

        } catch (ServiceException e) {
            //log
            //don't forget!
            requestContext.setAttribute(ERROR, MESSAGE_ERROR + ":" + e.getMessage());
            flagException = true;

        }

        if (flagException) {
            return SHOW_ERROR_PAGE;
        } else {

            HttpSession session = requestContext.getCurrentSession().get();
            session.setAttribute(ROLE_ACCOUNT_PARAM, userDto);
            session.setAttribute(ACCOUNT_OBJECT_PARAM,accountDto);
            session.setAttribute(BASKET_USER_OBJECT,basket);
            session.setAttribute(BASKET_PARAM,basket.basketSize());
            System.out.println(session.getAttribute(ROLE_ACCOUNT_PARAM));
        }

        System.out.println(userDto);

        return SHOW_PERSONAL_PAGE;
    }
}
