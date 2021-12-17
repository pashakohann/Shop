package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;

import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;


import javax.servlet.http.HttpSession;
import java.rmi.ServerException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

public class LookBasketCommand implements Command {
    private static Command command;
    private static String BASKET_PAGE = "/jsp/basket.jsp";
    private static String PRODUCT_ID_PARAM = "productId";
    private static final String ERROR_PARAM = "error";
    private static final String MESSAGE_PARAM = "message";
    private static final String BASKET_MAP_PARAM = "userBasket";
    private static final String BASKET_LIST_PARAM = "basketList";


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
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        HttpSession httpSession = requestContext.getCurrentSession().get();
        List<ProductDto> basket = backToListProducts((Map<ProductDto, Integer>) httpSession.getAttribute(BASKET_MAP_PARAM));


        httpSession.setAttribute(BASKET_LIST_PARAM, basket);


        return SHOW_BASKET;
    }

    private List<ProductDto> backToListProducts(Map<ProductDto, Integer> basket) {
        List<ProductDto> list = new ArrayList<>();
        int sizeBasket = 0;
                    if(basket!=null) {
                        for (Map.Entry<ProductDto, Integer> entry : basket.entrySet()) {
                            int iter = 0;
                            while (entry.getValue() != iter) {
                                list.add(entry.getKey());
                                iter++;
                            }
                        }
                    }
        return list;
    }
}
