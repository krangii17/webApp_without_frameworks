package com.timur.pet_project.util;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by timyr on 12.08.18.
 */
public class ConnectionPool {
    private static ConnectionPool instance;
    private static String propertyPath = "liquibase/liquibase.properties";
    private BoneCP connectionPool;

    private ConnectionPool() throws SQLException {
        try {
            connectionPool = new BoneCP(getConfig());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void setPropertyPath(String newPropertyPath) {
        propertyPath = newPropertyPath;
    }

    public static ConnectionPool getInstance() {
        ConnectionPool localInstance = instance;
        if (localInstance == null) {
            try {
                instance = localInstance = new ConnectionPool();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return localInstance;
    }

    private BoneCPConfig getConfig() throws IOException, ClassNotFoundException {
        Properties props = new Properties();
        try (InputStream in = ConnectionPool.class.getClassLoader().getResourceAsStream(propertyPath)) {
            props.load(in);
        }
        BoneCPConfig config = new BoneCPConfig();
        String drivers = props.getProperty("driver");
        Class.forName(drivers);
        config.setJdbcUrl(props.getProperty("url"));
        config.setUsername(props.getProperty("username"));
        config.setPassword(props.getProperty("password"));
        return config;
    }

    public Connection getConnection() {
        try {
            return connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Can not create connection");
    }

    public void closeConnection() {
        connectionPool.shutdown();
    }

}
