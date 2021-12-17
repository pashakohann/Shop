package com.epam.shop.controller.command.impl.show_page;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowProductPageCommand implements Command {
    public static Command command;
    private static final String ALL_PRODUCTS_PATH = "/jsp/all_products.jsp";
    private static final String LIST_PRODUCTS_ATTRIBUTE = "productsList";

    private ShowProductPageCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new ShowProductPageCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_ALL_PRODUCTS_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return ALL_PRODUCTS_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }

    };

    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        List<ProductDto> listProducts = FactoryService.getProductServiceInstance().getAll();
        HttpSession httpSession = requestContext.getCurrentSession().get();
        httpSession.setAttribute(LIST_PRODUCTS_ATTRIBUTE, listProducts);

        return SHOW_ALL_PRODUCTS_PAGE;
    }
}
