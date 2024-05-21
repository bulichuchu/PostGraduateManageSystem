package com.example.postgraduatemanagesystem.servlet;

import com.example.postgraduatemanagesystem.DaoImpl.PostGraduateDAOImpl;
import com.example.postgraduatemanagesystem.DaoImpl.UserDAOImpl;
import com.example.postgraduatemanagesystem.SM3.SM3Util;
import com.example.postgraduatemanagesystem.bean.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Serial;

public class LoginServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final int MAX_LOGIN_ATTEMPTS = 5;
    private static final long LOCKOUT_DURATION = 30 * 60 * 1000;
    private static final long SESSION_TIMEOUT = 30 * 60 * 1000;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval((int) SESSION_TIMEOUT / 1000);
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.getUser(userid, password);

        // 检查登录失败计数器
        Integer loginAttemptsAttribute = (Integer) session.getAttribute("loginAttempts");
        int loginAttempts = (loginAttemptsAttribute != null) ? loginAttemptsAttribute : 4;


        session.setAttribute("lastLoginTime", session.getCreationTime());
        long lastLoginTime = (long) session.getAttribute("lastLoginTime");

        if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
            if (System.currentTimeMillis() - lastLoginTime < LOCKOUT_DURATION) {
                long remainingTime = LOCKOUT_DURATION - (System.currentTimeMillis() - lastLoginTime);
                session.setAttribute("message", "登录失败次数过多，请 " + remainingTime / 1000 + " 秒后重试。");
                response.sendRedirect("login.jsp");
                return;
            }
            // 重置登录失败计数器
            session.setAttribute("loginAttempts", 0);
        }

        if (user != null) {
            String role = user.getRole();
            session.setAttribute("userid", userid);
            session.setAttribute("password", password); // 存储哈希后的密码


            switch (role) {
                case "研究生":
                    if ("1".equals(user.getIsfirstlogin())) {
                        response.sendRedirect("changePassword.jsp");
                    } else {
                        // 重置登录失败计数器
                        session.setAttribute("loginAttempts", 0);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/InfoServlet");
                        dispatcher.forward(request, response);
                    }
                    break;
                case "导师", "研究生院领导", "学校领导":
                    session.setAttribute("loginAttempts", 0);
                    response.sendRedirect("studentQuery.jsp");
                    break;
                case "学院研究生秘书", "学院领导":
                    response.sendRedirect("teacher.jsp");
                    break;
                case "研究生院管理员":
                    response.sendRedirect("teacher.jsp");
                    break;
                case "系统管理员":
                    response.sendRedirect("teacher.jsp");
                    break;
                case "审计管理员":
                    response.sendRedirect("teacher.jsp");
                    break;
            }
        } else {
            // 增加登录失败计数器
            int newLoginAttempts = loginAttempts + 1;
            session.setAttribute("loginAttempts", newLoginAttempts);
            session.setAttribute("message", "用户名或密码错误，请重新输入！");
            response.sendRedirect("login.jsp");
        }
    }
}
