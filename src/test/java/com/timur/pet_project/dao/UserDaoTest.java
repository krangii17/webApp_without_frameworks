package com.timur.pet_project.dao;

import com.timur.pet_project.dao.util.H2Connector;
import com.timur.pet_project.model.Role;
import com.timur.pet_project.model.User;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.exception.LockException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class UserDaoTest {

    private H2Connector h2Connector = new H2Connector();
    private UserDao userDao;

    @Before
    public void init() throws LiquibaseException {
        h2Connector.buildDb();
        userDao = new UserDao();
    }

    @After
    public void drop() throws DatabaseException, LockException, SQLException {
        h2Connector.dropDb();
    }


    @Test
    public void getByIDTest(){
        //GIVEN
        String expectedLogin = "John";
        //WHEN
        userDao.create(new User(1,"John","john@gmail.com"
                ,"John Doe",false,30, Role.USER));
        User user2 = userDao.getById(1);
        //THEN
        Assert.assertNotNull(user2);
        Assert.assertEquals(expectedLogin, userDao.getById(1).getLogin());
    }


    @Test
    public void deleteTest() {
        //WHEN
        userDao.delete(1);
        List<User>user=userDao.getList();
        //THEN
        Assert.assertTrue(user.isEmpty());
    }

    @Test
    public void getListTest() {
        //WHEN
        userDao.create(new User(2,"John2","john2@gmail.com"
                ,"John Doe",false,30, Role.USER));

        userDao.create(new User(3,"John3","john3@gmail.com"
                ,"John Doe",false,30, Role.USER));
        List<User>user=userDao.getList();
        //THEN
        Assert.assertNotNull(user);
        Assert.assertFalse(user.isEmpty());
    }

    @Test
    public void updateTest() {
        //GIVEN
        String expectedLogin="temp";
        //WHEN
        User user2=userDao.update(new User(1,"temp","john2@gmail.com"
                ,"John Doe",false,30, Role.USER));
        //THEN
        Assert.assertEquals(expectedLogin,user2.getLogin());
    }

    @Test
    public void getEnityByEmailTest() {
        //GIVEN
        String expectedLogin="temp";
        //WHEN
        userDao.create(new User(1,"temp","john@gmail.com","John Doe",false,30, Role.USER));
        User testUser=userDao.getEntityByEmail("john@gmail.com");
        //THEN
        Assert.assertNotNull(testUser);
        Assert.assertEquals(expectedLogin,testUser.getLogin());

    }

    @Test
    public void voidBanUserTest(){
        //GIVEN
        boolean expectedBan=true;
        //WHEN
        userDao.create(new User(1,"temp","john@gmail.com","John Doe",false,30, Role.USER));
        userDao.bunOrUnbanUserByID(1,true);
        User testUser=userDao.getEntityByEmail("john@gmail.com");
        //THEN
        Assert.assertNotNull(testUser);
        Assert.assertEquals(expectedBan,testUser.isBan());
    }

}