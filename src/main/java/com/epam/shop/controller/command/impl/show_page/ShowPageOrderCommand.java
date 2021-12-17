package com.epam.shop.controller.command.impl.show_page;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowPageOrderCommand implements Command {
    public static Command command;
    private static final String ALL_ORDERS_PATH = "/jsp/all_orders.jsp";
    private static final String LIST_ORDERS_ATTRIBUTE = "ordersList";

    private ShowPageOrderCommand () {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new ShowPageOrderCommand ();
        }
        return command;
    }

    private static final ResponseContext SHOW_ALL_ORDERS_PAGE = new ResponseContext() {
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
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        List<OrderDto> userList = FactoryService.getOrderServiceInstance().getAll();
        System.out.println("SHOW PANEL COMMAND!!!!");
        HttpSession httpSession = requestContext.getCurrentSession().get();
        httpSession.setAttribute(LIST_ORDERS_ATTRIBUTE, userList);
        System.out.println(userList);

        return SHOW_ALL_ORDERS_PAGE;
    }
}
