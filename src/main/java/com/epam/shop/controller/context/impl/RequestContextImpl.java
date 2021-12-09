package com.epam.shop.controller.context.impl;

import com.epam.shop.controller.context.api.RequestContext;

import javax.servlet.http.HttpSession;
import java.util.Optional;

public class RequestContextImpl implements RequestContext {

    @Override
    public HttpSession createSession() {
        return null;
    }

    @Override
    public Optional<HttpSession> getCurrentSession() {
        return Optional.empty();
    }

    @Override
    public void invalidateCurrentSession() {

    }

    @Override
    public String getParameter(String name) {
        return null;
    }

    @Override
    public void setAttribute(String name, Object value) {

    }
}
