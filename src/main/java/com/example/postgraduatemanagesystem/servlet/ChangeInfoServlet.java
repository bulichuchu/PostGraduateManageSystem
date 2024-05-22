package com.example.postgraduatemanagesystem.servlet;

import com.example.postgraduatemanagesystem.DaoImpl.BasicInfoDAOImpl;
import com.example.postgraduatemanagesystem.bean.BasicInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serial;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.databind.ObjectMapper; // 引入Jackson库



@SuppressWarnings("CallToPrintStackTrace")
@WebServlet("/ChangeInfoServlet")
public class ChangeInfoServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    // 将 BasicInfo 对象转换为JSON格式的方法
    private String convertBasicInfoToJson(BasicInfo info) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(info);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String studentID = (String) session.getAttribute("userid");

        // 获取原始的用户信息
        BasicInfoDAOImpl basicInfoDAO = new BasicInfoDAOImpl();
        BasicInfo originalInfo = basicInfoDAO.getBasicInfo(studentID);

        // 获取表单提交的修改信息
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String name = request.getParameter("name");
        String namePY = request.getParameter("namePY");
        String gender = request.getParameter("gender");
        String nation = request.getParameter("nation");
        Date birthDate;
        try {
            birthDate = sdf.parse(request.getParameter("birthDate"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String nativePlace = request.getParameter("nativePlace");
        String politicalStatus = request.getParameter("politicalStatus");
        String IDNumber = request.getParameter("IDNumber");
        String IDType = request.getParameter("IDType");
        String maritalStatus = request.getParameter("maritalStatus");
        String birthPlace = request.getParameter("birthPlace");
        String familyAddress = request.getParameter("familyAddress");
        String phoneNumber = request.getParameter("phoneNumber");
        String campusEmail = request.getParameter("campusEmail");
        String personalEmail = request.getParameter("personalEmail");
        Date joinPartyDate;
        try {
            joinPartyDate = sdf.parse(request.getParameter("joinPartyDate"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // 创建BasicInfo对象并设置修改后的信息
        BasicInfo updatedInfo = new BasicInfo();
        updatedInfo.setStudentID(Integer.parseInt(studentID));
        updatedInfo.setName(name != null ? name : originalInfo.getName());
        updatedInfo.setNamePY(namePY != null ? namePY : originalInfo.getNamePY());
        updatedInfo.setGender(gender != null ? gender : originalInfo.getGender());
        updatedInfo.setNation(nation != null ? nation : originalInfo.getNation());
        updatedInfo.setBirthDate(birthDate != null ? birthDate : originalInfo.getBirthDate());
        updatedInfo.setNativePlace(nativePlace != null ? nativePlace : originalInfo.getNativePlace());
        updatedInfo.setPoliticalStatus(politicalStatus != null ? politicalStatus : originalInfo.getPoliticalStatus());
        updatedInfo.setIDNumber(IDNumber != null ? IDNumber : originalInfo.getIDNumber());
        updatedInfo.setIDType(IDType != null ? IDType : originalInfo.getIDType());
        updatedInfo.setMaritalStatus(maritalStatus != null ? maritalStatus : originalInfo.getMaritalStatus());
        updatedInfo.setBirthPlace(birthPlace != null ? birthPlace : originalInfo.getBirthPlace());
        updatedInfo.setFamilyAddress(familyAddress != null ? familyAddress : originalInfo.getFamilyAddress());
        updatedInfo.setPhoneNumber(phoneNumber != null ? phoneNumber : originalInfo.getPhoneNumber());
        updatedInfo.setCampusEmail(campusEmail != null ? campusEmail : originalInfo.getCampusEmail());
        updatedInfo.setPersonalEmail(personalEmail != null ? personalEmail : originalInfo.getPersonalEmail());
        updatedInfo.setJoinPartyDate(joinPartyDate != null ? joinPartyDate : originalInfo.getJoinPartyDate());


        String jsonInfo = convertBasicInfoToJson(updatedInfo);

        // 将JSON格式的信息写入文件
        // 假设文件名为学号.json，保存在指定目录下
        String filePath = "D:/IdeaProjects/PostGraduateManageSystem/ChangInfoJson" + studentID + ".json";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(jsonInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
