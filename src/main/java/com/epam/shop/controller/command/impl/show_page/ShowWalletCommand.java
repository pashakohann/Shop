package com.epam.shop.controller.command.impl.show_page;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.exception.ServiceException;

public class ShowWalletCommand implements Command {
    public static Command command;
    private static final String PROFILE_PATH = "/jsp/your_wallet.jsp";
    private static final String ACCOUNT_OBJECT_PARAM = "account";


    private ShowWalletCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new ShowWalletCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_WALLET_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return PROFILE_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }

    };

    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {

        return SHOW_WALLET_PAGE;
    }
}
