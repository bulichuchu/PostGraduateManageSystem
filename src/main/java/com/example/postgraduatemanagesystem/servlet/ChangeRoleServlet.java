package com.example.postgraduatemanagesystem.servlet;

import com.example.postgraduatemanagesystem.DaoImpl.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ChangeRoleServlet")
public class ChangeRoleServlet  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentID = request.getParameter("userid");
        String role = request.getParameter("newRole");
        UserDAOImpl userDAO = new UserDAOImpl();
        boolean success = userDAO.changeRole(studentID, role);

        // 将修改结果存储在请求属性中
        request.setAttribute("changeRoleSuccess", success);

        // 重定向到结果页面
        response.sendRedirect("ChangeRole.jsp");
    }
}
