package com.mylibrary.booksmanagement;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Shared table model used by all frames so every view shows the same data.
 */
public class SharedBookModel {
    // Column names: keep them same in all frames
    public static final String[] COLUMNS = {"Book ID", "Title", "Author", "Copies"};

    // Shared model
    public static DefaultTableModel model = new DefaultTableModel(COLUMNS, 0) {
        @Override public boolean isCellEditable(int row, int column) { return false; }
    };

    // Load all books from DB into the model (clears before fill)
    public static void loadFromDB() {
        model.setRowCount(0);
        String sql = "SELECT id, title, author, copies FROM books ORDER BY id";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Object[] row = new Object[] {
                    rs.getString("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getInt("copies")
                };
                model.addRow(row);
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // keep simple for debugging
        }
    }
}
