package com.timur.pet_project.controllers.admin;

import com.timur.pet_project.service.TestService;
import com.timur.pet_project.validator.TestCreateValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "TestUpdate",
        urlPatterns = "/admin/tests/update"
)
public class TestUpdate extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(TestUpdate.class);
    TestCreateValidator validator;
    private TestService testService;

    @Override
    public void init() {
        testService = new TestService();
        validator = new TestCreateValidator();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer testID = Integer.valueOf(req.getParameter("testID"));
        req.setAttribute("testID", testID);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/testUpdate.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        Integer id = Integer.parseInt(req.getParameter("testID"));
        String name = req.getParameter("name");
        int level = Integer.parseInt(req.getParameter("level"));
        String topic = req.getParameter("topic");
        int time = Integer.parseInt(req.getParameter("time"));
        if (!validator.testNameValidate(name)) {
            LOG.warn("Invalid test name");
            req.setAttribute("error", "invalid_test_name");
            doGet(req, resp);
        }
        if (!validator.levelValidator(level)) {
            LOG.warn("Invalid test level of test");
            req.setAttribute("error", "invalid_test_level");
            doGet(req, resp);
            return;
        }
        if (!validator.topicValidate(topic)) {
            LOG.warn("Invalid topic of test");
            req.setAttribute("error", "invalid_test_topic");
            doGet(req, resp);
            return;
        }
        if (!validator.timeValidate(time)) {
            LOG.warn("Invalid time of test");
            req.setAttribute("error", "invalid_test_time");
            doGet(req, resp);
            return;
        }
        testService.updateTest(id, name, level, topic, time);
        resp.sendRedirect("/admin/tests");
        return;
    }
}
