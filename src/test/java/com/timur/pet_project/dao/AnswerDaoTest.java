package com.timur.pet_project.dao;

import com.timur.pet_project.dao.util.H2Connector;
import com.timur.pet_project.model.Answer;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.exception.LockException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class AnswerDaoTest {
    private H2Connector h2Connector = new H2Connector();
    private AnswerDao answerDao;

    @Before
    public void init() throws LiquibaseException {
        h2Connector.buildDb();
        answerDao = new AnswerDao();
    }

    @After
    public void drop() throws DatabaseException, LockException, SQLException {
        h2Connector.dropDb();
    }

    @Test
    public void deleteAnswer() {
        //WHEN
        answerDao.delete(1);
        List<Answer> answers=answerDao.getList();
        //THEN
        Assert.assertTrue(answers.isEmpty());
    }


    @Test
    public void updateTest()  {
        //GIVEN
        String expectedAnswer="Java is very cool";
        //WHEN
        Answer answer=answerDao.update(new Answer(2,"Java is very cool",true,2));
        //THEN
        Assert.assertNotNull(answer);
        Assert.assertEquals(expectedAnswer,answer.getAnswer());
    }

}