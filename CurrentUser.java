package com.mylibrary.booksmanagement;

public class CurrentUser {
    private static int userId = -1;
    private static String username = null;
    private static String role = null;
    static int id;

    public static void set(int id, String uname, String r) {
        userId = id; username = uname; role = r;
    }
    public static void clear() {
        userId = -1; username = null; role = null;
    }
    public static int getUserId() { return userId; }
    public static String getUsername() { return username; }
    public static String getRole() { return role; }
    public static boolean isLoggedIn() { return userId != -1; }
}
