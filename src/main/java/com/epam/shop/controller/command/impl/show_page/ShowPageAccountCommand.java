package com.epam.shop.controller.command.impl.show_page;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowPageAccountCommand implements Command {
    public static Command command;
    private static final String ALL_USER_PATH = "/jsp/all_accounts.jsp";
    private static final String LIST_ACCOUNTS_ATTRIBUTE = "accountsList";

    private ShowPageAccountCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new ShowPageAccountCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_ALL_ACCOUNTS_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return ALL_USER_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }

    };

    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        List<AccountDto> accountList = FactoryService.getAccountServiceInstance().getAll();
        HttpSession httpSession = requestContext.getCurrentSession().get();
        httpSession.setAttribute(LIST_ACCOUNTS_ATTRIBUTE, accountList);

        return SHOW_ALL_ACCOUNTS_PAGE;
    }
}
