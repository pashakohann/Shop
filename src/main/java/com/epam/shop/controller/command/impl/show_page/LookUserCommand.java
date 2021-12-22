package com.epam.shop.controller.command.impl.show_page;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;

import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;
import com.epam.shop.service.validation.api.ValidatorController;
import com.epam.shop.service.validation.impl.UserValidatorControllerImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;

public class LookUserCommand implements Command {
    public static Command command;
    private static final String ORDER_PATH = "WEB-INF/jsp/user.jsp";
    private static final String ERROR_PATH = "WEB-INF/jsp/all_accounts.jsp";

    private static final String ACCOUNT_USER_ID_ATTRIBUTE = "userIdView";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message: ";
    private static final String ERROR_ATTRIBUTE = "error";
    private static final String USER_OBJECT_VIEW = "userObjectView";

    private static final Logger log = LogManager.getLogger(LookUserCommand.class);

    private LookUserCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new LookUserCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_USER_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return ORDER_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }

    };

    private static final ResponseContext SHOW_ERROR = new ResponseContext() {
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
    public ResponseContext execute(RequestContext requestContext)  {
        HttpSession httpSession = requestContext.getCurrentSession().get();
        ValidatorController validator = UserValidatorControllerImpl.getInstance();
        boolean isException = false;

        try {
            validator.validate(requestContext.getParameter(ACCOUNT_USER_ID_ATTRIBUTE));
            int userId = Integer.parseInt(requestContext.getParameter(ACCOUNT_USER_ID_ATTRIBUTE));
            UserDto userDto = FactoryService.getUserServiceInstance().getById(userId);
            httpSession.setAttribute(USER_OBJECT_VIEW, userDto);
        } catch (ServiceException e) {
            log.error(ERROR_ATTRIBUTE,e);
            requestContext.setAttribute(ERROR_ATTRIBUTE,MESSAGE_ERROR_ATTRIBUTE+e.getMessage());

            isException = true;
        }
        if (isException) {
            return SHOW_ERROR;
        }
        return SHOW_USER_PAGE;
    }
}
