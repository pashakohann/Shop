package com.epam.shop.controller.command.impl.show_page;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.dto.model.UserRoleDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ShowPageOrderCommand implements Command {
    public static Command command;
    private static final String ALL_ORDERS_PATH = "WEB-INF/jsp/all_orders.jsp";
    private static final String LIST_ORDERS_ATTRIBUTE = "ordersList";
    private static final String CURRENT_USER_ATTRIBUTE = "currentUser";
    private static final String ACCOUNT_OBJECT_ATTRIBUTE = "account";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message";
    private static final String ERROR_ATTRIBUTE = "error";

    private static final Logger log = LogManager.getLogger(ShowPageOrderCommand.class);
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
    public ResponseContext execute(RequestContext requestContext){
        HttpSession httpSession =  requestContext.getCurrentSession().get();
        List<OrderDto> orderList = new ArrayList<>();

            try {
                if(((UserDto)httpSession.getAttribute(CURRENT_USER_ATTRIBUTE)).getRole().equals(UserRoleDto.ADMIN)){
                    orderList = FactoryService.getOrderServiceInstance().getAll();
                }else {
                    orderList = FactoryService.getOrderServiceInstance().findAccountOrders(((AccountDto) httpSession.getAttribute(ACCOUNT_OBJECT_ATTRIBUTE)));
                }
                httpSession.setAttribute(LIST_ORDERS_ATTRIBUTE, orderList);
            }catch (ServiceException e){
                log.error(ERROR_ATTRIBUTE,e);
                requestContext.setAttribute(ERROR_ATTRIBUTE,MESSAGE_ERROR_ATTRIBUTE+e.getMessage());

            }



        return SHOW_ALL_ORDERS_PAGE;
    }
}
