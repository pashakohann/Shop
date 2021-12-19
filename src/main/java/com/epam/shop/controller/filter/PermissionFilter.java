package com.epam.shop.controller.filter;

import com.epam.shop.controller.command.Commands;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.dto.model.UserRoleDto;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

import static com.epam.shop.service.dto.model.UserRoleDto.UNAUTHORIZED;


@WebFilter(urlPatterns = "/*")
public class PermissionFilter implements Filter {

    private static final String ERROR_PAGE_LOCATION = "/shop?command=show_error_command";
    private static final String USER_ROLE_SESSION_ATTRIB_NAME = "currentUser";

    private final Map<UserRoleDto, Set<Commands>> commandsByRoles;
    private final String COMMAND_PARAM_NAME = "command";

    public PermissionFilter() {
        commandsByRoles = new EnumMap<>(UserRoleDto.class);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        for (Commands command : Commands.values()) {
            for (UserRoleDto allowedRole : command.getAllowedRoles()) {
                Set<Commands> commands = commandsByRoles.computeIfAbsent(allowedRole, k -> EnumSet.noneOf(Commands.class));
                commands.add(command);
            }
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final Commands command = Commands.of(req.getParameter(COMMAND_PARAM_NAME));
        final HttpSession session = req.getSession(false);
        UserRoleDto currentRole = extractRoleFromSession(session);
        final Set<Commands> allowedCommands = commandsByRoles.get(currentRole);
        if (allowedCommands.contains(command)) {
            chain.doFilter(request, response);
        } else {

            ((HttpServletResponse) response).sendRedirect(ERROR_PAGE_LOCATION);
        }
    }

    private UserRoleDto extractRoleFromSession(HttpSession session) {
        return session != null && session.getAttribute(USER_ROLE_SESSION_ATTRIB_NAME) != null
                ? ((UserDto) session.getAttribute(USER_ROLE_SESSION_ATTRIB_NAME)).getRole()
                : UNAUTHORIZED;
    }
}
