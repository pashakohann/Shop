package com.epam.shop.controller.command.impl.show_page;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.exception.ServiceException;


public class ShowPageAddProductCommand implements Command {
    public static Command command;
    private static final String ALL_ORDERS_PATH = "WEB-INF/jsp/create_product.jsp";


    private ShowPageAddProductCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new ShowPageAddProductCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_ADD_PRODUCT_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return ALL_ORDERS_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }

    };

    @Override
    public ResponseContext execute(RequestContext requestContext) {


        return SHOW_ADD_PRODUCT_PAGE;
    }
}
