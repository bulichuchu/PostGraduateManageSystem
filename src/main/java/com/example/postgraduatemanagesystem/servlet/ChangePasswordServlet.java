package com.example.postgraduatemanagesystem.servlet;


import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import com.example.postgraduatemanagesystem.DAO.PostGraduateDAO;

public class ChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String newPassword = request.getParameter("newPassword");

        PostGraduateDAO postGraduateDAO = new PostGraduateDAO();
        boolean isChanged = postGraduateDAO.changePassword(username, newPassword);
        boolean LoginStatusChanged = postGraduateDAO.changeLoginStatus(username, newPassword);

        if (isChanged&&LoginStatusChanged) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("changePassword.jsp?error=changeFailed&username=" + username);
        }
    }
}
