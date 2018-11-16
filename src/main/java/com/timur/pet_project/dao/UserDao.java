package com.timur.pet_project.dao;

import com.timur.pet_project.model.Role;
import com.timur.pet_project.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.CharArrayReader;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by timyr on 09.08.18.
 */
public class UserDao extends AbstractDao<User, Integer> {

    private final Logger Log = LoggerFactory.getLogger(UserDao.class);

    private ResultSet resultSet;

    public UserDao() {
        super();
    }

    @Override
    public List<User> getList() {
        ArrayList<User> users = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .SELECT_ALL_USERS
                .getStatment())) {

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User tempUser = new User(resultSet.getInt("userID"),
                        resultSet.getString("Login"),
                        resultSet.getString("email"),
                        resultSet.getString("user_name"),
                        resultSet.getBoolean("ban"),
                        resultSet.getInt("age"),
                        Role.valueOf(resultSet.getString("role")));
                users.add(tempUser);
            }
        } catch (SQLException sqlEx) {
            Log.error(sqlEx.getMessage());
        } finally {
            closeConnection();
        }
        return users;
    }

    @Override
    public User update(User entity) {
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .UPDATE_USER
                .getStatment())) {
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getEmail());
            Reader reader = new CharArrayReader(entity.getPassword());
            statement.setCharacterStream(3, reader);
            statement.setString(4, entity.getUserName());
            statement.setBoolean(5, entity.isBan());
            statement.setInt(6, entity.getAge());
            statement.setString(7, entity.getRole().name());
            statement.setInt(8, entity.getUserID());
            statement.executeUpdate();
        } catch (SQLException e) {
            Log.error(e.getMessage());
        } finally {
            closeConnection();
        }
        return entity;
    }

    @Override
    public User getById(Integer id) {
        User user = new User();
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .SELECT_USER
                .getStatment())) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setUserID(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setPassword(resultSet.getString(4).toCharArray());
                user.setUserName(resultSet.getString(5));
                user.setBan(resultSet.getBoolean(6));
                user.setAge(resultSet.getInt(7));
                user.setRole(Role.valueOf(resultSet.getString(8)));
            }
        } catch (SQLException sqlEx) {
            Log.error(sqlEx.getMessage());
        } finally {
            closeConnection();
        }
        return user;
    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .DELETE_USER
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
    public void create(User entity) {
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .CREATE_USER
                .getStatment())) {
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getEmail());
            Reader reader = new CharArrayReader(entity.getPassword());
            statement.setCharacterStream(3, reader);
            statement.setString(4, entity.getUserName());
            statement.setInt(5, entity.getAge());
            statement.setString(6, entity.getRole().name());
            statement.executeUpdate();
        } catch (SQLException sqlEx) {
            Log.error(sqlEx.getMessage());
        } finally {
            closeConnection();
        }
    }

    public User getEntityByEmail(String email) {
        User user = new User();
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .SELECT_USER_BY_LOGIN
                .getStatment())) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            rs.next();
            user.setUserID(rs.getInt(1));
            user.setLogin(rs.getString(2));
            user.setEmail(rs.getString(3));
            user.setPassword(rs.getString(4).toCharArray());
            user.setUserName(rs.getString(5));
            user.setBan(rs.getBoolean(6));
            user.setAge(rs.getInt(7));
            user.setRole(Role.valueOf(rs.getString(8)));
        } catch (SQLException e) {
            Log.error(e.getMessage());
        } finally {
            closeConnection();
        }
        return user;
    }

    public void bunOrUnbanUserByID(Integer id, boolean ban) {
        try (PreparedStatement statement = connection.prepareStatement(SQLStatementsForDao
                .BAN_USER
                .getStatment())) {
            statement.setBoolean(1, ban);
            statement.setInt(2, id);
            Log.debug("change ban status");
            statement.execute();
        } catch (SQLException e) {
            Log.error(e.getMessage());
        } finally {
            closeConnection();
        }
    }
}
