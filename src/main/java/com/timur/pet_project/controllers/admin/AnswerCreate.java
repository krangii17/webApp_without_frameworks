package com.timur.pet_project.controllers.admin;

import com.timur.pet_project.model.Answer;
import com.timur.pet_project.service.AnswerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by timyr on 26.08.18.
 */
@WebServlet(
        name = "AnswerCreate",
        urlPatterns = "/admin/tests/answer/create"
)
public class AnswerCreate extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(AnswerCreate.class);
    private AnswerService service;

    @Override
    public void init() {
        service = new AnswerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String testID = req.getParameter("testID");
        req.setAttribute("testID", testID);
        String questionID = req.getParameter("questionID");
        if ((testID == null) || (questionID == null)) {
            resp.sendRedirect("/admin/tests");
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/answerCreate.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int questionID = Integer.parseInt(req.getParameter("IDOfQuestion"));
        boolean right = Boolean.parseBoolean(req.getParameter("isRight"));
        System.out.println(right);
        String answer = req.getParameter("answer");
        String testID = req.getParameter("IDOfTest");
        Answer myAnswer = null;
        try {
            myAnswer = service.createAnswer(answer, right, questionID);
        } finally {
            if (myAnswer != null) {
                resp.sendRedirect("/admin/questions?testID=" + testID);
            } else {
                resp.sendRedirect("/error-pages/databaseError.jsp");
            }
        }

    }
}
