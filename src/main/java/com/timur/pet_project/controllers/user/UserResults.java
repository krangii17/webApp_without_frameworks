package com.timur.pet_project.controllers.user;


import com.timur.pet_project.model.User;
import com.timur.pet_project.service.ResultService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;


@WebServlet(
        name = "UserResults",
        urlPatterns = "/home/testing/result"
)
public class UserResults extends HttpServlet {

    private ResultService service;

    @Override
    public void init() {
        service = new ResultService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user/userResult.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Integer> correctAnswers = (List<Integer>) req.getSession().getAttribute("correctAnswers");
        Enumeration answers = req.getParameterNames();
        int answerSize = 0, correctVal = 0;
        while (answers.hasMoreElements()) {
            String param = (String) answers.nextElement();
            Integer var = Integer.valueOf(param);
            answerSize++;
            for (Integer correctAnswer : correctAnswers) {
                if (var.equals(correctAnswer)) {
                    correctVal++;
                }
            }
        }
        double percentage;
        if (correctAnswers != null) {
            percentage = service.getPercentage(answerSize, correctAnswers.size(), correctVal);
        } else {
            resp.sendRedirect("/error-pages/databaseError.jsp");
            return;
        }
        req.setAttribute("percentage", percentage);
        User user = (User) req.getSession().getAttribute("loggedUser");
        Integer testID = (Integer) (req.getSession().getAttribute("testID"));
        service.setResult(user.getUserID(), testID, percentage, correctVal);
        doGet(req, resp);
    }
}
