package com.mylibrary.booksmanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Simple test program: connects to DB and prints rows from books table.
 */
public class TestDB {
    public static void main(String[] args) {
        System.out.println("Starting DB test...");
        try (Connection con = DBConnection.getConnection()) {
            if (con == null) {
                System.out.println("Connection is null — check DBConnection settings (URL/USER/PASS).");
                return;
            }
            System.out.println("Connected to DB successfully.");
            try (Statement st = con.createStatement()) {
                // if you used a different database name change it here
                st.execute("USE library_system");
                ResultSet rs = st.executeQuery("SELECT id, title, author, copies FROM books ORDER BY id");
                System.out.println("Rows from books table:");
                int count = 0;
                while (rs.next()) {
                    count++;
                    System.out.printf("%s | %s | %s | %d%n",
                        rs.getString("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("copies"));
                }
                if (count == 0) System.out.println("(no rows found)");
            }
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getClass().getSimpleName() + " - " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
