package com.epam.shop.controller.command.impl.show_page;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;

import java.util.List;

public class ShowPanelCommand implements Command {
    public static Command command;
    private static final String ALL_USER_PATH = "WEB-INF/jsp/all_user.jsp";
    private static final String LIST_USERS_ATTRIBUTE = "userList";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message: ";
    private static final String ERROR_ATTRIBUTE = "error";

    private static final Logger log = LogManager.getLogger(ShowPanelCommand.class);

    private ShowPanelCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new ShowPanelCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_ALL_USER_PAGE = new ResponseContext() {
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
                 List<UserDto> userList = FactoryService.getUserServiceInstance().getAll();
                 HttpSession httpSession = requestContext.getCurrentSession().get();
                 httpSession.setAttribute(LIST_USERS_ATTRIBUTE, userList);
             }catch (ServiceException e){
                 log.error(ERROR_ATTRIBUTE,e);
                 requestContext.setAttribute(ERROR_ATTRIBUTE,MESSAGE_ERROR_ATTRIBUTE+e.getMessage());
             }



        return SHOW_ALL_USER_PAGE;
    }
}
