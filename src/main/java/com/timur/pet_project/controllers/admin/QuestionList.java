package com.timur.pet_project.controllers.admin;

import com.timur.pet_project.model.Question;
import com.timur.pet_project.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by timyr on 26.08.18.
 */
@WebServlet(
        name = "QuestionList",
        urlPatterns = "/admin/questions"
)
public class QuestionList extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(QuestionList.class);
    private QuestionService service;

    @Override
    public void init() {
        service = new QuestionService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int testID = Integer.parseInt(req.getParameter("testID"));
        List<Question> questionList = service.getQuestionsByTestID(testID);
        req.setAttribute("questions", questionList);
        req.setAttribute("testID", testID);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/questionList.jsp");
        dispatcher.forward(req, resp);
    }


}
