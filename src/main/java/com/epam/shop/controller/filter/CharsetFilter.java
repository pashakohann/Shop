package com.epam.shop.controller.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class CharsetFilter implements Filter {

    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("requestEncoding");
        if (encoding == null) encoding = "UTF-8";
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (null == request.getCharacterEncoding()) {
            request.setCharacterEncoding(encoding);
        }


        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}
