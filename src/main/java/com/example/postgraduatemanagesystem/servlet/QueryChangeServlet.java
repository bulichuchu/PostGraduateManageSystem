package com.example.postgraduatemanagesystem.servlet;

import com.example.postgraduatemanagesystem.DaoImpl.BasicInfoDAOImpl;
import com.example.postgraduatemanagesystem.bean.BasicInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/QueryChangeServlet")
public class QueryChangeServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentID = request.getParameter("studentID");
        String studentName = request.getParameter("name");

        // 获取原始的用户信息
        BasicInfoDAOImpl basicInfoDAO = new BasicInfoDAOImpl();
        BasicInfo originalInfo = basicInfoDAO.getBasicInfo(studentID);
        if (!studentName.equals(originalInfo.getName())) {
            request.setAttribute("errorMessage", "学号与姓名不匹配，请重新输入！");
            request.getRequestDispatcher("QueryChange.jsp").forward(request, response);
            return;
        }
        request.setAttribute("originalInfo", originalInfo);
        request.getRequestDispatcher("changeInformation.jsp").forward(request, response);

    }
}
