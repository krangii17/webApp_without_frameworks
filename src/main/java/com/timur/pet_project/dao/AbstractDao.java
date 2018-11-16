package com.timur.pet_project.dao;

import com.timur.pet_project.exceptions.DaoCloseConnectionException;
import com.timur.pet_project.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by timyr on 12.08.18.
 */
public abstract class AbstractDao<E, K> {
    protected Connection connection;
    private ConnectionPool connectionPool;

    AbstractDao() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DaoCloseConnectionException("Can't close DAO connection");
        }
    }

    public abstract List<E> getList() throws SQLException;

    public abstract E update(E entity) throws SQLException;

    public abstract E getById(K id) throws SQLException;

    public abstract void delete(K id) throws SQLException;

    public abstract void create(E entity) throws SQLException;

    protected void closeStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new DaoCloseConnectionException("Can't close DAO connection");
            }
        }
    }

}
