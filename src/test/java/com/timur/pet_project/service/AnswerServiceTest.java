package com.timur.pet_project.service;

import com.timur.pet_project.dao.AnswerDao;
import com.timur.pet_project.dao.QuestionsDao;
import com.timur.pet_project.dao.TestDao;
import com.timur.pet_project.dao.util.H2Connector;
import com.timur.pet_project.model.Answer;
import com.timur.pet_project.model.Question;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.exception.LockException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class AnswerServiceTest {
    private H2Connector h2Connector = new H2Connector();
    private QuestionsDao questionsDao;
    private QuestionService questionService;
    private AnswerService answerService;
    private AnswerDao answerDao;

    @Before
    public void init() throws LiquibaseException {
        h2Connector.buildDb();
        questionsDao = new QuestionsDao();
        questionService=new QuestionService();
        answerService=new AnswerService();
        answerDao=new AnswerDao();
    }

    @After
    public void drop() throws DatabaseException, LockException, SQLException {
        h2Connector.dropDb();
    }

    @Test
    public void createAnswerTest() {
        //GIVEN
        String expectedAnswer="this is";
        //WHEN
        TestDao testDao=new TestDao();
        testDao.create(new com.timur.pet_project.model.Test(2,"Java"
                ,5,"Java",15));
        questionsDao.create(new Question(2,"what is question",2));
        Answer testAnswer=answerService.createAnswer("this is",true,2);
        //THEN
        Assert.assertEquals(expectedAnswer,testAnswer.getAnswer());
    }

}