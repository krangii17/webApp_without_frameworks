package com.timur.pet_project.service;

import com.timur.pet_project.dao.ResultDao;
import com.timur.pet_project.dao.util.H2Connector;
import com.timur.pet_project.model.Result;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.exception.LockException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class TestResultServiceTest {

    private H2Connector h2Connector = new H2Connector();
    private ResultDao resultDao;
    private ResultService service;

    @Before
    public void init() throws LiquibaseException {
        h2Connector.buildDb();
        resultDao = new ResultDao();
        service=new ResultService();
    }

    @After
    public void drop() throws DatabaseException, LockException, SQLException {
        h2Connector.dropDb();
    }

    @Test
    public void getTestResult() {
        //WHEN
        resultDao.update(new Result(2,4,2,true,5));
        List<Result> result=service.getResults();
        //THEN
        assertNotNull(result);
    }

    @Test
    public void getPersentageTest(){
        //GIVEN
        double expectedPersange=100.0;
        //WHEN
        double percentage=service.getPercentage(4,4,4);
        //THEN
        assertEquals(expectedPersange,percentage,0.001);
    }


}