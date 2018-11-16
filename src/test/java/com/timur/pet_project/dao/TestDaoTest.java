package com.timur.pet_project.dao;

import com.timur.pet_project.dao.util.H2Connector;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.exception.LockException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class TestDaoTest {

    private H2Connector h2Connector = new H2Connector();
    private TestDao testDao;

    @Before
    public void init() throws LiquibaseException {
        h2Connector.buildDb();
        testDao = new TestDao();
    }

    @After
    public void drop() throws DatabaseException, LockException, SQLException {
        h2Connector.dropDb();
    }

    @Test
    public void getByID() {
        //GIVEN
        String expectedTopic="Java";
        //WHEN
        testDao.create(new com.timur.pet_project.model.Test(2,"Java"
                ,5,"Java",15));
        com.timur.pet_project.model.Test testTest=testDao.getById(2);
        //THEN
        Assert.assertEquals(expectedTopic,testTest.getTopic());
    }

    @Test
    public void deleteAnswer() {
        //WHEN
        testDao.delete(1);
        List<com.timur.pet_project.model.Test> tests=testDao.getList();
        //THEN
        Assert.assertTrue(tests.isEmpty());
    }


    @Test
    public void updateTest() {
        //GIVEN
        String expectedAnswer="Java";
        //WHEN
        com.timur.pet_project.model.Test testTest=testDao.update(new com.timur.pet_project.model.Test(2,"Java"
                ,5,"Java",15));
        //THEN
        Assert.assertNotNull(testTest);
        Assert.assertEquals(expectedAnswer,testTest.getTopic());
    }

    @Test
    public void createTest() {
        //WHEN
        testDao.create(new com.timur.pet_project.model.Test(2,"Java"
                ,5,"Java",15));
        //THEN
        assertEquals("Java",testDao.getById(2).getTopic());
    }
}