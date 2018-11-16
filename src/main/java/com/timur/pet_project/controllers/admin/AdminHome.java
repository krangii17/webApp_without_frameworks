package com.timur.pet_project.controllers.admin;


import com.timur.pet_project.model.User;
import com.timur.pet_project.service.AdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by timyr on 20.08.18.
 */
@WebServlet(
        name = "AdminHome",
        urlPatterns = "/admin"
)
public class AdminHome extends HttpServlet {

    private AdminService adminService;

    @Override
    public void init() {
        adminService = new AdminService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<User> allUsers = adminService.getAllUsers();
        req.setAttribute("users", allUsers);
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/admin/adminHome.jsp");
        dispatcher.forward(req, resp);
    }

}
