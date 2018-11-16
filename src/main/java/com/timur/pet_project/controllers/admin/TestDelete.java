package com.timur.pet_project.controllers.admin;

import com.timur.pet_project.service.TestService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "TestDelete",
        urlPatterns = "/admin/tests/delete"
)
public class TestDelete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int testID = Integer.parseInt(req.getParameter("testID"));
        TestService service = new TestService();
        service.deleteTest(testID);
        resp.sendRedirect("/admin/tests");
    }
}
