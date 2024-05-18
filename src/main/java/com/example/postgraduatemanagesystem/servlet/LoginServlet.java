package com.example.postgraduatemanagesystem.servlet;


import com.example.postgraduatemanagesystem.DaoImpl.PostGraduateDAOImpl;
import com.example.postgraduatemanagesystem.DaoImpl.UserDAOImpl;
import com.example.postgraduatemanagesystem.bean.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {



    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");

        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.getUser(userid, password);
        if (user != null) {
            String role = user.getRole();
            HttpSession session = request.getSession();
            session.setAttribute("userid", userid);
            session.setAttribute("password", password);
            switch (role) {
                case "研究生":
                    if (user.getIsfirstlogin().equals("1")) {
                        response.sendRedirect("changePassword.jsp");
                    } else {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/InfoServlet");
                        dispatcher.forward(request, response);
                    }
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
