package com.example.postgraduatemanagesystem.servlet;

import com.example.postgraduatemanagesystem.DaoImpl.UserDAOImpl;
import com.example.postgraduatemanagesystem.bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class studentQueryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentID = request.getParameter("studentID");
        String name = request.getParameter("name");

        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.getUser(studentID);
        if(!name.equals(user.getUsername())){
            request.setAttribute("errorMessage", "学号与姓名不匹配，请重新输入！");

            request.getRequestDispatcher("studentQuery.jsp").forward(request, response);
        }
        else{
            HttpSession session = request.getSession();
            session.setAttribute("userid", studentID);
            request.getRequestDispatcher("InfoServlet").forward(request, response);
        }
    }
}
