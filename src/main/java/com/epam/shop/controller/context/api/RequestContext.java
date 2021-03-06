package com.epam.shop.controller.context.api;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public interface RequestContext {

    HttpSession createSession();

    Optional<HttpSession> getCurrentSession();

    void invalidateCurrentSession();

    String getParameter(String name);

    void setAttribute(String name, Object value);


    String getHeader();


    String getContextPath();


     Cookie[] getCookies();

}
