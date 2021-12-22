package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.command.impl.show_page.WhoseOrderCommand;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceProductExceptionString;
import com.epam.shop.service.factory.FactoryService;
import com.epam.shop.service.validation.api.ValidatorController;
import com.epam.shop.service.validation.impl.ProductValidatorImplController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

public class AddProductCommand implements Command {
    public static Command command;
    private static final String ERROR_PATH = "WEB-INF/jsp/create_product.jsp";
    private static final String CREATE_PRODUCT_PATH = "shop?command=show_add_product_command";
    private static final String PRODUCT_NAME_ATTRIBUTE = "name";
    private static final String PRODUCT_COST_ATTRIBUTE = "cost";
    private static final String PRODUCT_CATEGORY_ATTRIBUTE = "category";
    private static final String PRODUCT_BRAND_ATTRIBUTE = "brand";
    private static final String PRODUCT_PHOTO_LINK_ATTRIBUTE = "photoLink";
    private static final String ERROR_PARAM = "error";
    private static final String MESSAGE_PARAM = "message: ";
    private static final String PRODUCTS_LIST = "productsList";
    private static final String DELIMITER = "&&&";

    private static final Logger log = LogManager.getLogger(AddProductCommand.class);


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
            return true;
        }

    };

    private static final ResponseContext ERROR_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return ERROR_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }

    };

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        HttpSession httpSession = requestContext.getCurrentSession().get();
        boolean isException = false;
        ValidatorController validatorController = ProductValidatorImplController.getInstance();
        ProductDto productDto = new ProductDto();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(requestContext.getParameter(PRODUCT_NAME_ATTRIBUTE)).append(DELIMITER).
                append(requestContext.getParameter(PRODUCT_COST_ATTRIBUTE)).append(DELIMITER).
                append(requestContext.getParameter(PRODUCT_PHOTO_LINK_ATTRIBUTE));

        try {
            checkNullParameter(requestContext.getParameter(PRODUCT_NAME_ATTRIBUTE),
                    requestContext.getParameter(PRODUCT_COST_ATTRIBUTE),
                    requestContext.getParameter(PRODUCT_PHOTO_LINK_ATTRIBUTE));
            validatorController.validate(stringBuilder.toString());

            List<ProductDto> productsList;
            productDto.setName(requestContext.getParameter(PRODUCT_NAME_ATTRIBUTE));
            productDto.setCost(new BigDecimal(requestContext.getParameter(PRODUCT_COST_ATTRIBUTE)));
            productDto.setCategoryId(Integer.valueOf(requestContext.getParameter(PRODUCT_CATEGORY_ATTRIBUTE)));
            productDto.setBrandId(Integer.valueOf(requestContext.getParameter(PRODUCT_BRAND_ATTRIBUTE)));
            productDto.setPhotoLink(requestContext.getParameter(PRODUCT_PHOTO_LINK_ATTRIBUTE));

            FactoryService.getProductServiceInstance().create(productDto);
            productsList = FactoryService.getProductServiceInstance().getAll();
            httpSession.setAttribute(PRODUCTS_LIST, productsList);
        } catch (ServiceException e) {
            requestContext.setAttribute(ERROR_PARAM, MESSAGE_PARAM + e.getMessage());
            log.error(ERROR_PARAM, e);
            isException = true;
        }

        if (isException) {
            return ERROR_PAGE;
        }

        return SHOW_ADD_PRODUCT_PAGE;
    }

    private void checkNullParameter(String parameter, String parameter2, String parameter3) throws ServiceException {
        if (parameter == null || parameter2 == null || parameter3 == null) {
            throw new ServiceException(ServiceProductExceptionString.FILL_ALL_FIELDS_EXCEPTION);
        }
    }
}
