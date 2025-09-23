package domain.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dataBaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/crypto_wallet";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    private static Connection Instance = null;

    // Method to get a database connection
    private static Connection getConnection() {
        try {
            // Optional: explicitly load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("MySQL Driver not found!", e);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to database", e);
        }
    }
    public static Connection getInstence(){
        if (Instance == null) {
            Instance =getConnection();
        }
        return Instance;
    }
}
