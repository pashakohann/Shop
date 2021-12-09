package com.epam.shop.controller.command.api;



import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;


public interface Command {

    ResponseContext execute(RequestContext requestContext);

    static Command of(String command) {
        return Command.of(command);
    }
}
