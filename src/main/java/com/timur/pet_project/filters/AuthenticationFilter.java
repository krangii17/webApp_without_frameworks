package com.timur.pet_project.filters;

import com.timur.pet_project.model.Role;
import com.timur.pet_project.model.User;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by timyr on 18.08.18.
 */
@WebFilter(
        urlPatterns = "/*",
        filterName = "AuthenticationFilter"
)
public class AuthenticationFilter implements Filter {
    List<String> accessPath;
    List<String> blockedPath;

    @Override
    public void init(FilterConfig filterConfig) {
        accessPath = Arrays.asList("userHome", "profile", "sorting", "tests");
        blockedPath = Arrays.asList("login", "registration", "");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws ServletException, IOException {
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();

        String pathWithParameters = StringUtils.substringAfterLast(uri, "/");
        String path = StringUtils.substringBefore(pathWithParameters, "?");

        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        User user = (User) session.getAttribute("loggedUser");

        if (blockedPath.contains(path) && user != null) {
            ((HttpServletResponse) servletResponse).sendRedirect("/user/userHome.jsp");
            return;
        }

        if (user != null) {
            if (user.getRole().equals(Role.ADMIN)) {
                if (uri.matches("(.*)userHome(.*)")) {
                    ((HttpServletResponse) servletResponse).sendRedirect("/admin");
                    return;
                }
            }
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (!accessPath.contains(path)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }


        ((HttpServletResponse) servletResponse).sendRedirect("/login.jsp");
    }

    @Override
    public void destroy() {
        accessPath = null;
        blockedPath = null;
    }
}
