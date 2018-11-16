package com.timur.pet_project.dao;

import com.timur.pet_project.model.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by timyr on 09.08.18.
 */
public class TestDao extends AbstractDao<Test, Integer> {

    private final Logger Log = LoggerFactory.getLogger(TestDao.class);

    private ResultSet resultSet;

    public TestDao() {
        super();
    }

    @Override
    public List<Test> getList() {
        ArrayList<Test> tests = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .SELECT_ALL_TESTS
                .getStatment())) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Test tempTest = new Test(resultSet.getInt("testID"),
                        resultSet.getString("test_name"),
                        resultSet.getInt("level"),
                        resultSet.getString("topic"),
                        resultSet.getInt("tests_time"));
                tests.add(tempTest);
            }
        } catch (SQLException sqlEx) {
            Log.error(sqlEx.getMessage());
        } finally {
            closeConnection();
        }
        return tests;
    }

    @Override
    public Test update(Test entity) {
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .UPDATE_TEST
                .getStatment())) {

            statement.setString(1, entity.getTestName());
            statement.setInt(2, entity.getLevel());
            statement.setString(3, entity.getTopic());
            statement.setInt(4, entity.getTestTime());
            statement.setInt(5, entity.getTestID());
            statement.executeUpdate();
        } catch (SQLException e) {
            Log.error(e.getMessage());
        } finally {
            closeConnection();
        }
        return entity;
    }

    @Override
    public Test getById(Integer id) {
        Test test = new Test();
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .SELECT_TEST
                .getStatment())) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                test.setTestID(resultSet.getInt(1));
                test.setTestName(resultSet.getString(2));
                test.setLevel(resultSet.getInt(3));
                test.setTopic(resultSet.getString(4));
                test.setTestTime(resultSet.getInt(5));
            }
        } catch (SQLException sqlEx) {
            Log.error(sqlEx.getMessage());
        } finally {
            closeConnection();
        }
        return test;
    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .DELETE_TEST
                .getStatment())) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException sqlEx) {
            Log.error(sqlEx.getMessage());
        } finally {
            closeConnection();
        }
    }

    @Override
    public void create(Test entity) {
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .CREATE_TEST
                .getStatment())) {
            statement.setInt(1, entity.getTestID());
            statement.setString(2, entity.getTestName());
            statement.setInt(3, entity.getLevel());
            statement.setString(4, entity.getTopic());
            statement.setInt(5, entity.getTestTime());
            statement.executeUpdate();
        } catch (SQLException sqlEx) {
            Log.error(sqlEx.getMessage());
        } finally {
            closeConnection();
        }
    }
}
