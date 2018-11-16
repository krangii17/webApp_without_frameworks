package com.timur.pet_project.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by timyr on 12.08.18.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 8996733576214634756L;

    private int UserID;
    private String login;
    private String email;
    private char[] password = new char[60];
    private String userName;
    private boolean ban = false;
    private int age = 0;
    private Role role;

    public User(int userID, String login, String email, String userName, boolean ban, int age, Role role) {
        UserID = userID;
        this.login = login;
        this.email = email;
        this.userName = userName;
        this.ban = ban;
        this.age = age;
        this.role = role;
    }

    public User() {
    }

    public User(int userID, String login, String email, char[] password, String userName, boolean ban, int age, Role role) {
        UserID = userID;
        this.login = login;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.ban = ban;
        this.age = age;
        this.role = role;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User{" +
                "login=" + login + '\'' +
                "email=" + email + '\'' +
                "userName=" + userName + '\'' +
                "age=" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserID() == user.getUserID() &&
                isBan() == user.isBan() &&
                getAge() == user.getAge() &&
                Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Arrays.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getUserName(), user.getUserName()) &&
                getRole() == user.getRole();
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getUserID(), getLogin(), getEmail(), getUserName(), isBan(), getAge(), getRole());
        result = 31 * result + Arrays.hashCode(getPassword());
        return result;
    }
}
