package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.api.BasketService;
import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;

import com.epam.shop.service.factory.FactoryService;
import com.epam.shop.service.impl.BasketServiceImpl;
import com.epam.shop.service.validation.api.ValidatorController;
import com.epam.shop.service.validation.impl.OrderValidatorController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;

import java.time.LocalDateTime;


public class OrderProductCommand implements Command {
    private static Command command;
    private static String RETURN_PAGE = "/shop?command=show_account_panel_command";
    private static final String ERROR_PARAM = "error";
    private static final String MESSAGE_PARAM = "message : ";
    private static final String BASKET_USER_OBJECT = "basketObject";
    private static final String BASKET_MAP_PARAM = "userBasket";
    private static final String BASKET_LIST_PARAM = "basketList";
    private static final String BASKET_SIZE_PARAM = "basketSize";
    private static final String ACCOUNT_OBJECT_PARAM = "account";
    private static final String ERROR_PAGE = "WEB-INF/jsp/basket.jsp";
    private static final String SUCCESS_ORDER = "success_order";


    private static final Logger log = LogManager.getLogger( OrderProductCommand.class);
    private OrderProductCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new OrderProductCommand();
        }
        return command;
    }


    private static final ResponseContext SHOW_ERROR_PAGE = new ResponseContext() {

        @Override
        public String getPath() {
            return ERROR_PAGE;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }
    };

    private static final ResponseContext SHOW_PERSONAL_ACC = new ResponseContext() {
        public String getPath() {
            return RETURN_PAGE;
        }

        public boolean isRedirect() {
            return true;
        }

    };

    @Override
    public ResponseContext execute(RequestContext requestContext)  {
        HttpSession httpSession = requestContext.getCurrentSession().get();
        ValidatorController validatorForDefault = OrderValidatorController.getInstance();
        BasketService<ProductDto, BasketServiceImpl> basketService;
        boolean isError = false;




        try {
            httpSession = requestContext.getCurrentSession().get();
            AccountDto accountDto = ((AccountDto)httpSession.getAttribute(ACCOUNT_OBJECT_PARAM));
            validatorForDefault.validate(accountDto.getFirstName());
            basketService = ((BasketServiceImpl) (httpSession.getAttribute(BASKET_USER_OBJECT)));
            OrderDto orderDto = new OrderDto();

            orderDto.setOrderDate(LocalDateTime.now());

            orderDto.setUserId(accountDto.getId());
            orderDto.setMapProducts(((BasketServiceImpl) (httpSession.getAttribute(BASKET_USER_OBJECT))).lookBasket());
            FactoryService.getOrderServiceInstance().create(orderDto);
            basketService = ((BasketServiceImpl) (httpSession.getAttribute(BASKET_USER_OBJECT))).clearBasket();
            accountDto = FactoryService.getAccountServiceInstance().getById(accountDto.getId());
            httpSession.setAttribute(BASKET_USER_OBJECT, basketService);
            httpSession.setAttribute(BASKET_MAP_PARAM, basketService.lookBasket());
            httpSession.setAttribute(BASKET_LIST_PARAM, basketService.backToListProducts());
            httpSession.setAttribute(BASKET_SIZE_PARAM, basketService.basketSize());
            httpSession.setAttribute(ACCOUNT_OBJECT_PARAM, accountDto);
        } catch (ServiceException e) {
            log.error(ERROR_PARAM,e);
            requestContext.setAttribute(ERROR_PARAM, MESSAGE_PARAM + e.getMessage());
            isError = true;
        }

        if (isError) {

            return SHOW_ERROR_PAGE;
        }


        return SHOW_PERSONAL_ACC;
    }

}
