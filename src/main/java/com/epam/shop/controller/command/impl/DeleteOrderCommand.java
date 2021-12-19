package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.dto.model.UserRoleDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeleteOrderCommand implements Command {
    private static Command command;
    private static final String ORDER_PATH = "/jsp/all_orders.jsp";
    private static String ORDERS_LIST_PARAM = "ordersList";
    private static String COST_PRODUCT_PARAM = "orderCost";
    private static final String ORDER_ID_ATTRIBUTE = "orderId";
    private static final String ERROR_PARAM = "error";
    private static final String MESSAGE_PARAM = "message";
    private static final String ACCOUNT_OBJECT_PARAM = "account";
    ;
    private static final String CURRENT_USER_PARAM = "currentUser";


    private DeleteOrderCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new DeleteOrderCommand();
        }
        return command;
    }


    private static final ResponseContext SHOW_ORDER_PAGE = new ResponseContext() {
        public String getPath() {
            return ORDER_PATH;
        }

        public boolean isRedirect() {
            return false;
        }

    };

    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        HttpSession httpSession = requestContext.getCurrentSession().get();
        OrderDto orderDto = FactoryService.getOrderServiceInstance().getById(Integer.valueOf(requestContext.getParameter(ORDER_ID_ATTRIBUTE)));
        List<OrderDto> listOrders;
        UserDto userDto = (UserDto) httpSession.getAttribute(CURRENT_USER_PARAM);
        AccountDto accountDto = (AccountDto) httpSession.getAttribute(ACCOUNT_OBJECT_PARAM);

        try {
            accountDto.setAmount(accountDto.getAmount().add(new BigDecimal(requestContext.getParameter(COST_PRODUCT_PARAM))));
           accountDto = FactoryService.getAccountServiceInstance().update(accountDto);
            FactoryService.getOrderServiceInstance().delete(orderDto);
            if (userDto.getRole().equals(UserRoleDto.ADMIN)) {
                listOrders = FactoryService.getOrderServiceInstance().getAll();
            } else {
                listOrders = FactoryService.getOrderServiceInstance().findAccountOrders(accountDto);
            }
            httpSession.setAttribute(ORDERS_LIST_PARAM, listOrders);
            httpSession.setAttribute(ACCOUNT_OBJECT_PARAM,accountDto);
        } catch (ServiceException e) {
            //log
            requestContext.setAttribute(ERROR_PARAM, MESSAGE_PARAM + ":" + e.getMessage());
        }

        return SHOW_ORDER_PAGE;
    }

    private List<ProductDto> backToListProducts(Map<ProductDto, Integer> basket) {
        List<ProductDto> list = new ArrayList<>();
        if (basket != null) {
            for (Map.Entry<ProductDto, Integer> entry : basket.entrySet()) {
                int iter = 0;
                while (entry.getValue() != iter) {
                    list.add(entry.getKey());
                    iter++;
                }
            }
        }
        return list;
    }

}
