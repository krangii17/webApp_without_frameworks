package com.timur.pet_project.controllers;

import com.timur.pet_project.model.User;
import com.timur.pet_project.service.UserService;
import com.timur.pet_project.validator.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by timyr on 13.08.18.
 */
@WebServlet(
        name = "Login",
        urlPatterns = "/login"
)
public class Login extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(Login.class);
    private UserService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        service = new UserService();
        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        Validator validator = new Validator();
        if (!validator.emailValidate(email)) {
            LOG.warn("Invalid email at login");
            req.setAttribute("error", "invalid_email");
            doGet(req, resp);
            return;
        }
        if (!validator.passwordValidate(password)) {
            LOG.warn("Invalid password at login");
            req.setAttribute("error", "invalid_password");
            doGet(req, resp);
            return;
        }
        try {
            User user = service.signUserAccount(email, password);
            if (user == null) {
                req.setAttribute("error", "invalid_password");
                doGet(req, resp);
                return;
            }
            if (user.isBan()) {
                req.setAttribute("error", "user_is_banned");
                doGet(req, resp);
                return;
            }
            session.setAttribute("loggedUser", user);
            session.setMaxInactiveInterval(24 * 60 * 60);
            resp.sendRedirect("/user/userHome.jsp");

        } catch (IllegalAccessException e) {
            req.setAttribute("error", "found_no_user_by_login");
            doGet(req, resp);
        }
    }
}
