package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceAccountExceptionString;
import com.epam.shop.service.factory.FactoryService;
import com.epam.shop.service.validation.validation_string.AccountValidationString;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;


public class TopUpMoneyCommand implements Command {
    public static Command command;
    private static final String BACK_TO_WALLET_PATH = "/jsp/your_wallet.jsp";

    private static final String ACCOUNT_AMOUNT_ATTRIBUTE = "amount";
    private static final String ACCOUNT_OBJECT_ATTRIBUTE = "account";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message";
    private static final String ERROR_ATTRIBUTE = "error";


    private TopUpMoneyCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new TopUpMoneyCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_WALLET_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return BACK_TO_WALLET_PATH;
        }

        @Override
        public boolean isRedirect() {
            return true;
        }

    };

    private static final ResponseContext ERROR_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return BACK_TO_WALLET_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }

    };


    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        HttpSession httpSession = requestContext.getCurrentSession().get();
        boolean isException = false;
        try {
            validateAmount(requestContext.getParameter(ACCOUNT_AMOUNT_ATTRIBUTE));
            BigDecimal bigDecimal = new BigDecimal(requestContext.getParameter(ACCOUNT_AMOUNT_ATTRIBUTE));
            AccountDto accountDto = (AccountDto) httpSession.getAttribute(ACCOUNT_OBJECT_ATTRIBUTE);
            accountDto.setAmount(accountDto.getAmount().add(bigDecimal));
            accountDto = FactoryService.getAccountServiceInstance().update(accountDto);
            httpSession.setAttribute(ACCOUNT_OBJECT_ATTRIBUTE, accountDto);
        } catch (ServiceException e) {
            //log
            requestContext.setAttribute(ERROR_ATTRIBUTE, MESSAGE_ERROR_ATTRIBUTE + ": " + e.getMessage());
            isException = true;
        }
              if (isException){
                  return ERROR_PAGE;
              }

        return SHOW_WALLET_PAGE;
    }

    private void validateAmount(String amount) throws ServiceException {
        if (!amount.matches(AccountValidationString.ACCOUNT_AMOUNT_REGEX)) {
            throw new ServiceException(ServiceAccountExceptionString.ACCOUNT_AMOUNT_EXCEPTION);
        }
    }
}
