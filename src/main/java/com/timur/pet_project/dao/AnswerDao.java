package com.timur.pet_project.dao;

import com.timur.pet_project.model.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by timyr on 12.08.18.
 */
public class AnswerDao extends AbstractDao<Answer, Integer> {

    private final Logger Log = LoggerFactory.getLogger(AnswerDao.class);

    private ResultSet resultSet;

    public AnswerDao() {
        super();
    }

    @Override
    public List<Answer> getList() {
        ArrayList<Answer> answersList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .SELECT_ALL_ANSWERS
                .getStatment())) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Answer tempAnswer = new Answer(resultSet.getInt("answerID"),
                        resultSet.getString("answer"),
                        resultSet.getBoolean("correct"),
                        resultSet.getInt("questionID"));
                answersList.add(tempAnswer);
            }
        } catch (SQLException sqlEx) {
            Log.error(sqlEx.getMessage());
        } finally {
            closeConnection();
        }
        return answersList;

    }

    @Override
    public Answer update(Answer entity) {
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .UPDATE_ANSWER
                .getStatment())) {
            statement.setInt(1, entity.getAnswerID());
            statement.setString(2, entity.getAnswer());
            statement.setBoolean(3, entity.isCorrect());
            statement.setInt(4, entity.getQuestionID());
            statement.setInt(5, entity.getAnswerID());
            statement.executeUpdate();
        } catch (SQLException e) {
            Log.error(e.getMessage());
        } finally {
            closeConnection();
        }
        return entity;
    }

    @Override
    public Answer getById(Integer id) {
        Answer answer = new Answer();
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .SELECT_ANSWER
                .getStatment())) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                answer.setAnswerID(resultSet.getInt(1));
                answer.setAnswer(resultSet.getString(2));
                answer.setCorrect(resultSet.getBoolean(3));
                answer.setQuestionID(resultSet.getInt(4));
            }
        } catch (SQLException sqlEx) {
            Log.error(sqlEx.getMessage());
        } finally {
            closeConnection();
        }
        return answer;
    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .DELETE_ANSWER
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
    public void create(Answer entity) {
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .CREATE_ANSWER
                .getStatment())) {
            statement.setString(1, entity.getAnswer());
            statement.setBoolean(2, entity.isCorrect());
            statement.setInt(3, entity.getQuestionID());
            statement.executeUpdate();
        } catch (SQLException sqlEx) {
            Log.error(sqlEx.getMessage());
        } finally {
            closeConnection();
        }
    }

    public List<Answer> getAnswersByQuestionsID(int id) {
        ArrayList<Answer> answersList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .SELECT_ANSWERS_BY_QUESTIONID
                .getStatment())) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Answer tempAnswer = new Answer(resultSet.getInt("answerID"),
                        resultSet.getString("answer"),
                        resultSet.getBoolean("correct"),
                        resultSet.getInt("questionID"));
                answersList.add(tempAnswer);
            }
        } catch (SQLException sqlEx) {
            Log.error(sqlEx.getMessage());
        } finally {
            closeConnection();
        }
        return answersList;
    }


}
