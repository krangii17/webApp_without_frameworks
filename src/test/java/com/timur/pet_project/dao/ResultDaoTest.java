package com.timur.pet_project.dao;

import com.timur.pet_project.dao.util.H2Connector;
import com.timur.pet_project.model.Result;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.exception.LockException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ResultDaoTest {

    private H2Connector h2Connector = new H2Connector();
    private ResultDao resultDao;

    @Before
    public void init() throws  LiquibaseException {
        h2Connector.buildDb();
        resultDao = new ResultDao();
    }

    @After
    public void drop() throws DatabaseException, LockException, SQLException {
        h2Connector.dropDb();
    }

    @Test
    public void deleteAnswer(){
        //WHEN
        resultDao.delete(1);
        List<Result> results=resultDao.getList();
        //THEN
        Assert.assertTrue(results.isEmpty());
    }

    @Test
    public void updateTest() {
        //GIVEN
        int expectedUserID=4;
        //WHEN
        Result result=resultDao.update(new Result(2,4,2,true,5));
        //THEN
        Assert.assertNotNull(result);
        Assert.assertEquals(expectedUserID,result.getUserID());
    }

}