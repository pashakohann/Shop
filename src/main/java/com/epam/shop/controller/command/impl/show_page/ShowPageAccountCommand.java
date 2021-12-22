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
import java.util.List;

public class ShowPageAccountCommand implements Command {
    public static Command command;
    private static final String ALL_USER_PATH = "WEB-INF/jsp/all_accounts.jsp";
    private static final String LIST_ACCOUNTS_ATTRIBUTE = "accountsList";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message: ";
    private static final String ERROR_ATTRIBUTE = "error";

    private static final Logger log = LogManager.getLogger(ShowPageAccountCommand.class);
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
    public ResponseContext execute(RequestContext requestContext)  {
        try {

            List<AccountDto> accountList = FactoryService.getAccountServiceInstance().getAll();
            HttpSession httpSession = requestContext.getCurrentSession().get();
            httpSession.setAttribute(LIST_ACCOUNTS_ATTRIBUTE, accountList);

        }catch (ServiceException e){
            log.error(ERROR_ATTRIBUTE,e);
            requestContext.setAttribute(ERROR_ATTRIBUTE,MESSAGE_ERROR_ATTRIBUTE+e.getMessage());
        }


        return SHOW_ALL_ACCOUNTS_PAGE;
    }
}
