package com.epam.shop.controller;

import com.epam.shop.service.api.ConnectionService;
import com.epam.shop.service.impl.ConnectionServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/shop")
public class ApplicationController extends HttpServlet {
    private static final String COMMAND_PARAMETER = "inputName";
    private static final String NAME = "name";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Cookie cookie : req.getCookies()) {
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
            System.out.println(cookie);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


    @Override
    public void destroy() {
        super.destroy();
        ConnectionServiceImpl.getInstance().destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        ConnectionServiceImpl.getInstance().init();
    }
}
