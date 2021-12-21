package com.epam.shop.controller.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Optional;

public class GreetingTag extends TagSupport {

    private static final String USER_WELCOME_MESSAGE = "Hello, %s";
    private static final String DEFAULT_WELCOME_MESSAGE = "Hello!";
    private static final String USER_NAME_SESSION_ATTRIB = "userLogin";

    @Override
    public int doStartTag() throws JspException {
        final String tagResultText = buildWelcomeMessage();
        printMessage(tagResultText);
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    private String buildWelcomeMessage() {
        return Optional.ofNullable(pageContext.getRequest())
                .map(req -> req.getParameter(USER_NAME_SESSION_ATTRIB))
                .map(name -> String.format(USER_WELCOME_MESSAGE, name))
                .orElse(DEFAULT_WELCOME_MESSAGE);
    }

    private void printMessage(String tagResultText) throws JspException {
        final JspWriter out = pageContext.getOut();
        try {
            out.write(tagResultText);
        } catch (IOException e) {
            throw new JspException(e);
        }
    }
}
