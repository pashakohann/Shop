package com.epam.shop.controller.command.impl.show_page;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LookOrderPageCommand implements Command {
    public static Command command;
    private static final String ORDER_PATH = "/jsp/products_in_order.jsp";
    private static final String ORDER_ID_ATTRIBUTE = "orderId";
    private static final String PRODUCTS_FROM_ORDER = "productsFromOrderList";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message";
    private static final String ERROR_ATTRIBUTE = "error";

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

    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        HttpSession httpSession = requestContext.getCurrentSession().get();
        OrderDto order = FactoryService.getOrderServiceInstance().getById(Integer.parseInt(requestContext.getParameter(ORDER_ID_ATTRIBUTE)));
        List<ProductDto>listProducts = backToListProducts(order.getMapProducts());
        httpSession.setAttribute(PRODUCTS_FROM_ORDER ,listProducts);

        return SHOW_ORDER_PAGE;
    }

    private List<ProductDto> backToListProducts(Map<ProductDto, Integer> basket) {
        List<ProductDto> list = new ArrayList<>();
        int sizeBasket = 0;
        if(basket!=null) {
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
