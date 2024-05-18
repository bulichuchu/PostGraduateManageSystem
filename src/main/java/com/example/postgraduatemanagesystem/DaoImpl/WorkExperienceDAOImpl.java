package com.example.postgraduatemanagesystem.DaoImpl;

import com.example.postgraduatemanagesystem.bean.ExtensionInfo;
import com.example.postgraduatemanagesystem.bean.WorkExperience;
import com.example.postgraduatemanagesystem.dao.ExtensionInfoDAO;
import com.example.postgraduatemanagesystem.dao.WorkExperienceDAO;

import java.sql.*;

public class WorkExperienceDAOImpl implements WorkExperienceDAO {
    String connectionUrl = "jdbc:sqlserver://fushuai.database.windows.net:1433;database=postgraduate;" +
            "user=fushuai@fushuai;password=Fzh123456789;encrypt=true;trustServerCertificate=false;" +
            "hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    @Override
    public WorkExperience getWorkExperience(String userid) {
        WorkExperience workExperience = new WorkExperience();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            String sql = "SELECT * FROM WorkExperience WHERE StudentID=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userid);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                workExperience.setStudentID(rs.getInt("StudentID"));
                workExperience.setStartTime(rs.getDate("startTime"));
                workExperience.setEndTime(rs.getDate("endTime"));
                workExperience.setWorkUnit(rs.getString("workUnit"));
                workExperience.setWorkPosition(rs.getString("workPosition"));
                workExperience.setWorkDuty(rs.getString("workDuty"));
                workExperience.setProvePerson(rs.getString("provePerson"));
                workExperience.setNotes(rs.getString("notes"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return workExperience;
    }
}
