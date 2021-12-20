package com.epam.shop.controller.command.impl.show_page;

import com.epam.shop.controller.command.api.Command;

import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.AccountDto;

import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;

import javax.servlet.http.HttpSession;


public class WhoseOrderCommand implements Command {
    public static Command command;
    private static final String ORDER_PATH = "/jsp/account.jsp";
    private static final String ACCOUNT_ID_ATTRIBUTE = "accountId";
    private static final String ACCOUNT_OBJECT_ATTRIBUTE = "accountView";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message: ";
    private static final String ERROR_ATTRIBUTE = "error";

    private WhoseOrderCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new WhoseOrderCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_ACCOUNT_PAGE = new ResponseContext() {
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
        int accountId = Integer.parseInt(requestContext.getParameter(ACCOUNT_ID_ATTRIBUTE));
        try {
            AccountDto accountDto = FactoryService.getAccountServiceInstance().getById(accountId);
            httpSession.setAttribute(ACCOUNT_OBJECT_ATTRIBUTE, accountDto);
        } catch (ServiceException e) {
            requestContext.setAttribute(ERROR_ATTRIBUTE, MESSAGE_ERROR_ATTRIBUTE + e.getMessage());
        }
        return SHOW_ACCOUNT_PAGE;
    }


}
