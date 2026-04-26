package com.harsha.bank.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3307/bank_db?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USER = "harsha";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Database Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }
}
