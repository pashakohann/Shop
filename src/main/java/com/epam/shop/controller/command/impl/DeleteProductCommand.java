package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;

import java.util.List;


public class DeleteProductCommand implements Command {
    private static Command command;
    private static final String ALL_PRODUCTS_PATH = "WEB-INF/jsp/all_products.jsp";
    private static String PRODUCT_ID_PARAM = "productId";
    private static final String LIST_PRODUCTS_ATTRIBUTE = "productsList";
    private static final String ERROR_PARAM = "error";
    private static final String MESSAGE_PARAM = "message";

    private static final Logger log = LogManager.getLogger( DeleteProductCommand.class);


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
    public ResponseContext execute(RequestContext requestContext){
        HttpSession httpSession = requestContext.getCurrentSession().get();



        try {
            int productId = Integer.parseInt(requestContext.getParameter(PRODUCT_ID_PARAM));
            FactoryService.getProductServiceInstance().deleteById(productId);
            List<ProductDto>productDtoList = FactoryService.getProductServiceInstance().getAll();
            httpSession.setAttribute(LIST_PRODUCTS_ATTRIBUTE, productDtoList);
        } catch (ServiceException e) {
            log.error(ERROR_PARAM,e);
            requestContext.setAttribute(ERROR_PARAM, MESSAGE_PARAM + ":" + e.getMessage());
        }

        return SHOW_ALL_PRODUCTS_PAGE;
    }


}
