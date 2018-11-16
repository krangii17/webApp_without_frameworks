package com.timur.pet_project.filters;

import com.timur.pet_project.model.Role;
import com.timur.pet_project.model.User;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by timyr on 19.08.18.
 */
public class AdminFilter implements Filter {
    private List<String> adminAccessPath;

    @Override
    public void init(FilterConfig filterConfig) {
        adminAccessPath = Arrays.asList("admin", "tests");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();
        String pathWithParameters = StringUtils.substringAfterLast(uri, "/");
        String path = StringUtils.substringBefore(pathWithParameters, "?");

        if (!adminAccessPath.contains(path)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        User user = (User) session.getAttribute("loggedUser");

        if (user != null && user.getRole().equals(Role.ADMIN)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        ((HttpServletResponse) servletResponse).sendRedirect("/login.jsp");
    }

    @Override
    public void destroy() {
        adminAccessPath = null;
    }
}
