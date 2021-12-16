package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.api.BasketService;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;
import com.epam.shop.service.impl.BasketServiceImpl;

import javax.servlet.http.HttpSession;
import java.rmi.ServerException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class OrderProductCommand implements Command {
    private static Command command;
    private static String RETURN_PAGE = "/jsp/personal_acc.jsp";
    private static final String ERROR_PARAM = "error";
    private static final String MESSAGE_PARAM = "message";
    private static final String BASKET_USER_OBJECT = "basketObject";
    private static final String BASKET_MAP_PARAM = "userBasket";
    private static final String BASKET_LIST_PARAM = "basketList";
    private static final String BASKET_SIZE_PARAM = "basketSize";
    private static final String ACCOUNT_ID_PARAM = "accountId";

    private OrderProductCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new OrderProductCommand();
        }
        return command;
    }


    private static final ResponseContext SHOW_PERSONAL_ACC = new ResponseContext() {
        public String getPath() {
            return RETURN_PAGE;
        }

        public boolean isRedirect() {
            return false;
        }

    };

    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        String productId = (requestContext.getParameter(ACCOUNT_ID_PARAM));
        BasketService<ProductDto, BasketServiceImpl> basketService;
        HttpSession httpSession = null;

        if (requestContext.getCurrentSession().isPresent()) {
            httpSession = requestContext.getCurrentSession().get();
        }
                try {
                    basketService = ((BasketServiceImpl) (httpSession.getAttribute(BASKET_USER_OBJECT)));
                    OrderDto orderDto = new OrderDto();
                    orderDto.setOrderDate(LocalDateTime.now());
                    orderDto.setUserId(Integer.parseInt(ACCOUNT_ID_PARAM));
                    orderDto.setMapProducts(((BasketServiceImpl) (httpSession.getAttribute(BASKET_USER_OBJECT))).lookBasket());
                    basketService = ((BasketServiceImpl) (httpSession.getAttribute(BASKET_USER_OBJECT))).clearBasket();
                    httpSession.setAttribute(BASKET_USER_OBJECT, basketService);
                    httpSession.setAttribute(BASKET_MAP_PARAM, basketService.lookBasket());
                    httpSession.setAttribute(BASKET_LIST_PARAM, basketService.backToListProducts());
                    httpSession.setAttribute(BASKET_SIZE_PARAM, basketService.basketSize());
                } catch (ServerException e) {
                    httpSession.setAttribute(ERROR_PARAM, MESSAGE_PARAM + ":" + e);
                }


        return SHOW_PERSONAL_ACC;
    }
}
