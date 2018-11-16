package com.timur.pet_project.encryptor;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordEncryptTest {

    @Test
    public void encodePassword() {
        //GIVEN
        String password="qwer1234aA";
        //WHEN
        String encodePass=PasswordEncrypt.encodePassword(password);
        //THEN
        assertEquals(password, PasswordEncrypt.decodePassword(encodePass));
    }
}