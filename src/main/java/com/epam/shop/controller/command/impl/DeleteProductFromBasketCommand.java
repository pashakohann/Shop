package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.api.BasketService;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;
import com.epam.shop.service.impl.BasketServiceImpl;

import javax.servlet.http.HttpSession;
import java.rmi.ServerException;
import java.util.HashMap;

public class DeleteProductFromBasketCommand implements Command {
    private static Command command;
    private static String RETURN_PAGE = "/jsp/basket.jsp";
    private static String PRODUCT_ID_PARAM = "productId";
    private static final String ERROR_PARAM = "error";
    private static final String MESSAGE_PARAM = "message";
    private static final String BASKET_USER_OBJECT ="basketObject";
    private static final String BASKET_MAP_PARAM = "userBasket";
    private static final String BASKET_LIST_PARAM = "basketList";
    private static final String BASKET_SIZE_PARAM = "basketSize";

    private DeleteProductFromBasketCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new DeleteProductFromBasketCommand();
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
        String productId =  (requestContext.getParameter(PRODUCT_ID_PARAM));
        BasketService<ProductDto,BasketServiceImpl>basketService;
        try {

            if (requestContext.getCurrentSession().isPresent()){
                HttpSession httpSession = requestContext.getCurrentSession().get();
                basketService = ((BasketServiceImpl)(httpSession.getAttribute(BASKET_USER_OBJECT))).deleteProduct(Integer.parseInt(productId));



                httpSession.setAttribute(BASKET_USER_OBJECT, basketService);
                httpSession.setAttribute(BASKET_MAP_PARAM,basketService.lookBasket());
                httpSession.setAttribute(BASKET_LIST_PARAM,basketService.backToListProducts());
                httpSession.setAttribute(BASKET_SIZE_PARAM,basketService.basketSize());


            }
        } catch (ServiceException e) {
            //log
            requestContext.setAttribute(ERROR_PARAM, MESSAGE_PARAM + ":" + e.getMessage());
        }

        return SHOW_PERSONAL_ACC;
    }
}
