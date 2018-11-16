package com.timur.pet_project.service;

import com.timur.pet_project.dao.UserDao;
import com.timur.pet_project.dao.util.H2Connector;
import com.timur.pet_project.encryptor.PasswordEncrypt;
import com.timur.pet_project.model.Role;
import com.timur.pet_project.model.User;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.exception.LockException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserServiceTest {

    private H2Connector h2Connector = new H2Connector();
    private UserDao userDao;
    private UserService service;

    @Before
    public void init() throws LiquibaseException {
        h2Connector.buildDb();
        userDao = new UserDao();
        service=new UserService();
    }

    @After
    public void drop() throws DatabaseException, LockException, SQLException {
        h2Connector.dropDb();
    }

    @Test
    public void createUserAccountTest(){
        //GIVEN
        String expectedLogin="John";
        //WHEN
        User testUser=service.createUserAccount("John","john@gmail.com"
                ,"John Doe","1234567aA",String.valueOf(30));
        //THEN
        assertEquals(expectedLogin,testUser.getLogin());
    }

    @Test
    public void signUserAccountTest() throws IllegalAccessException {
        //GIVEN
        char[] myPass="1234567aA".toCharArray();
        String encodedPass=PasswordEncrypt.encodePassword(String.valueOf(myPass));
        //WHEN
        userDao.create(new User(3,"John","john3@gmail.com"
                ,encodedPass.toCharArray(),"JohnDoe",false,30, Role.USER));
        User myUser=userDao.getEntityByEmail("john3@gmail.com");
        User tempUser=service.signUserAccount("john3@gmail.com",
                String.valueOf(myPass));
        //THEN
        assertEquals(tempUser.getEmail(),myUser.getEmail());
    }
}