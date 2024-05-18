package com.example.postgraduatemanagesystem.DaoImpl;

import com.example.postgraduatemanagesystem.bean.EducationExperience;
import com.example.postgraduatemanagesystem.bean.WorkExperience;
import com.example.postgraduatemanagesystem.dao.EducationExperienceDAO;

import java.sql.*;

public class EducationExperienceDAOImpl implements EducationExperienceDAO {
    String connectionUrl = "jdbc:sqlserver://fushuai.database.windows.net:1433;database=postgraduate;" +
            "user=fushuai@fushuai;password=Fzh123456789;encrypt=true;trustServerCertificate=false;" +
            "hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    @Override
    public EducationExperience getEducationExperience(String userid) {
        EducationExperience educationExperience = new EducationExperience();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            String sql = "SELECT * FROM EducationExperience WHERE StudentID=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userid);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                educationExperience.setStudentID(rs.getInt("StudentID"));
                educationExperience.setSchoolName(rs.getString("SchoolName"));
                educationExperience.setStartTime(rs.getDate("startTime"));
                educationExperience.setEndTime(rs.getDate("endTime"));
                educationExperience.setMajor(rs.getString("major"));
                educationExperience.setMajorDescription(rs.getString("majorDescription"));
                educationExperience.setDegree(rs.getString("degree"));
                educationExperience.setDegreeType(rs.getString("degreeType"));
                educationExperience.setGraduatePosition(rs.getString("graduatePosition"));
                educationExperience.setRestTime(rs.getString("restTime"));
                educationExperience.setIsGraduate(rs.getString("isGraduate"));

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
        return educationExperience;
    }
}
