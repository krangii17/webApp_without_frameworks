package com.timur.pet_project.dao;

import com.timur.pet_project.dao.util.H2Connector;
import com.timur.pet_project.model.Question;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.exception.LockException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class QuestionsDaoTest {

    private H2Connector h2Connector = new H2Connector();
    private QuestionsDao questionsDao;

    @Before
    public void init() throws LiquibaseException {
        h2Connector.buildDb();
        questionsDao = new QuestionsDao();
    }

    @After
    public void drop() throws DatabaseException, LockException, SQLException {
        h2Connector.dropDb();
    }

    @Test
    public void deleteAnswer() {
        //WHEN
        questionsDao.delete(1);
        List<Question> answers=questionsDao.getList();
        //THEN
        Assert.assertTrue(answers.isEmpty());
    }

    @Test
    public void updateTest() {
        //GIVEN
        String expectedQuestion="Java is very cool?";
        //WHEN
        Question answer=questionsDao.update(new Question(2,"Java is very cool?",2));
        //THEN
        Assert.assertNotNull(answer);
        Assert.assertEquals(expectedQuestion,answer.getQuestion());
    }

}