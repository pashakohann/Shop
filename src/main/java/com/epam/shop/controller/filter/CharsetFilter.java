package com.epam.shop.controller.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class CharsetFilter implements Filter {
    private static final String ENCODING = "UTF-8";
    private static final String INIT_PARAMETER = "requestEncoding";
    private static final String CONTENT_TYPE_PARAMETER = "text/html; charset=UTF-8";

    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter(INIT_PARAMETER);
        if (encoding == null) encoding = ENCODING;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (null == request.getCharacterEncoding()) {
            request.setCharacterEncoding(encoding);
        }

        response.setContentType(CONTENT_TYPE_PARAMETER);
        response.setCharacterEncoding(ENCODING);

        chain.doFilter(request, response);
    }


}
