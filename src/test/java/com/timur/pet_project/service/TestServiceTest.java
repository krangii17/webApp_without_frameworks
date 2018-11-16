package com.timur.pet_project.service;

import com.timur.pet_project.dao.TestDao;
import com.timur.pet_project.dao.util.H2Connector;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.exception.LockException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class TestServiceTest {

    private H2Connector h2Connector = new H2Connector();
    private TestDao testDao;
    private TestService service;

    @Before
    public void init() throws LiquibaseException {
        h2Connector.buildDb();
        testDao = new TestDao();
        service=new TestService();
    }

    @After
    public void drop() throws DatabaseException, LockException, SQLException {
        h2Connector.dropDb();
    }

    @Test
    public void getAllTests() {
        //GIVEN
        int expectedSize=1;
        //WHEN
        testDao.create(new com.timur.pet_project.model.Test(2,"Java"
                ,5,"Java",15));
        List<com.timur.pet_project.model.Test> tests=service.getAllTests();
        //THEN
        assertNotNull(tests);
        assertEquals(expectedSize,tests.size());
    }

    @Test
    public void getTestByIdTest() {
        //GIVEN
        String topic="Java";
        //WHEN
        testDao.create(new com.timur.pet_project.model.Test(2,"Java"
                ,5,"Java",15));
        com.timur.pet_project.model.Test test=service.getTestById(2);
        //THEN
        assertEquals(topic,test.getTopic());
    }

    @Test
    public void deleteTestByID()  {
        //WHEN
        testDao.create(new com.timur.pet_project.model.Test(2,"Java"
                ,5,"Java",15));
        service.deleteTest(2);
        List<com.timur.pet_project.model.Test> tests=testDao.getList();
        //THEN
        assertTrue(tests.isEmpty());
    }

}