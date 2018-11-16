package com.timur.pet_project.service;

import com.timur.pet_project.dao.UserDao;
import com.timur.pet_project.model.Role;
import com.timur.pet_project.model.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by timyr on 20.08.18.
 */
public class AdminService {

    public List<User> getAllUsers() {
        UserDao userDao = new UserDao();
        return userDao.getList().stream().filter(user ->
                !user.getRole().equals(Role.ADMIN)).collect(Collectors.toList());

    }

    public void changeUserBanStatusById(int id) {
        UserDao userDao = new UserDao();
        User user = userDao.getById(id);
        if (user.isBan()) {
            userDao.bunOrUnbanUserByID(id, false);
        } else {
            userDao.bunOrUnbanUserByID(id, true);
        }
    }


}
