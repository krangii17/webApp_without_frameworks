package com.timur.pet_project.validator;

import com.timur.pet_project.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {
    private Validator validator;
    private User user;

    @Before
    public void setUp(){
        validator=new Validator();
        user=new User();
    }

    @After
    public void tearDown(){
        validator=null;
        user=null;
    }

    @Test
    public void validNameValidateTest(){
        //WHEN
        user.setUserName("user");
        //THEN
        assertTrue(validator.nameValidate(user.getUserName()));
    }

    @Test
    public void invalidNameValidateTest() {
        //WHEN
        user.setUserName("name';859589");
        //THEN
        assertFalse(validator.nameValidate(user.getUserName()));
    }

    @Test
    public void validEmailValidateTest(){
        //WHEN
         user.setEmail("temp@gmail.com");
        //THEN
        assertTrue(validator.emailValidate(user.getEmail()));
    }

    @Test
    public void invalidEmailValidateTest(){
        //WHEN
        user.setEmail("mail.com");
        //THEN
        assertFalse(validator.emailValidate(user.getEmail()));
    }


    @Test
    public void validAgeValidateTest(){
        //WHEN
        user.setAge(19);
        //THEN
        assertTrue(validator.ageValidate(String.valueOf(user.getAge())));
    }

    @Test
    public void invalidAgeValidateTest(){
        //WHEN
        user.setAge(190);
        //THEN
        assertFalse(validator.ageValidate(String.valueOf(user.getAge())));
    }

    @Test
    public void validPasswordValidateTest(){
        //WHEN
        String password="qwerty1234aA";
        user.setPassword(password.toCharArray());
        //THEN
        assertTrue(validator.passwordValidate(String.valueOf(user.getPassword())));
    }

    @Test
    public void invalidPasswordValidateTest(){
        //WHEN
        String password="qwerty";
        user.setPassword(password.toCharArray());
        //THEN
        assertFalse(validator.passwordValidate(String.valueOf(user.getPassword())));
    }

}