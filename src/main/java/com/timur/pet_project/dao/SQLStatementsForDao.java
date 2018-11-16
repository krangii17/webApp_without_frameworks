package com.timur.pet_project.dao;

/**
 * Created by timyr on 09.08.18.
 */
public enum SQLStatementsForDao {

    SELECT_ALL_ANSWERS("select * from answers"),
    SELECT_ANSWERS_BY_QUESTIONID("select * from answers where questionID = ?"),
    SELECT_ANSWER("select * from answers where answerID = ?"),
    UPDATE_ANSWER("update answers set answerID = ?, answer = ?, correct = ?, questionID = ? where answerID = ?"),
    DELETE_ANSWER("delete from answers where answerID = ?"),
    CREATE_ANSWER("insert into answers (answer , correct, questionID) values (?,?,?)"),
    SELECT_ALL_QUESTIONS("select * from questions"),
    SELECT_QUESTION("select * from questions where questionID = ?"),
    SELECT_QUESTIONS_BY_TESTID("select * from questions where testID = ?"),
    UPDATE_QUESTION("update questions set question=?, testID=? where questionID=?"),
    DELETE_QUESTION("delete from questions where questionID = ?"),
    CREATE_QUESTION("insert into questions (question,testID) values (?,?)"),
    SELECT_ALL_RESULTS("select * from results"),
    SELECT_RESULT("select * from results where resultID = ?"),
    SELECT_RESULT_FROM_USERID("select * from results where userID = ?"),
    UPDATE_RESULT("update results set resultID = ?, userID = ?, testID = ?, passed = ?,points = ? where resultID = ?"),
    DELETE_RESULT("delete from results where resultID = ?"),
    CREATE_RESULT("insert into results (resultID, userID , testID, passed, points) values (?,?,?,?,?)"),
    SELECT_ALL_TESTS("select * from tests"),
    SELECT_TEST("select * from tests where testID = ?"),
    UPDATE_TEST("update tests set  test_name = ?, level = ?, topic = ?, tests_time=? where testID = ?"),
    DELETE_TEST("delete from tests where testID = ?"),
    CREATE_TEST("insert into tests (testID, test_name , level, topic, tests_time) values (?,?,?,?,?)"),
    SELECT_ALL_USERS("select * from users"),
    SELECT_USER("select * from users where userID = ?"),
    BAN_USER("update users set ban = ? where userID = ?"),
    UPDATE_USER("update users set Login = ?, email = ?, password = ?, user_name = ?, ban = ?, age = ?, role = ? where userID = ?"),
    DELETE_USER("delete from users where userID = ?"),
    CREATE_USER("insert into users (Login , email, password, user_name,  age, role) values (?,?,?,?,?,?)"),
    SELECT_USER_BY_LOGIN("select * from users where email = ?");

    private final String statment;

    SQLStatementsForDao(String statment) {
        this.statment = statment;
    }

    public String getStatment() {
        return statment;
    }

}
