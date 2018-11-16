package com.timur.pet_project.dao.util;


import com.timur.pet_project.util.ConnectionPool;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.exception.LockException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;
import java.sql.SQLException;

public class H2Connector {
    private Liquibase liquibase;
    private Connection connection;

    public H2Connector() {
        ConnectionPool.setPropertyPath("h2.properties");
        connection = ConnectionPool.getInstance().getConnection();
    }

    public synchronized void buildDb() throws LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(
                new JdbcConnection(connection));
        liquibase = new Liquibase("liquibase/db-changelog-master.xml",
                new ClassLoaderResourceAccessor(), database);
        liquibase.update("public");
    }

    public void dropDb() throws DatabaseException, LockException, SQLException {
        liquibase.dropAll();
        connection.close();
    }

}
