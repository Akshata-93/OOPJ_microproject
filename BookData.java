/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mylibrary.booksmanagement;

import javax.swing.table.DefaultTableModel;

public class BookData {
    // Shared DefaultTableModel used by all frames
    public static final DefaultTableModel model = new DefaultTableModel(
        new Object[] { "ID", "Title", "Author", "Copies" }, 0
    );

    // Initial sample rows (for testing)
    static {
        model.addRow(new Object[] { "B0001", "The Alchemist", "Paulo Coelho", 5 });
        model.addRow(new Object[] { "B0002", "Java Programming", "James Gosling", 3 });
        model.addRow(new Object[] { "B0003", "Data Structures", "Mark Allen Weiss", 2 });
        model.addRow(new Object[] { "B0004", "Clean Code", "Robert C. Martin", 4 });
    }
}
