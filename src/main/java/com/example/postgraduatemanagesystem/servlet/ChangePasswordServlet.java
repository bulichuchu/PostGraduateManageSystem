package com.example.postgraduatemanagesystem.servlet;


import java.io.*;

import com.example.postgraduatemanagesystem.DaoImpl.PostGraduateDAOImpl;
import com.example.postgraduatemanagesystem.SM3.SM3Util;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("userid");
        String password = (String) session.getAttribute("password");
        String oldPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        if (password.equals(oldPassword)){

            PostGraduateDAOImpl postGraduateDAO = new PostGraduateDAOImpl();
            String hashedNewPassword = SM3Util.hash(newPassword);
            if (postGraduateDAO.changePassword(userid, hashedNewPassword) &&
                    postGraduateDAO.changeLoginStatus(userid, hashedNewPassword)) {
                request.getRequestDispatcher("InfoServlet").forward(request, response);
            }
        } else {
            request.setAttribute("message", "与原密码不符，请重新输入！");
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
        }
    }
}
