package com.example.postgraduatemanagesystem;

import java.io.*;

import com.microsoft.sqlserver.jdbc.SQLServerDatabaseMetaData;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;


public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Azure SQL数据库连接信息

        String connectionUrl = "jdbc:sqlserver://fushuai.database.windows.net:1433;database=postgraduate;" +
                "user=fushuai@fushuai;password=Fzh123456789;encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

        ResultSet rs = null;

        try {
            // 连接数据库
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            // 查询用户表
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            // 如果查询结果不为空，表示用户名密码匹配成功
            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("success.jsp");
            } else {
                response.sendRedirect("failure.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
