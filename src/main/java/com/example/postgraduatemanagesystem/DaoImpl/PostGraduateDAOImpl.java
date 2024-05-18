package com.example.postgraduatemanagesystem.DaoImpl;

import com.example.postgraduatemanagesystem.dao.PostGraduateDAO;

import java.sql.*;

public class PostGraduateDAOImpl  implements PostGraduateDAO {

        String connectionUrl = "jdbc:sqlserver://fushuai.database.windows.net:1433;database=postgraduate;" +
                "user=fushuai@fushuai;password=Fzh123456789;encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

        public boolean changePassword(String userid, String newPassword) {
            boolean isChanged = false;
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection(connectionUrl);
                // 查询用户表
                String sql = "UPDATE users SET password=? WHERE UserID=?";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, newPassword);
                pstmt.setString(2, userid);
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

        public boolean changeLoginStatus(String userid, String Password){
            boolean isChanged = false;
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection(connectionUrl);
                // 查询用户表
                String sql = "UPDATE Users SET isFirstLogin=0 WHERE UserID=? AND password=?";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, userid);
                pstmt.setString(2, Password);
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

