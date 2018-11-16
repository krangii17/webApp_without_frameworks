package com.timur.pet_project.service;

import com.timur.pet_project.dao.QuestionsDao;
import com.timur.pet_project.dao.TestDao;
import com.timur.pet_project.dao.util.H2Connector;
import com.timur.pet_project.model.Question;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.exception.LockException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionServiceTest {

    private H2Connector h2Connector = new H2Connector();
    private QuestionsDao questionsDao;
    private QuestionService service;

    @Before
    public void init() throws LiquibaseException {
        h2Connector.buildDb();
        questionsDao = new QuestionsDao();
        service=new QuestionService();
    }

    @After
    public void drop() throws DatabaseException, LockException, SQLException {
        h2Connector.dropDb();
    }

    @Test
    public void createQuestionTest(){
        //GIVEN
        int expectedSize=1;
        //WHEN
        TestDao testDao=new TestDao();
        testDao.create(new com.timur.pet_project.model.Test(2,"Java"
                ,5,"Java",15));
        service.createQuestion("what is question",2);
        List<Question> questions= questionsDao.getList();
        //THEN
        assertNotNull(questions);
        assertFalse(questions.isEmpty());
        assertEquals(expectedSize,questions.size());
    }

    @Test
    public void getAllQuestionsTest() {
        //GIVEN
        int expectedSize=1;
        //WHEN
        TestDao testDao=new TestDao();
        testDao.create(new com.timur.pet_project.model.Test(2,"Java"
                ,5,"Java",15));
        service.createQuestion("what is question",2);
        List<Question> questions= service.getAllQuestions();
        //THEN
        assertNotNull(questions);
        assertFalse(questions.isEmpty());
        assertEquals(expectedSize,questions.size());
    }

}