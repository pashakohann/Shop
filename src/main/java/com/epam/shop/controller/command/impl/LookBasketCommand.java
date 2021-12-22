package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;

import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.factory.FactoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;



import java.util.List;
import java.util.Map;

public class LookBasketCommand implements Command {
    private static Command command;
    private static String BASKET_PAGE = "WEB-INF/jsp/basket.jsp";
    private static String PRODUCT_ID_PARAM = "productId";
    private static final String ERROR_PARAM = "error";
    private static final String MESSAGE_PARAM = "message";
    private static final String BASKET_MAP_PARAM = "userBasket";
    private static final String BASKET_LIST_PARAM = "basketList";

    private static final Logger log = LogManager.getLogger( LookBasketCommand.class);


    private LookBasketCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new LookBasketCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_BASKET = new ResponseContext() {
        public String getPath() {
            return BASKET_PAGE;
        }

        public boolean isRedirect() {
            return false;
        }

    };

    @Override
    public ResponseContext execute(RequestContext requestContext)  {
        HttpSession httpSession = requestContext.getCurrentSession().get();
        List<ProductDto> basket = FactoryService.getOrderServiceInstance().
                returnListProduct((Map<ProductDto, Integer>) httpSession.getAttribute(BASKET_MAP_PARAM));


        httpSession.setAttribute(BASKET_LIST_PARAM, basket);

        return SHOW_BASKET;
    }

}
