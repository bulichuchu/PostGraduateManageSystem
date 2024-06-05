package com.example.postgraduatemanagesystem.servlet;

import com.example.postgraduatemanagesystem.DaoImpl.BasicInfoDAOImpl;
import com.example.postgraduatemanagesystem.bean.BasicInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProcessReviewedInfoServlet")
public class ProcessReviewedInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<BasicInfo> infoList = (List<BasicInfo>) session.getAttribute("infoList");
        String studentID = String.valueOf(infoList.get(0).getStudentID());
        String directoryPath = "D:/IdeaProjects/PostGraduateManageSystem/ChangInfoJson/";
        BasicInfoDAOImpl basicInfoDAO = new BasicInfoDAOImpl();
        boolean updateSuccess = true;

        for (BasicInfo info : infoList) {
            if (basicInfoDAO.updateBasicInfo(info)) {
                File file = new File(directoryPath + studentID + ".json");
                if (file.exists()) {
                    file.delete();
                }
            } else {
                updateSuccess = false;
                break;
            }
        }
        session.setAttribute("updateSuccess", updateSuccess);
        // 重定向到审核信息页面
        response.sendRedirect("reviewInfo.jsp");
    }
}
