package com.example.postgraduatemanagesystem.servlet;

import com.example.postgraduatemanagesystem.DaoImpl.UserDAOImpl;
import com.example.postgraduatemanagesystem.bean.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.example.postgraduatemanagesystem.SM3.SM3Util;
import org.bouncycastle.jcajce.provider.digest.SM3;

import java.io.IOException;
import java.io.Serial;

public class LoginServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final int MAX_LOGIN_ATTEMPTS = 5;
    private static final long LOCKOUT_DURATION = 30 * 60 * 1000;
    private static final long SESSION_TIMEOUT = 30 * 60 * 1000;
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval((int) SESSION_TIMEOUT / 1000);


        // 检查登录失败计数器
        Integer loginAttemptsAttribute = (Integer) session.getAttribute("loginAttempts");
        int loginAttempts = (loginAttemptsAttribute != null) ? loginAttemptsAttribute : 0;


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
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.getUser(userid, SM3Util.hash(password));
        if (user != null) {
            String role = user.getRole();
            session.setAttribute("userid", userid);
            session.setAttribute("password", SM3Util.hash(password));
            session.setAttribute("role", role);
            session.setAttribute("user", user);
            LOGGER.info("User " + userid + " logged in successfully.");

            switch (role) {
                case "研究生":
                    if ("1".equals(user.getIsfirstlogin())) {
                        response.sendRedirect("changePassword.jsp");
                    } else {
                        // 重置登录失败计数器
                        session.setAttribute("loginAttempts", 0);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/StudentInfoServlet");
                        dispatcher.forward(request, response);
                    }
                    break;
                case "导师", "研究生院领导", "学校领导":
                    session.setAttribute("loginAttempts", 0);
                    response.sendRedirect("studentQuery.jsp");
                    break;
                case "学院研究生秘书", "学院领导":
                    session.setAttribute("loginAttempts", 0);
                    response.sendRedirect("QueryChange.jsp");
                    break;
                case "研究生院管理员":
                    session.setAttribute("loginAttempts", 0);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/ReviewInfoServlet");
                    dispatcher.forward(request, response);
                    break;
                case "系统管理员":
                    session.setAttribute("loginAttempts", 0);
                    response.sendRedirect("ChangeRole.jsp");
                    break;
                case "审计管理员":
                    session.setAttribute("loginAttempts", 0);
                    response.sendRedirect("log.jsp");
                    break;
            }
        } else {
            // 增加登录失败计数器
            int newLoginAttempts = loginAttempts + 1;
            session.setAttribute("loginAttempts", newLoginAttempts);
            session.setAttribute("message", "用户名或密码错误，请重新输入！");
            response.sendRedirect("login.jsp");
            LOGGER.warn("Failed login attempt for user " + userid);
        }
    }
}