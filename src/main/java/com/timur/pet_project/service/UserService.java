package com.timur.pet_project.service;

import com.timur.pet_project.dao.UserDao;
import com.timur.pet_project.encryptor.PasswordEncrypt;
import com.timur.pet_project.model.Role;
import com.timur.pet_project.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by timyr on 16.08.18.
 */
public class UserService {

    private final Logger Log = LoggerFactory.getLogger(UserService.class);

    public User createUserAccount(String login, String email, String username, String password, String age) {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        user.setUserName(username);
        user.setAge(Integer.parseInt(age));
        String encodedPass = PasswordEncrypt.encodePassword(password);
        user.setPassword(encodedPass.toCharArray());
        user.setRole(Role.USER);
        userDao.create(user);
        return user;
    }

    public User signUserAccount(String email, String pass) throws IllegalAccessException {
        UserDao dao = new UserDao();

        User getEntityUser = dao.getEntityByEmail(email);
        String myPassword = String.valueOf(getEntityUser.getPassword());
        String passwordFrom = String.valueOf(PasswordEncrypt.decodePassword(myPassword));
        if (pass.equals(passwordFrom)) {
            return getEntityUser;
        } else throw new IllegalAccessException("Incorrect password");

    }

    public boolean checkUserBanStatus(User user) {
        return user.isBan();
    }

    public boolean makeAdmin(String email) {
        UserDao userDao = new UserDao();
        if (email == null || email.isEmpty()) return false;
        User user = userDao.getEntityByEmail(email);

        if (!(user == null) && user.getEmail().equals(email)) {
            user.setRole(Role.ADMIN);
            userDao.update(user);
            return true;
        } else {
            return false;
        }
    }
}
