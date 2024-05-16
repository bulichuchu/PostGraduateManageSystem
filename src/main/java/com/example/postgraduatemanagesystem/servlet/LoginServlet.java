package com.example.postgraduatemanagesystem.servlet;

import com.example.postgraduatemanagesystem.DAO.PostGraduateDAO;
import com.example.postgraduatemanagesystem.DAO.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        UserDAO userDAO = new UserDAO();
        boolean isValid = userDAO.validate(username, password);

        if (isValid) {
            String role = userDAO.getRole(username, password);
            switch (role) {
                case "研究生":
                    PostGraduateDAO postGraduateDAO = new PostGraduateDAO();
                    if (postGraduateDAO.isFirstLogin(username, password)) {
                        response.sendRedirect("changePassword.jsp?username=" + username);
                    } else {
                        response.sendRedirect("student.jsp");
                    }
                    response.sendRedirect("admin.jsp");
                    break;
                case "导师":
                    response.sendRedirect("student.jsp");
                    break;
                case "学院研究生秘书":
                    response.sendRedirect("teacher.jsp");
                    break;
                case "学院领导":
                    response.sendRedirect("teacher.jsp");
                    break;
                case "研究生院管理员":
                    response.sendRedirect("teacher.jsp");
                    break;
                case "研究生院领导":
                    response.sendRedirect("teacher.jsp");
                    break;
                case "学校领导":
                    response.sendRedirect("teacher.jsp");
                    break;
                case "系统管理员":
                    response.sendRedirect("teacher.jsp");
                    break;
                case "审计管理员":
                    response.sendRedirect("teacher.jsp");
                    break;

                default:
                    response.sendRedirect("failure.jsp");
                    break;
            }
        } else {
            response.sendRedirect("failure.jsp");
        }
    }

}
