package com.mylibrary.booksmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // ✅ Validate login: return role (admin/user) or null if invalid
    public static String validateLogin(String username, String password) {
        String sql = "SELECT role FROM users WHERE username = ? AND password = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, username.trim());
            ps.setString(2, password.trim());
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("role"); // "admin" or "user"
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // ✅ Print error instead of ignoring
        }
        return null; // login failed
    }

    // ✅ Register new user
    public static boolean registerUser(String username, String password, String role) {
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, username.trim());
            ps.setString(2, password.trim());
            ps.setString(3, role.trim());
            return ps.executeUpdate() == 1;
        } catch (Exception ex) {
            ex.printStackTrace(); // ✅ Print error
        }
        return false;
    }

    // ✅ Get user id by username
    public static int getUserId(String username) {
        String sql = "SELECT user_id FROM users WHERE username = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, username.trim());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt("user_id");
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // ✅ Print error
        }
        return -1;
    }
}
