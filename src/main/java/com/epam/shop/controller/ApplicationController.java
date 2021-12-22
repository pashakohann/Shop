package com.epam.shop.controller;


import com.epam.shop.controller.command.api.Command;

import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.controller.context.impl.RequestContextImpl;


import com.epam.shop.service.exception.ServiceException;

import com.epam.shop.service.impl.ConnectionServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;


@WebServlet(urlPatterns = "/shop")
public class ApplicationController extends HttpServlet {
    private static final String COMMAND_PARAMETER_NAME = "command";
    private static final String INIT_EXCEPTION = "there was a connection problem...Try later..";
    private static final String DESTROY_EXCEPTION = "there was a problem with disconnection ...";

    private static final Logger log = LogManager.getLogger(ApplicationController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        process(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        process(req, resp);

    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        final String commandName = req.getParameter(COMMAND_PARAMETER_NAME);

        final Command command = Command.withName(commandName);

        final ResponseContext response = command.execute(new RequestContextImpl(req));

        if (response.isRedirect()) {
            resp.sendRedirect(response.getPath());
        } else {
            final RequestDispatcher dispatcher = req.getRequestDispatcher(response.getPath());
            dispatcher.forward(req, resp);
        }

    }


    @Override
    public void destroy() {

        try {
            ConnectionServiceImpl.getInstance().destroy();
        } catch (ServiceException e) {
            log.error(DESTROY_EXCEPTION, e);
        }
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            ConnectionServiceImpl.getInstance().init();
        } catch (ServiceException e) {
            log.error(DESTROY_EXCEPTION, e);
        }

    }


}
