package com.timur.pet_project.validator;

import com.timur.pet_project.model.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

public class TestCreateValidatorTest {
    private TestCreateValidator validator;
    private Test test;

    @Before
    public void setUp(){
        validator=new TestCreateValidator();
        test=new Test();
    }

    @After
    public void tearDown(){
        validator=null;
        test=null;
    }

    @org.junit.Test
    public void validNameValidateTest(){
        //WHEN
        test.setTestName("Test");
        //THEN
        assertTrue(validator.testNameValidate(test.getTestName()));
    }

    @org.junit.Test
    public void invalidNameValidateTest() {
        //WHEN
        test.setTestName("Test'';859589");
        //THEN
        assertFalse(validator.testNameValidate(test.getTestName()));
    }

    @org.junit.Test
    public void validTopicValidateTest(){
        //WHEN
        test.setTopic("Java");
        //THEN
        assertTrue(validator.topicValidate(test.getTopic()));
    }

    @org.junit.Test
    public void invalidTopicValidateTest(){
        //WHEN
        test.setTopic("Java;'");
        //THEN
        assertFalse(validator.topicValidate(test.getTopic()));
    }

    @org.junit.Test
    public void validLevelValidateTest(){
        //WHEN
        test.setLevel(3);
        //THEN
        assertTrue(validator.levelValidator(test.getLevel()));
    }

    @org.junit.Test
    public void invalidLevelValidateTest(){
        //WHEN
        test.setLevel(80);
        //THEN
        assertFalse(validator.levelValidator(test.getLevel()));
    }

    @org.junit.Test
    public void validTimeValidateTest(){
        //WHEN
        test.setTestTime(15);
        //THEN
        assertTrue(validator.timeValidate(test.getTestTime()));
    }

    @org.junit.Test
    public void invalidTimeValidateTest(){
        //WHEN
        test.setTestTime(1000);
        //THEN
        assertFalse(validator.timeValidate(test.getTestTime()));
    }

}