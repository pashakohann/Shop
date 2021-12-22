package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.api.BasketService;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.dto.model.UserRoleDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;
import com.epam.shop.service.impl.BasketServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


public class AuthorizationCommand implements Command {
    private static Command command;
    private BasketService<ProductDto, BasketServiceImpl> basket;
    private static final String PANEL_USER_PAGE_PATH = "/shop?command=show_account_panel_command";
    private static final String ERROR_PAGE = "WEB-INF/jsp/sign_in.jsp";
    private static final String ERROR_404 = "WEB-INF/jsp/404.jsp";
    private static final String USER_ROLE_ATTRIBUTE_NAME = "currentUser";
    private static final String LOGIN_PARAM = "login";
    private static final String PASSWORD_PARAM = "password";
    private static final String ERROR_MESSAGE = "Your fields are empty. ";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message";
    private static final String ERROR_ATTRIBUTE = "error";
    private static final String  ACCOUNT_OBJECT_PARAM = "account";;
    private static final String BASKET_USER_OBJECT ="basketObject";
    private static final String BASKET_PARAM = "basketSize";
    private static final String USER_NAME = "userLogin";

    private static final Logger log = LogManager.getLogger( AuthorizationCommand.class);

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
    public ResponseContext execute(RequestContext requestContext)  {
        basket = new BasketServiceImpl();
        List<ProductDto> productslist = new ArrayList<>();
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

            httpSession.setAttribute(ACCOUNT_OBJECT_PARAM, FactoryService.getAccountServiceInstance().findByUserId(userDto.getId()));
            httpSession.setAttribute(USER_ROLE_ATTRIBUTE_NAME, userDto);
            httpSession.setAttribute(BASKET_USER_OBJECT,basket);
            httpSession.setAttribute(BASKET_PARAM,basket.basketSize());
            requestContext.setAttribute(USER_NAME,userDto.getAccount());

        } catch (ServiceException e) {
            log.error(ERROR_ATTRIBUTE,e);
            requestContext.setAttribute(ERROR_ATTRIBUTE, MESSAGE_ERROR_ATTRIBUTE + ":" + e.getMessage());
            isError = true;
        }

        if (isError) {
            return SHOW_ERROR_PAGE;

        }


        System.out.println(requestContext.getContextPath());
        return LOGIN_SUCCESS_PAGE;

    }

}
