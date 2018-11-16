package com.timur.pet_project.controllers.user;

import com.timur.pet_project.model.Result;
import com.timur.pet_project.model.User;
import com.timur.pet_project.service.TestResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by timyr on 17.08.18.
 */
@WebServlet(
        name = "UserHome",
        urlPatterns = "/home"
)

public class UserHome extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(UserHome.class);

    private TestResultService service;

    @Override
    public void init() {
        service = new TestResultService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sortBy = (String) req.getAttribute("sort");
        User user = (User) req.getSession().getAttribute("loggedUser");

        ArrayList<Result> results = service.getSetOfResultsByUserId(user.getUserID());
        if (!results.isEmpty()) {
            if (sortBy == null || sortBy.isEmpty()) {
                service.sortTestResults(results, "name");
            } else {
                service.sortTestResults(results, sortBy);
            }
            for (Result result : results) {
                LOG.debug(result.getTest().getTopic());
            }
            req.setAttribute("resultList", results);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user/userHome.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("/user/tests");
        }
    }
}
