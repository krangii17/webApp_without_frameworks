package com.timur.pet_project.validator;

import com.timur.pet_project.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

/**
 * Created by timyr on 16.08.18.
 */
public class Validator {
    static final Logger LOG = LoggerFactory.getLogger(Validator.class);

    public boolean emailValidate(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        } else {
            Pattern pattern = Pattern.compile(ValidatorEnum
                    .EMAIL_VALIDATOR
                    .getStatment());
            return pattern.matcher(email).matches();
        }
    }

    public boolean loginValidate(String login) {
        if (login == null || login.isEmpty()) {
            return false;
        } else {
            Pattern pattern = Pattern.compile(ValidatorEnum
                    .LOGIN_VALIDATOR
                    .getStatment());
            return pattern.matcher(login).matches();
        }
    }

    public boolean nameValidate(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        } else {
            Pattern pattern = Pattern.compile(ValidatorEnum
                    .NAME_VALIDATOR
                    .getStatment());
            return pattern.matcher(name).matches();
        }
    }

    public boolean passwordValidate(String pass) {
        if (pass == null || pass.isEmpty()) {
            return false;
        } else {
            Pattern pattern = Pattern.compile(ValidatorEnum
                    .PASSWORD_VALIDATOR
                    .getStatment());
            return pattern.matcher(pass).matches();
        }
    }

    public boolean ageValidate(String age) {
        if (age == null || age.isEmpty()) {
            return false;
        } else {
            int intAge = Integer.parseInt(age);
            if (intAge <= 5 || intAge >= 95) {
                return false;
            } else {
                return true;
            }
        }
    }

    public boolean isUserRegistred(String email) {
        UserDao userDao = new UserDao();
        LOG.debug(userDao.getEntityByEmail(email).getEmail());
        return userDao.getEntityByEmail(email).getEmail() == null;
    }
}
