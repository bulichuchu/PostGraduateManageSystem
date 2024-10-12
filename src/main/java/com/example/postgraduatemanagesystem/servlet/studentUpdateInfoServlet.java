package com.example.postgraduatemanagesystem.servlet;

import com.example.postgraduatemanagesystem.DaoImpl.ExtensionInfoDAOImpl;
import com.example.postgraduatemanagesystem.bean.ExtensionInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "StudentUpdateInfoServlet", urlPatterns = {"/studentUpdateInfo"})
public class studentUpdateInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String studentID = (String) session.getAttribute("userid");
        String wxID = request.getParameter("wxID");
        String qqID = request.getParameter("qqID");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String postCode = request.getParameter("postCode");
        String studyUnit = request.getParameter("studyUnit");
        String unitPhone = request.getParameter("unitPhone");
        String unitPostCode = request.getParameter("unitPostCode");
        String unitAddress = request.getParameter("unitAddress");
        String emergencyContact = request.getParameter("emergencyContact");
        String emergencyPhone = request.getParameter("emergencyPhone");
        String emergencyPostCode = request.getParameter("emergencyPostCode");
        String emergencyAddress = request.getParameter("emergencyAddress");
        String dormitoryAddress = request.getParameter("dormitoryAddress");
        String dormitoryPhone = request.getParameter("dormitoryPhone");
        String technicalPosition = request.getParameter("technicalPosition");
        String administrativePositionLevel = request.getParameter("administrativePositionLevel");
        String familyAddress = request.getParameter("familyAddress");
        String familyPostCode = request.getParameter("familyPostCode");
        String familyPhone = request.getParameter("familyPhone");
        String familyContact = request.getParameter("familyContact");

        ExtensionInfoDAOImpl extensionInfoDAO = new ExtensionInfoDAOImpl();
        ExtensionInfo extensionInfo = new ExtensionInfo();
        extensionInfo.setStudentID(Integer.parseInt(studentID));
        extensionInfo.setWxID(wxID);
        extensionInfo.setQqID(qqID);
        extensionInfo.setPhone(phone);
        extensionInfo.setAddress(address);
        extensionInfo.setPostCode(postCode);
        extensionInfo.setStudyUnit(studyUnit);
        extensionInfo.setUnitPhone(unitPhone);
        extensionInfo.setUnitPostCode(unitPostCode);
        extensionInfo.setUnitAddress(unitAddress);
        extensionInfo.setEmergencyContact(emergencyContact);
        extensionInfo.setEmergencyPhone(emergencyPhone);
        extensionInfo.setEmergencyPostCode(emergencyPostCode);
        extensionInfo.setEmergencyAddress(emergencyAddress);
        extensionInfo.setDormitoryAddress(dormitoryAddress);
        extensionInfo.setDormitoryPhone(dormitoryPhone);
        extensionInfo.setTechnicalPosition(technicalPosition);
        extensionInfo.setAdministrativePositionLevel(administrativePositionLevel);
        extensionInfo.setFamilyAddress(familyAddress);
        extensionInfo.setFamilyPostCode(familyPostCode);
        extensionInfo.setFamilyPhone(familyPhone);
        extensionInfo.setFamilyContact(familyContact);

        extensionInfoDAO.updateExtensionInfo(extensionInfo);

        // 确保路径正确
        response.sendRedirect(request.getContextPath() + "/StudentInfoServlet");
    }
}
