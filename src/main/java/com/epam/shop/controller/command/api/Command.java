package com.epam.shop.controller.command.api;


import com.epam.shop.controller.command.Commands;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.exception.ServiceException;


public interface Command {

    ResponseContext execute(RequestContext requestContext) throws ServiceException;

    static Command withName(String command) {
        return Commands.of(command).getCommand();
    }
}
