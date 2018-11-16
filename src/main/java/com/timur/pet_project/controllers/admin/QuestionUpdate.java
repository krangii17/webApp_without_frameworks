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

@WebServlet(
        name = "QuestionUpdate",
        urlPatterns = "/admin/question/update"
)
public class QuestionUpdate extends HttpServlet {

    private QuestionService service;

    @Override
    public void init() {
        service = new QuestionService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer questionID = Integer.valueOf(req.getParameter("questionID"));
        req.setAttribute("questionID", questionID);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/questionUpdate.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        Integer questionID = Integer.valueOf(req.getParameter("questionID"));
        int testID = Integer.parseInt(req.getParameter("testID"));
        String question = req.getParameter("question");
        Question retQuestion = null;
        try {
            retQuestion = service.updateQuestion(questionID, question, testID);
        } finally {
            if (retQuestion != null) {
                resp.sendRedirect("/admin/questions?testID=" + testID);
            } else {
                resp.sendRedirect("/error-pages/databaseError.jsp");
            }
        }
    }
}
