package com.example.postgraduatemanagesystem.DaoImpl;

import com.example.postgraduatemanagesystem.dao.UserDAO;
import com.example.postgraduatemanagesystem.bean.User;

import java.sql.*;

public class UserDAOImpl implements UserDAO {
    String connectionUrl = "jdbc:sqlserver://fushuai.database.windows.net:1433;database=postgraduate;" +
            "user=fushuai@fushuai;password=Fzh123456789;encrypt=true;trustServerCertificate=false;" +
            "hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    @Override
    public boolean available(String userid, String password) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean available = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            // 查询用户表
            String sql = "SELECT * FROM users WHERE UserID=? AND password=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userid);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                available = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return available;
    }

    @Override
    public User getUser(String userid, String password) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = new User();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            // 查询用户表
            String sql = "SELECT * FROM users WHERE UserID=? AND password=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userid);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();


            if (rs.next()) {
                user.setUserID(rs.getString("UserID"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setIsfirstlogin(rs.getString("isFirstLogin"));
            }
            else {
                user = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

}

