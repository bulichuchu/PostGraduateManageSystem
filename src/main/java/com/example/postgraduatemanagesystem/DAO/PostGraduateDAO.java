package com.example.postgraduatemanagesystem.DAO;

import java.sql.*;

public class PostGraduateDAO {
    String connectionUrl = "jdbc:sqlserver://fushuai.database.windows.net:1433;database=postgraduate;" +
            "user=fushuai@fushuai;password=Fzh123456789;encrypt=true;trustServerCertificate=false;" +
            "hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    public boolean isFirstLogin(String username, String password) {

        boolean isFirstLogin = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            // 查询用户表
            String sql = "SELECT isFirstLogin FROM users WHERE username=? AND password=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                isFirstLogin = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isFirstLogin;
    }

    public boolean changePassword(String username, String newPassword) {
        boolean isChanged = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            // 查询用户表
            String sql = "UPDATE users SET password=? WHERE username=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, newPassword);
            pstmt.setString(2, username);
            int result = pstmt.executeUpdate();

            if (result > 0) {
                isChanged = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isChanged;
    }

    public boolean changeLoginStatus(String username, String Password){
        boolean isChanged = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            // 查询用户表
            String sql = "UPDATE Users SET isFirstLogin=false WHERE username=? AND password=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, Password);
            pstmt.setString(2, username);
            int result = pstmt.executeUpdate();

            if (result > 0) {
                isChanged = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isChanged;
    }
}