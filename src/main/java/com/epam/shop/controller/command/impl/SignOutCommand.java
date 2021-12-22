package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;

import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.api.BasketService;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.impl.BasketServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;

public class SignOutCommand implements Command {
    public static Command command;
    private static final String SHOW_DEFAULT_PAGE = "WEB-INF/jsp/main.jsp";
    private static final String ERROR_PARAM = "error";
    private static final String MESSAGE_PARAM = "message";
    private static final String BASKET_PARAM = "basketSize";
    private static final String BASKET_MAP_PARAM = "userBasket";
    private static final String BASKET_USER_OBJECT ="basketObject";

    private static final Logger log = LogManager.getLogger( SignOutCommand.class);

    private SignOutCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new SignOutCommand();
        }
        return command;
    }

    private static final ResponseContext REDIRECT_MAIN_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return SHOW_DEFAULT_PAGE;
        }

        @Override
        public boolean isRedirect() {
            return true;
        }
    };


    @Override
    public ResponseContext execute(RequestContext requestContext) {
        BasketService<ProductDto,BasketServiceImpl> basketService;
        HttpSession httpSession = null;
        try {
            basketService = ((BasketServiceImpl)(httpSession.getAttribute(BASKET_USER_OBJECT))).clearBasket();
            httpSession = requestContext.getCurrentSession().get();
            httpSession.setAttribute(BASKET_MAP_PARAM, basketService.lookBasket());
            httpSession.setAttribute(BASKET_PARAM, basketService.basketSize());
            httpSession.setAttribute(BASKET_USER_OBJECT,basketService);

           requestContext.invalidateCurrentSession();
        }catch (ServiceException e){
            log.error(ERROR_PARAM,e);
            httpSession.setAttribute(ERROR_PARAM,MESSAGE_PARAM + ":" + e.getMessage());
        }

        return REDIRECT_MAIN_PAGE;
    }
}
