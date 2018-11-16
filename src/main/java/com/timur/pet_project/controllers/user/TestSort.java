package com.timur.pet_project.controllers.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by timyr on 19.08.18.
 */
@WebServlet(
        name = "TestsSortServlet",
        urlPatterns = "/home/sorting"
)
public class TestSort extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sortType = req.getParameter("sort");
        req.getSession().setAttribute("sortType", sortType);
        resp.sendRedirect("/user/userHome.jsp");
    }
}
