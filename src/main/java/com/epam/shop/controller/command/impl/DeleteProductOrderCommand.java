package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.api.BasketService;
import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;
import com.epam.shop.service.impl.BasketServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeleteProductOrderCommand implements Command {
    private static Command command;
    private static final String ORDER_PATH = "WEB-INF/jsp/products_in_order.jsp";
    private static String PRODUCT_ID_PARAM = "productId";
    private static String COST_PRODUCT_PARAM = "costProduct";
    private static final String ORDER_ID_ATTRIBUTE = "orderId";
    private static final String ERROR_PARAM = "error";
    private static final String MESSAGE_PARAM = "message";
    private static final String  ACCOUNT_OBJECT_PARAM = "account";;
    private static final String PRODUCTS_FROM_ORDER_PARAM = "productsFromOrderList";


    private static final Logger log = LogManager.getLogger( DeleteProductOrderCommand.class);


    private DeleteProductOrderCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new DeleteProductOrderCommand();
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
    public ResponseContext execute(RequestContext requestContext) {
        HttpSession httpSession = requestContext.getCurrentSession().get();
        List<ProductDto>productDtoList;
        int orderId =  Integer.valueOf (httpSession.getAttribute(ORDER_ID_ATTRIBUTE).toString());
        int productId  = Integer.parseInt(requestContext.getParameter(PRODUCT_ID_PARAM));
        AccountDto accountDto = (AccountDto) httpSession.getAttribute(ACCOUNT_OBJECT_PARAM);

        try {
            accountDto.setAmount(accountDto.getAmount().add(new BigDecimal(requestContext.getParameter(COST_PRODUCT_PARAM))));
          accountDto =   FactoryService.getAccountServiceInstance().update(accountDto);
            productDtoList = backToListProducts(FactoryService.getOrderServiceInstance().deleteProductFromOrder(orderId,productId).getMapProducts());
            httpSession.setAttribute(PRODUCTS_FROM_ORDER_PARAM,productDtoList);
            httpSession.setAttribute(ACCOUNT_OBJECT_PARAM,accountDto);
        } catch (ServiceException e) {
           log.error(ERROR_PARAM,e);
            requestContext.setAttribute(ERROR_PARAM, MESSAGE_PARAM + ":" + e.getMessage());
        }

        return SHOW_ORDER_PAGE ;
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
