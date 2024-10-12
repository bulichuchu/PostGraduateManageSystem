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
        String action = request.getParameter("action");

        if (action != null) {
            String[] parts = action.split("_");
            String operation = parts[0]; // "approve" or "reject"
            String studentID = parts[1]; // student ID

            BasicInfoDAOImpl basicInfoDAO = new BasicInfoDAOImpl();
            BasicInfo infoToUpdate = null;
            for (BasicInfo info : infoList) {
                if (String.valueOf(info.getStudentID()).equals(studentID)) {
                    infoToUpdate = info;
                    break;
                }
            }

            if (infoToUpdate != null) {
                if ("approve".equals(operation)) {
                    if (basicInfoDAO.updateBasicInfo(infoToUpdate)) {
                        String directoryPath = "C:\\Users\\yx\\IdeaProjects\\PostGraduateManageSystem\\ChangInfoJson\\";
                        File file = new File(directoryPath + studentID + ".json");
                        if (file.exists()) {
                            file.delete();
                        }
                        session.setAttribute("updateSuccess", true);
                    } else {
                        session.setAttribute("updateSuccess", false);
                    }
                } else if ("reject".equals(operation)) {
                    // 处理不同意变更的逻辑，如果有需要的话
                    session.setAttribute("updateSuccess", false);
                }
            } else {
                session.setAttribute("updateSuccess", false);
            }
        } else {
            session.setAttribute("updateSuccess", false);
        }

        // 重新加载数据并返回审核页面
        response.sendRedirect("reviewInfo.jsp");
    }
}
