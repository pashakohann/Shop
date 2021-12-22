package com.epam.shop.controller.command.impl.show_page;


import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.dto.model.UserDto;

import com.epam.shop.service.dto.model.UserRoleDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowDefaultPageCommand implements Command {
    public static Command command;
    private static final String MAIN_PAGE_PATH = "WEB-INF/jsp/main.jsp";
    private static final String ALL_PRODUCTS_LIST = "productsList";
    private static final String CURRENT_USER_ATTRIBUTE = "currentUser";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message: ";
    private static final String ERROR_ATTRIBUTE = "error";

    private static final Logger log = LogManager.getLogger(ShowDefaultPageCommand.class);


    private ShowDefaultPageCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new ShowDefaultPageCommand();
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


    @Override
    public ResponseContext execute(RequestContext requestContext) {

        HttpSession session = requestContext.getCurrentSession().get();
        try {
            List<ProductDto> productDtoList = FactoryService.getProductServiceInstance().getAll();
            UserDto userDto = new UserDto();
            userDto.setRole(UserRoleDto.UNAUTHORIZED);
            session.setAttribute(CURRENT_USER_ATTRIBUTE, userDto);
            session.setAttribute(ALL_PRODUCTS_LIST, productDtoList);
        } catch (ServiceException e) {
            log.error(ERROR_ATTRIBUTE,e);
            requestContext.setAttribute(ERROR_ATTRIBUTE,MESSAGE_ERROR_ATTRIBUTE+e.getMessage());
        }

        return SHOW_MAIN_PAGE;
    }
}
