package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String url = "jdbc:postgresql://localhost:5432/jdbs_task";
    private static final String user = "postgres";
    private static final String password = "1234";

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
