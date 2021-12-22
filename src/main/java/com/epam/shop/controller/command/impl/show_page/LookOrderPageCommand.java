package com.epam.shop.controller.command.impl.show_page;


import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;

import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.dto.model.ProductDto;

import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LookOrderPageCommand implements Command {
    public static Command command;
    private static final String ORDER_PATH = "WEB-INF/jsp/products_in_order.jsp";
    private static final String ERROR_PATH = "WEB-INF/jsp/404.jsp";
    private static final String ORDER_ID_ATTRIBUTE = "orderId";
    private static final String PRODUCTS_FROM_ORDER = "productsFromOrderList";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message :";
    private static final String ERROR_ATTRIBUTE = "error";


    private static final Logger log = LogManager.getLogger(LookOrderPageCommand.class);

    private LookOrderPageCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new LookOrderPageCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_ORDER_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return ORDER_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }

    };

    private static final ResponseContext ERROR_EXIT_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return ERROR_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }

    };


    @Override
    public ResponseContext execute(RequestContext requestContext) {
        HttpSession httpSession = requestContext.getCurrentSession().get();

        try {

            OrderDto order = FactoryService.getOrderServiceInstance().getById(Integer.parseInt(requestContext.getParameter(ORDER_ID_ATTRIBUTE)));
            List<ProductDto> listProducts = FactoryService.getOrderServiceInstance().returnListProduct(order.getMapProducts());
            httpSession.setAttribute(PRODUCTS_FROM_ORDER, listProducts);
            httpSession.setAttribute(ORDER_ID_ATTRIBUTE, requestContext.getParameter(ORDER_ID_ATTRIBUTE));
        } catch (ServiceException e) {
            log.error(ERROR_ATTRIBUTE, e);
            requestContext.setAttribute(ERROR_ATTRIBUTE, MESSAGE_ERROR_ATTRIBUTE + e.getMessage());

        }


        return SHOW_ORDER_PAGE;
    }

}
