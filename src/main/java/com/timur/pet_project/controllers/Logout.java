package com.timur.pet_project.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by timyr on 17.08.18.
 */
@WebServlet(
        name = "Logout",
        urlPatterns = "/logout"
)
public class Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/login");
    }
}
