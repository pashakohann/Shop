package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.util.List;

public class FindProductsByCategoryCommand implements Command {
    public static Command command;
    private static final String MAIN_PAGE_PATH = "WEB-INF/jsp/main.jsp";
    private static final String ACCOUNT_PANEL_PATH = "WEB-INF/jsp/personal_acc.jsp";
    private static final String USER_ROLE_ATTRIBUTE_NAME = "currentUser";
    private static final String ALL_PRODUCTS_LIST = "productsList";
    private static final String CATEGORY_ATTRIBUTE = "category";
    private static final String ERROR_PARAM = "error";
    private static final String MESSAGE_PARAM = "message:";

    private static final Logger log = LogManager.getLogger( FindProductsByCategoryBrandCommand.class);

    private FindProductsByCategoryCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new FindProductsByCategoryCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_MAIN_PAGE = new ResponseContext() {

        @Override
        public String getPath() {
            return MAIN_PAGE_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }
    };

    private static final ResponseContext SHOW_USER_PAGE = new ResponseContext() {

        @Override
        public String getPath() {
            return ACCOUNT_PANEL_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }
    };

    @Override
    public ResponseContext execute(RequestContext requestContext)  {
        final Integer categoryId = Integer.parseInt(requestContext.getParameter(CATEGORY_ATTRIBUTE));
        HttpSession session = requestContext.getCurrentSession().get();
        try {
            List<ProductDto> productDtoList = FactoryService.getProductServiceInstance().findProductsByCategory(categoryId);
            session.setAttribute( ALL_PRODUCTS_LIST, productDtoList);
        }catch (ServiceException e){
            log.error(ERROR_PARAM,e);
            requestContext.setAttribute(ERROR_PARAM,MESSAGE_PARAM+e.getMessage());
        }


        if(((UserDto)(session.getAttribute(USER_ROLE_ATTRIBUTE_NAME))).getRole().name().equals("ADMIN") ||
                ((UserDto)(session.getAttribute(USER_ROLE_ATTRIBUTE_NAME))).getRole().name().equals("USER")){
            return SHOW_USER_PAGE;
        }


        return SHOW_MAIN_PAGE;
    }
}
