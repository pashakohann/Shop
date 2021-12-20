package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;

import javax.servlet.http.HttpSession;

import java.util.List;


public class DeleteProductCommand implements Command {
    private static Command command;
    private static final String ALL_PRODUCTS_PATH = "/jsp/all_products.jsp";
    private static String PRODUCT_ID_PARAM = "productId";
    private static final String LIST_PRODUCTS_ATTRIBUTE = "productsList";
    private static final String ERROR_PARAM = "error";
    private static final String MESSAGE_PARAM = "message";


    private DeleteProductCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new DeleteProductCommand();
        }
        return command;
    }


    private static final ResponseContext SHOW_ALL_PRODUCTS_PAGE = new ResponseContext() {
        public String getPath() {
            return ALL_PRODUCTS_PATH;
        }

        public boolean isRedirect() {
            return false;
        }

    };

    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        HttpSession httpSession = requestContext.getCurrentSession().get();
        List<ProductDto> productDtoList;
        int productId = Integer.parseInt(requestContext.getParameter(PRODUCT_ID_PARAM));

        try {
            FactoryService.getProductServiceInstance().deleteById(productId);
            productDtoList = FactoryService.getProductServiceInstance().getAll();
            httpSession.setAttribute(LIST_PRODUCTS_ATTRIBUTE, productDtoList);
        } catch (ServiceException e) {
            //log
            requestContext.setAttribute(ERROR_PARAM, MESSAGE_PARAM + ":" + e.getMessage());
        }

        return SHOW_ALL_PRODUCTS_PAGE;
    }


}
