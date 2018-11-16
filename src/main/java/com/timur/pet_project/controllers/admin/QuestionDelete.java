package com.timur.pet_project.controllers.admin;

import com.timur.pet_project.service.QuestionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "QuestionDelete",
        urlPatterns = "/admin/question/delete"
)
public class QuestionDelete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int questionID = Integer.parseInt(req.getParameter("questionID"));
        int testID = Integer.parseInt(req.getParameter("testID"));
        QuestionService service = new QuestionService();
        service.deleteQuestion(questionID);
        resp.sendRedirect("/admin/questions?testID=" + testID);
    }
}
