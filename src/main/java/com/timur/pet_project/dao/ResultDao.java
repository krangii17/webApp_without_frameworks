package com.timur.pet_project.dao;

import com.timur.pet_project.model.Result;
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
public class ResultDao extends AbstractDao<Result, Integer> {

    private final Logger Log = LoggerFactory.getLogger(ResultDao.class);

    private ResultSet resultSet;

    public ResultDao() {
        super();
    }

    @Override
    public List<Result> getList() {
        ArrayList<Result> resultsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .SELECT_ALL_RESULTS
                .getStatment())) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Result tempResult = new Result(resultSet.getInt("resultID"),
                        resultSet.getInt("userID"),
                        resultSet.getInt("testID"),
                        resultSet.getBoolean("passed"),
                        resultSet.getInt("points"));
                resultsList.add(tempResult);
            }
        } catch (SQLException sqlEx) {
            Log.error(sqlEx.getMessage());
        } finally {
            closeConnection();
        }
        return resultsList;
    }

    @Override
    public Result update(Result entity) {
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .UPDATE_RESULT
                .getStatment())) {
            statement.setInt(1, entity.getResultID());
            statement.setInt(2, entity.getUserID());
            statement.setInt(3, entity.getTestID());
            statement.setBoolean(4, entity.isPassed());
            statement.setInt(5, entity.getPoints());
            statement.setInt(6, entity.getResultID());
            statement.executeUpdate();
        } catch (SQLException e) {
            Log.error(e.getMessage());
        } finally {
            closeConnection();
        }
        return entity;
    }

    @Override
    public Result getById(Integer id) {
        Result result = new Result();
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .SELECT_RESULT
                .getStatment())) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result.setResultID(resultSet.getInt(1));
                result.setUserID(resultSet.getInt(2));
                result.setTestID(resultSet.getInt(3));
                result.setPassed(resultSet.getBoolean(4));
                result.setPoints(resultSet.getInt(5));
            }
        } catch (SQLException sqlEx) {
            Log.error(sqlEx.getMessage());
        } finally {
            closeConnection();
        }
        return result;
    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .DELETE_RESULT
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
    public void create(Result entity) {
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .CREATE_RESULT
                .getStatment())) {
            statement.setInt(1, entity.getResultID());
            statement.setInt(2, entity.getUserID());
            statement.setInt(3, entity.getTestID());
            statement.setBoolean(4, entity.isPassed());
            statement.setInt(5, entity.getPoints());
            statement.executeUpdate();
        } catch (SQLException sqlEx) {
            Log.error(sqlEx.getMessage());
        } finally {
            closeConnection();
        }
    }

    public ArrayList<Result> getResultsByUserId(Integer id) {
        ArrayList<Result> resultsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .SELECT_RESULT_FROM_USERID
                .getStatment())) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Result tempResult = new Result(resultSet.getInt("resultID"),
                        resultSet.getInt("userID"),
                        resultSet.getInt("testID"),
                        resultSet.getBoolean("passed"),
                        resultSet.getInt("points"));
                resultsList.add(tempResult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return resultsList;
    }
}
