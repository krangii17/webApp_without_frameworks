package com.timur.pet_project.controllers.admin;

import com.timur.pet_project.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by timyr on 20.08.18.
 */
@WebServlet(
        name = "UserBan",
        urlPatterns = "/admin/ban"
)
public class BanUsers extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(BanUsers.class);
    AdminService adminService;

    @Override
    public void init() {
        adminService = new AdminService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int userID = Integer.parseInt(req.getParameter("userID"));
        LOG.debug(String.valueOf(userID));
        adminService.changeUserBanStatusById(userID);
        resp.sendRedirect("/admin");
    }
}
