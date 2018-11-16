package com.timur.pet_project.controllers.user;

import com.timur.pet_project.model.Answer;
import com.timur.pet_project.model.Question;
import com.timur.pet_project.service.QuestionService;
import com.timur.pet_project.service.TestService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "StartToTesting",
        urlPatterns = "/home/tests/testing"
)

public class StartTesting extends HttpServlet {

    QuestionService service;
    TestService getTest;

    @Override
    public void init() {
        service = new QuestionService();
        getTest = new TestService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user/testing.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int testID = Integer.parseInt(req.getParameter("testID"));
        List<Question> questions = service.getQuestionsByTestID(testID);
        if ((questions != null) && (!questions.isEmpty())) {
            questions.forEach(question ->
                    service.addAnswersToQuestion(question));
            List<Integer> correctAnswersList = new ArrayList<>();
            for (Question que : questions) {
                if (que.getAnswerList() != null) {
                    for (Answer answer : que.getAnswerList()) {
                        if (answer != null && answer.isCorrect()) {
                            correctAnswersList.add(answer.getAnswerID());
                        }
                    }
                } else {
                    resp.sendRedirect("/error-pages/databaseError.jsp");
                    return;
                }
            }
            req.setAttribute("test", getTest.getTestById(testID));
            req.setAttribute("questions", questions);
            req.getSession().setAttribute("testID", testID);
            req.getSession().setAttribute("correctAnswers", correctAnswersList);
        }

        doGet(req, resp);
        return;
    }

}
