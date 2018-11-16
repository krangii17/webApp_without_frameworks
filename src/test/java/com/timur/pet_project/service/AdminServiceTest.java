package com.timur.pet_project.service;

import com.timur.pet_project.dao.UserDao;
import com.timur.pet_project.dao.util.H2Connector;
import com.timur.pet_project.model.Role;
import com.timur.pet_project.model.User;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.exception.LockException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class AdminServiceTest {

    private H2Connector h2Connector = new H2Connector();
    private UserDao userDao;
    private AdminService service;

    @Before
    public void init() throws LiquibaseException {
        h2Connector.buildDb();
        userDao = new UserDao();
        service=new AdminService();
    }

    @After
    public void drop() throws DatabaseException, LockException, SQLException {
        h2Connector.dropDb();
    }

    @Test
    public void getAllUsersTest() {
        //WHEN
        userDao.create(new User(1,"John","john@gmail.com"
                ,"John Doe",false,30, Role.ADMIN));
        List<User> users=service.getAllUsers();
        //THEN
        assertNotNull(users);
    }
}