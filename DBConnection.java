package com.mylibrary.booksmanagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/library_system"; // ✅ Must match your DB
    private static final String USER = "root"; // ✅ Your MySQL username
    private static final String PASSWORD = "root123"; // ✅ Your MySQL password

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
