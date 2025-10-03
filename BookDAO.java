package com.mylibrary.booksmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Book DAO - simple CRUD and borrow/return operations.
 */
public class BookDAO {

    public static boolean addBook(String id, String title, String author, int copies) {
    String sql = "INSERT INTO books (id, title, author, copies) VALUES (?, ?, ?, ?)";
    try (Connection c = DBConnection.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)) {
        ps.setString(1, id);
        ps.setString(2, title);
        ps.setString(3, author);
        ps.setInt(4, copies);
        return ps.executeUpdate() == 1;
    } catch (Exception e) {   // ✅ Catch exception here
        e.printStackTrace();
        return false;
    }
}

public static boolean updateBook(String id, String title, String author, int copies) {
        String sql = "UPDATE books SET title = ?, author = ?, copies = ? WHERE id = ?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, copies);
            ps.setString(4, id);
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

public static boolean deleteBook(String id) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean borrowBook(String id) {
        String sql = "UPDATE books SET copies = copies - 1 WHERE id = ? AND copies > 0";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean returnBook(String id) {
        String sql = "UPDATE books SET copies = copies + 1 WHERE id = ?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean exists(String id) {
        String sql = "SELECT 1 FROM books WHERE id = ?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        }
    
