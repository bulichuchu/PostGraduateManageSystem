package com.example.postgraduatemanagesystem.servlet;

import com.example.postgraduatemanagesystem.bean.BasicInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serial;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/changeInfoServlet")
public class ChangeInfoServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    // 将 BasicInfo 对象转换为JSON格式的方法
    private String convertBasicInfoToJson(BasicInfo info) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取表单提交的修改信息
        String studentID = request.getParameter("studentID");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String name = request.getParameter("name");
        String namePY = request.getParameter("namePY");
        String gender = request.getParameter("gender");
        String nation = request.getParameter("nation");
        Date birthDate;
        try {
            birthDate = sdf.parse(request.getParameter("birthDate"));
        } catch (
                ParseException e) {
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
        String departmentID = request.getParameter("departmentID");
        Date joinPartyDate;
        try {
            joinPartyDate = sdf.parse(request.getParameter("joinPartyDate"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // 创建BasicInfo对象并设置修改后的信息
        BasicInfo updatedInfo = new BasicInfo();
        updatedInfo.setStudentID(Integer.parseInt(studentID));
        updatedInfo.setName(name);
        updatedInfo.setNamePY(namePY);
        updatedInfo.setGender(gender);
        updatedInfo.setNation(nation);
        updatedInfo.setBirthDate(birthDate);
        updatedInfo.setNativePlace(nativePlace);
        updatedInfo.setPoliticalStatus(politicalStatus);
        updatedInfo.setIDNumber(IDNumber);
        updatedInfo.setIDType(IDType);
        updatedInfo.setMaritalStatus(maritalStatus);
        updatedInfo.setBirthPlace(birthPlace);
        updatedInfo.setFamilyAddress(familyAddress);
        updatedInfo.setPhoneNumber(phoneNumber);
        updatedInfo.setCampusEmail(campusEmail);
        updatedInfo.setDepartmentID(departmentID);
        updatedInfo.setJoinPartyDate(joinPartyDate);


        String jsonInfo = convertBasicInfoToJson(updatedInfo);

        // 将JSON格式的信息写入文件
        // 假设文件名为学号.json，保存在指定目录下
        String filePath = "C:\\Users\\yx\\IdeaProjects\\PostGraduateManageSystem\\ChangInfoJson\\" + studentID + ".json";
        try (
                FileWriter writer = new FileWriter(filePath)) {
            writer.write(jsonInfo);
            System.out.println("123");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 返回修改成功信息
        response.getWriter().write("修改成功！");
        request.getRequestDispatcher("QueryChange.jsp").forward(request, response);
    }
}
