package com.epam.shop.controller.command.impl.show_page;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShowBasketPage implements Command {
    public static Command command;
    private static final String PERSONAL_ACC_PATH = "WEB-INF/jsp/personal_acc.jsp";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message: ";
    private static final String ERROR_ATTRIBUTE = "error";

    private static final Logger log = LogManager.getLogger(ShowAccountPanelPageCommand.class);


    private ShowBasketPage() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new ShowBasketPage();
        }
        return command;
    }

    private static final ResponseContext SHOW_ACCOUNT_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return PERSONAL_ACC_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }
    };


    @Override
    public ResponseContext execute(RequestContext requestContext) {


        return SHOW_ACCOUNT_PAGE;
    }
}
