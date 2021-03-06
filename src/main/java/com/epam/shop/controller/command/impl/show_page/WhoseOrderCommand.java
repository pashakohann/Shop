package com.epam.shop.controller.command.impl.show_page;

import com.epam.shop.controller.command.api.Command;

import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.AccountDto;

import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;


public class WhoseOrderCommand implements Command {
    public static Command command;
    private static final String ORDER_PATH = "/WEB-INF/jsp/account.jsp";
    private static final String ACCOUNT_ID_ATTRIBUTE = "accountId";
    private static final String ACCOUNT_OBJECT_ATTRIBUTE = "accountView";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message: ";
    private static final String ERROR_ATTRIBUTE = "error";

    private static final Logger log = LogManager.getLogger(WhoseOrderCommand.class);


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
    public ResponseContext execute(RequestContext requestContext)  {
        HttpSession httpSession = requestContext.getCurrentSession().get();

        try {
            int accountId = Integer.parseInt(requestContext.getParameter(ACCOUNT_ID_ATTRIBUTE));
            AccountDto accountDto = FactoryService.getAccountServiceInstance().getById(accountId);
            httpSession.setAttribute(ACCOUNT_OBJECT_ATTRIBUTE, accountDto);
        } catch (ServiceException e) {
            log.error(ERROR_ATTRIBUTE,e);
            requestContext.setAttribute(ERROR_ATTRIBUTE,MESSAGE_ERROR_ATTRIBUTE+e.getMessage());
        }
        return SHOW_ACCOUNT_PAGE;
    }


}
