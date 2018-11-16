package com.timur.pet_project.dao;

import com.timur.pet_project.model.Question;
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
public class QuestionsDao extends AbstractDao<Question, Integer> {
    private final Logger Log = LoggerFactory.getLogger(QuestionsDao.class);
    private ResultSet resultSet;

    public QuestionsDao() {
        super();
    }

    @Override
    public List<Question> getList() {
        ArrayList<Question> questionsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .SELECT_ALL_QUESTIONS
                .getStatment())) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Question tempQuestion = new Question(resultSet.getInt("questionID"),
                        resultSet.getString("question"),
                        resultSet.getInt("testID"));
                questionsList.add(tempQuestion);
            }
        } catch (SQLException sqlEx) {
            Log.error(sqlEx.getMessage());
        } finally {
            closeConnection();
        }
        return questionsList;
    }

    @Override
    public Question update(Question entity) {
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .UPDATE_QUESTION
                .getStatment())) {
            statement.setString(1, entity.getQuestion());
            statement.setInt(2, entity.getTestID());
            statement.setInt(3, entity.getQuestionID());
            statement.executeUpdate();
        } catch (SQLException e) {
            Log.error(e.getMessage());
        } finally {
            closeConnection();
        }
        return entity;
    }

    @Override
    public Question getById(Integer id) {
        Question question = new Question();
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .SELECT_QUESTION
                .getStatment())) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                question.setQuestionID(resultSet.getInt(1));
                question.setQuestion(resultSet.getString(2));
                question.setTestID(resultSet.getInt(3));
            }
        } catch (SQLException sqlEx) {
            Log.error(sqlEx.getMessage());
        } finally {
            closeConnection();
        }
        return question;
    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .DELETE_QUESTION
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
    public void create(Question entity) {
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .CREATE_QUESTION
                .getStatment())) {
            statement.setString(1, entity.getQuestion());
            statement.setInt(2, entity.getTestID());
            statement.executeUpdate();
        } catch (SQLException sqlEx) {
            Log.error(sqlEx.getMessage());
        } finally {
            closeConnection();
        }
    }

    public ArrayList<Question> getQuestionsByTestId(Integer testID) {
        ArrayList<Question> questions = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .SELECT_QUESTIONS_BY_TESTID
                .getStatment())) {
            statement.setInt(1, testID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setQuestionID(rs.getInt(1));
                question.setQuestion(rs.getString(2));
                question.setTestID(testID);
                questions.add(question);
            }
        } catch (SQLException e) {
            Log.error(e.getMessage());
        } finally {
            closeConnection();
        }
        return questions;
    }
}
