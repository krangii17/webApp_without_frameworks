package com.timur.pet_project.controllers.admin;

import com.timur.pet_project.model.Test;
import com.timur.pet_project.service.TestService;

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
        name = "TestList",
        urlPatterns = "/admin/tests"
)
public class TestList extends HttpServlet {

    private TestService testService;

    @Override
    public void init() {
        testService = new TestService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Test> testList = testService.getAllTests();
        req.setAttribute("tests", testList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/testList.jsp");
        dispatcher.forward(req, resp);
    }
}
