package com.epam.shop.controller.command.impl.show_page;

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

public class ShowProductPageCommand implements Command {
    public static Command command;
    private static final String ALL_PRODUCTS_PATH = "WEB-INF/jsp/all_products.jsp";
    private static final String LIST_PRODUCTS_ATTRIBUTE = "productsList";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message: ";
    private static final String ERROR_ATTRIBUTE = "error";

    private static final Logger log = LogManager.getLogger(ShowProductPageCommand.class);


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
    public ResponseContext execute(RequestContext requestContext)  {
        List<ProductDto> listProducts = null;
        try {
            listProducts = FactoryService.getProductServiceInstance().getAll();
        } catch (ServiceException e) {
            log.error(ERROR_ATTRIBUTE,e);
            requestContext.setAttribute(ERROR_ATTRIBUTE,MESSAGE_ERROR_ATTRIBUTE+e.getMessage());
        }
        HttpSession httpSession = requestContext.getCurrentSession().get();
        httpSession.setAttribute(LIST_PRODUCTS_ATTRIBUTE, listProducts);

        return SHOW_ALL_PRODUCTS_PAGE;
    }
}
