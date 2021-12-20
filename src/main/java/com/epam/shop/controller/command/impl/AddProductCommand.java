package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

public class AddProductCommand implements Command {
    public static Command command;
    private static final String CREATE_PRODUCT_PATH = "/jsp/create_product.jsp";
    private static final String PRODUCT_NAME_ATTRIBUTE = "name";
    private static final String PRODUCT_COST_ATTRIBUTE = "cost";
    private static final String PRODUCT_CATEGORY_ATTRIBUTE = "category";
    private static final String PRODUCT_BRAND_ATTRIBUTE = "brand";
    private static final String PRODUCT_PHOTO_LINK_ATTRIBUTE = "photoLink";
    private static final String ERROR_PARAM = "error";
    private static final String MESSAGE_PARAM = "message: ";
    private static final String PRODUCTS_LIST = "productsList";


    private AddProductCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new AddProductCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_ADD_PRODUCT_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return CREATE_PRODUCT_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }

    };

    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        HttpSession httpSession = requestContext.getCurrentSession().get();
        BigDecimal bigDecimal = new BigDecimal(requestContext.getParameter(PRODUCT_COST_ATTRIBUTE));
        ProductDto productDto = new ProductDto();

        try {
            List<ProductDto> productsList;
            productDto.setName(requestContext.getParameter(PRODUCT_NAME_ATTRIBUTE));
            productDto.setCost(bigDecimal);
            productDto.setCategoryId(Integer.valueOf(requestContext.getParameter(PRODUCT_CATEGORY_ATTRIBUTE)));
            productDto.setBrandId(Integer.valueOf(requestContext.getParameter(PRODUCT_BRAND_ATTRIBUTE)));
            productDto.setPhotoLink(requestContext.getParameter(PRODUCT_PHOTO_LINK_ATTRIBUTE));

            FactoryService.getProductServiceInstance().create(productDto);
            productsList = FactoryService.getProductServiceInstance().getAll();
            httpSession.setAttribute(PRODUCTS_LIST, productsList);
        } catch (ServiceException e) {
            requestContext.setAttribute(ERROR_PARAM, MESSAGE_PARAM + e.getMessage());
        }


        return SHOW_ADD_PRODUCT_PAGE;
    }
}
