package com.timur.pet_project.controllers.admin;

import com.timur.pet_project.model.Answer;
import com.timur.pet_project.service.AnswerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "AnswerList",
        urlPatterns = "/admin/answer/list"
)
public class AnswerList extends HttpServlet {

    AnswerService service;

    @Override
    public void init(ServletConfig config)
            throws ServletException {
        super.init(config);
        service = new AnswerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/answerList.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer questionID = Integer.valueOf(req.getParameter("questionID"));
        Integer testID = Integer.valueOf(req.getParameter("testID"));
        List<Answer> answers = service.getAnswersByQuestionID(questionID);
        req.setAttribute("answerList", answers);
        req.setAttribute("testID", testID);
        doGet(req, resp);
        return;
    }
}
