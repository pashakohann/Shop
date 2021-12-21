package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.AccountDto;

import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;


import com.epam.shop.service.validation.api.ValidatorController;
import com.epam.shop.service.validation.impl.AccountValidatorControllerImpl;


import javax.servlet.http.HttpSession;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class ChangeAccountCommand implements Command {
    public static Command command;
    private static final String BACK_PROFILE_PATH = "/jsp/profile.jsp";
    private static final String ACCOUNT_F_NAME_ATTRIBUTE = "firstName";
    private static final String ACCOUNT_L_NAME_ATTRIBUTE = "lastName";
    private static final String ACCOUNT_D_O_B_ATTRIBUTE = "dateOfBirth";
    private static final String ACCOUNT_MOBILE_F_ATTRIBUTE = "phone";
    private static final String ACCOUNT_EMAIL_ATTRIBUTE = "email";
    private static final String ACCOUNT_CITY_ATTRIBUTE = "city";
    private static final String ACCOUNT_STREET_ATTRIBUTE = "street";
    private static final String ACCOUNT_FLAT_ATTRIBUTE = "flat";
    private static final String ACCOUNT_OBJECT_ATTRIBUTE = "account";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message: ";
    private static final String ERROR_ATTRIBUTE = "error";
    private static final String DELIMITER = "&&&";
    private static final String EMPTY_FIELDS_EXCEPTION = "You need to fill in all the fields";


    private ChangeAccountCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new ChangeAccountCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_PROFILE_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return BACK_PROFILE_PATH;
        }

        @Override
        public boolean isRedirect() {
            return true;
        }

    };

    private static final ResponseContext SHOW_ERROR_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return BACK_PROFILE_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }

    };


    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        HttpSession httpSession = requestContext.getCurrentSession().get();
        AccountDto accountDto = (AccountDto) httpSession.getAttribute(ACCOUNT_OBJECT_ATTRIBUTE);
        ValidatorController validatorController = AccountValidatorControllerImpl.getInstance();
        StringBuilder checkingProfileData = new StringBuilder().append(requestContext.getParameter(ACCOUNT_F_NAME_ATTRIBUTE)).
                append(DELIMITER).append(requestContext.getParameter(ACCOUNT_L_NAME_ATTRIBUTE)).append(DELIMITER).
                append(requestContext.getParameter(ACCOUNT_D_O_B_ATTRIBUTE)).append(DELIMITER).
                append(requestContext.getParameter(ACCOUNT_MOBILE_F_ATTRIBUTE)).append(DELIMITER).
                append(requestContext.getParameter(ACCOUNT_EMAIL_ATTRIBUTE)).append(DELIMITER).
                append(requestContext.getParameter(ACCOUNT_CITY_ATTRIBUTE)).append(DELIMITER).
                append(requestContext.getParameter(ACCOUNT_STREET_ATTRIBUTE)).append(DELIMITER).
                append(requestContext.getParameter(ACCOUNT_FLAT_ATTRIBUTE));
        try {
            validatorController.validate(checkingProfileData.toString());
            accountDto.setFirstName(requestContext.getParameter(ACCOUNT_F_NAME_ATTRIBUTE));
            accountDto.setLastName(requestContext.getParameter(ACCOUNT_L_NAME_ATTRIBUTE));
            accountDto.setDateOfBirth(LocalDate.parse(requestContext.getParameter(ACCOUNT_D_O_B_ATTRIBUTE)));
            accountDto.setTelephoneNumber(requestContext.getParameter(ACCOUNT_MOBILE_F_ATTRIBUTE));
            accountDto.setEmail(requestContext.getParameter(ACCOUNT_EMAIL_ATTRIBUTE));
            accountDto.setCity(requestContext.getParameter(ACCOUNT_CITY_ATTRIBUTE));
            accountDto.setStreet(requestContext.getParameter(ACCOUNT_STREET_ATTRIBUTE));
            accountDto.setFlat(Integer.valueOf(requestContext.getParameter(ACCOUNT_FLAT_ATTRIBUTE)));
            accountDto = FactoryService.getAccountServiceInstance().update(accountDto);
            httpSession.setAttribute(ACCOUNT_OBJECT_ATTRIBUTE, accountDto);


        } catch (ServiceException e) {
            //log
            requestContext.setAttribute(ERROR_ATTRIBUTE, MESSAGE_ERROR_ATTRIBUTE + ": " + e.getMessage());

        }

        return SHOW_PROFILE_PAGE;
    }
}
