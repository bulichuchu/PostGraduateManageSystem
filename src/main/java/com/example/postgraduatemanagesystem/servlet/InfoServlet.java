package com.example.postgraduatemanagesystem.servlet;

import com.example.postgraduatemanagesystem.DaoImpl.*;
import com.example.postgraduatemanagesystem.bean.*;

import com.example.postgraduatemanagesystem.dao.AdmissionInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class InfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentID = request.getParameter("userid");
        BasicInfoDAOImpl BasicInfoDAO = new BasicInfoDAOImpl();
        BasicInfo basicInfo = BasicInfoDAO.getBasicInfo(studentID);

        AdmissionInfoDAOImpl AdmissionInfoDAO = new AdmissionInfoDAOImpl();
        AdmissionInfo admissionInfo = AdmissionInfoDAO.getAdmissionInfo(studentID);

        ExtensionInfoDAOImpl ExtensionInfoDAO = new ExtensionInfoDAOImpl();
        ExtensionInfo extensionInfo = ExtensionInfoDAO.getExtensionInfo(studentID);

        WorkExperienceDAOImpl WorkExperienceDAO = new WorkExperienceDAOImpl();
        WorkExperience workExperience = WorkExperienceDAO.getWorkExperience(studentID);

        EducationExperienceDAOImpl EducationExperienceDAO = new EducationExperienceDAOImpl();
        EducationExperience educationExperience = EducationExperienceDAO.getEducationExperience(studentID);

        request.setAttribute("basicInfo", basicInfo);
        request.setAttribute("admissionInfo", admissionInfo);
        request.setAttribute("extensionInfo", extensionInfo);
        request.setAttribute("workExperience", workExperience);
        request.setAttribute("educationExperience", educationExperience);
        request.getRequestDispatcher("Info.jsp").forward(request, response);
    }


}