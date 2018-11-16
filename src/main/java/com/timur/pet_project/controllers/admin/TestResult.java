package com.timur.pet_project.controllers.admin;

import com.timur.pet_project.model.Result;
import com.timur.pet_project.service.ResultService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by timyr on 25.08.18.
 */
@WebServlet(
        name = "TestResult",
        urlPatterns = "/admin/result"
)
public class TestResult extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ResultService service = new ResultService();
        List<Result> results;
        results = service.getResults();
        req.setAttribute("results", results);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/testResult.jsp");
        dispatcher.forward(req, resp);
    }

}
