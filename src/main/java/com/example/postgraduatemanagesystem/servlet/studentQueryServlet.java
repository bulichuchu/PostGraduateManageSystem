package com.example.postgraduatemanagesystem.servlet;

import com.example.postgraduatemanagesystem.DaoImpl.BasicInfoDAOImpl;
import com.example.postgraduatemanagesystem.DaoImpl.UserDAOImpl;
import com.example.postgraduatemanagesystem.bean.BasicInfo;
import com.example.postgraduatemanagesystem.bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import java.io.IOException;

public class studentQueryServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(studentQueryServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String studentID = request.getParameter("studentID");
        String name = request.getParameter("name");


        User user = (User) session.getAttribute("user");

        BasicInfoDAOImpl BasicInfoDAO = new BasicInfoDAOImpl();
        BasicInfo basicInfo = BasicInfoDAO.getBasicInfo(studentID);

        if (session.getAttribute("role").equals("导师")) {
            if (name.equals(basicInfo.getName()) && user.getUsername().equals(basicInfo.getMentor())) {
                session.setAttribute("userid", studentID);
                LOGGER.info("Successful student query for user " + studentID);
                request.getRequestDispatcher("InfoServlet").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "学号与姓名不匹配，或您无权查看，请重新输入！");
                LOGGER.warn("Failed student query for user " + studentID);
                request.getRequestDispatcher("studentQuery.jsp").forward(request, response);
            }
        } else if (session.getAttribute("role").equals("学校领导")) {
            if (name.equals(basicInfo.getName())) {
                session.setAttribute("userid", studentID);
                LOGGER.info("Successful student query for user " + studentID);
                request.getRequestDispatcher("InfoServlet").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "学号与姓名不匹配，或您无权查看，请重新输入！");
                LOGGER.warn("Failed student query for user " + studentID);
                request.getRequestDispatcher("studentQuery.jsp").forward(request, response);
            }

        } else {
            if (name.equals(basicInfo.getName()) && user.getDepartment().equals(basicInfo.getCollege())) {
                session.setAttribute("userid", studentID);
                LOGGER.info("Successful student query for user " + studentID);
                request.getRequestDispatcher("InfoServlet").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "学号与姓名不匹配，或您无权查看，请重新输入！");
                LOGGER.warn("Failed student query for user " + studentID);
                request.getRequestDispatcher("studentQuery.jsp").forward(request, response);
            }
        }
    }

}
