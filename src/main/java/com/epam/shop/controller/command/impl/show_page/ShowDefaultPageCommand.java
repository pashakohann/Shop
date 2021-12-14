package com.epam.shop.controller.command.impl.show_page;


import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowDefaultPageCommand implements Command {
    public static Command command;
    private static final String MAIN_PAGE_PATH = "/jsp/main.jsp";


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
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {

       List<ProductDto> productDtoList = FactoryService.getProductServiceInstance().getAll();

        HttpSession session = requestContext.getCurrentSession().get();
        session.setAttribute("products",productDtoList);

        return SHOW_MAIN_PAGE;
    }
}
