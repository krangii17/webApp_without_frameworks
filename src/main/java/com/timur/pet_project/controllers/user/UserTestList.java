package com.timur.pet_project.controllers.user;

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

@WebServlet(
        name = "UserTestList",
        urlPatterns = "/user/tests"
)
public class UserTestList extends HttpServlet {
    TestService service;

    @Override
    public void init() {
        service = new TestService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String sortBy = req.getParameter("sort");
        List<Test> testsList = service.getAllTests();
        if ((sortBy != null) && (!sortBy.isEmpty())) {
            service.sortTestResults(testsList, sortBy);
        }
        req.setAttribute("tests", testsList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user/listOfTests.jsp");
        dispatcher.forward(req, resp);
    }

}
