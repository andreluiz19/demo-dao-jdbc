package org.example.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

public class DB {

    private static Connection connection;

    public static Connection getConnection() {
        if (Objects.isNull(connection)) {
            Properties properties = loadProperties();
            String url = properties.getProperty("dbUrl");
            try {
                connection = DriverManager.getConnection(url, properties);
            } catch (SQLException ex) {
                throw new DbException(ex.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (Objects.nonNull(connection)) {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new DbException(ex.getMessage());
            }
        }
    }

    private static Properties loadProperties() {
        try {
            try (FileInputStream fs = new FileInputStream("C:\\IntelliJWorkspace\\java-jdbc-vanilla\\src\\main\\resources\\db.properties")) {
                Properties properties = new Properties();
                properties.load(fs);
                return properties;
            }
        } catch (IOException ex) {
            throw new DbException(ex.getMessage());
        }
    }

    public static void closeStatement(Statement statement) {
        if (Objects.nonNull(statement)) {
            try {
                statement.close();
            } catch (SQLException ex) {
                throw new DbException(ex.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (Objects.nonNull(resultSet)) {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                throw new DbException(ex.getMessage());
            }
        }
    }

}
