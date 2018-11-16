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
 * Created by timyr on 16.08.18.
 */
@WebServlet(
        name = "Registration",
        urlPatterns = "/registration"
)
public class Registration extends HttpServlet {

    static final Logger LOG = LoggerFactory.getLogger(Registration.class);
    UserService service;

    @Override
    public void init() {
        service = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = req.getParameter("user_login");
        String email = req.getParameter("email");
        String userName = req.getParameter("user_name");
        String password = req.getParameter("pass");
        String age = req.getParameter("age");
        System.out.println(login + " " + email + " " + userName + " " + password + " " + age);
        Validator validator = new Validator();
        if (!validator.loginValidate(login)) {
            LOG.warn("Invalid login");
            req.setAttribute("error_login", "invalid_login");
            doGet(req, resp);
            return;
        }
        if (!validator.emailValidate(email)) {
            LOG.warn("Invalid email");
            req.setAttribute("error_email", "invalid_email");
            doGet(req, resp);
            return;
        }
        if (!validator.nameValidate(userName)) {
            LOG.warn("Invalid user name");
            req.setAttribute("error_name", "invalid_name");
            doGet(req, resp);
            return;
        }
        if (!validator.passwordValidate(password)) {
            LOG.warn("Invalid user name");
            req.setAttribute("error_password", "invalid_password");
            doGet(req, resp);
            return;
        }
        if (!validator.ageValidate(age)) {
            LOG.warn("Invalid user name");
            req.setAttribute("error_age", "invalid_age");
            doGet(req, resp);
            return;
        }
        if (!validator.isUserRegistred(email)) {
            LOG.warn("Invalid email");
            req.setAttribute("error_email", "email_exist");
            doGet(req, resp);
            return;
        }
        User user = service.createUserAccount(login, email, userName, password, age);
        session.setAttribute("loggedUser", user);
        session.setMaxInactiveInterval(24 * 60 * 60);
        resp.sendRedirect("/user/userHome.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registration.jsp");
        dispatcher.forward(req, resp);
    }
}
