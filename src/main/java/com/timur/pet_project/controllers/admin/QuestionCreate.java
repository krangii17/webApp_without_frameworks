package com.timur.pet_project.controllers.admin;

import com.timur.pet_project.model.Question;
import com.timur.pet_project.service.QuestionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by timyr on 30.08.18.
 */
@WebServlet(
        name = "QuestionCreate",
        urlPatterns = "/admin/tests/question/create"
)
public class QuestionCreate extends HttpServlet {
    private QuestionService service;

    @Override
    public void init() {
        service = new QuestionService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/questionCreate.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int testID = Integer.parseInt(req.getParameter("testID"));
        String question = req.getParameter("question");
        Question retQuestion = null;
        try {
            retQuestion = service.createQuestion(question, testID);
        } finally {
            if (retQuestion != null) {
                resp.sendRedirect("/admin/questions?testID=" + testID);
            } else {
                resp.sendRedirect("/error-pages/databaseError.jsp");
            }
        }
    }
}
