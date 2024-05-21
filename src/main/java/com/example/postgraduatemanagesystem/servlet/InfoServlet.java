package com.example.postgraduatemanagesystem.servlet;

import com.example.postgraduatemanagesystem.DaoImpl.*;
import com.example.postgraduatemanagesystem.bean.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Serial;

public class InfoServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(InfoServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String studentID = (String) session.getAttribute("userid");
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

        LOGGER.info("Retrieved information for user " + studentID);

        request.setAttribute("basicInfo", basicInfo);
        request.setAttribute("admissionInfo", admissionInfo);
        request.setAttribute("extensionInfo", extensionInfo);
        request.setAttribute("workExperience", workExperience);
        request.setAttribute("educationExperience", educationExperience);
        request.getRequestDispatcher("Info.jsp").forward(request, response);
    }


}