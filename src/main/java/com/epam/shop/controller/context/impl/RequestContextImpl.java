package com.epam.shop.controller.context.impl;

import com.epam.shop.controller.context.api.RequestContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class RequestContextImpl implements RequestContext {
    private final HttpServletRequest httpServletRequest;
    private static final String REFERER = "referer";

    public RequestContextImpl(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public HttpSession createSession() {
        return httpServletRequest.getSession(true);
    }

    @Override
    public Optional<HttpSession> getCurrentSession() {
        return Optional.ofNullable(httpServletRequest.getSession(false));
    }

    @Override
    public void invalidateCurrentSession() {
        final HttpSession session = httpServletRequest.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    @Override
    public String getHeader() {
        return httpServletRequest.getHeader(REFERER);
    }


    @Override
    public String getContextPath() {
        return httpServletRequest.getContextPath();
    }

    @Override
    public String getParameter(String name) {
        return httpServletRequest.getParameter(name);
    }

    @Override
    public void setAttribute(String name, Object value) {
        httpServletRequest.setAttribute(name, value);
    }


    public Cookie[] getCookies() {
        return httpServletRequest.getCookies();
    }
}
