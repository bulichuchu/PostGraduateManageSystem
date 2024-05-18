package com.example.postgraduatemanagesystem.DaoImpl;

import com.example.postgraduatemanagesystem.bean.AdmissionInfo;
import com.example.postgraduatemanagesystem.dao.AdmissionInfoDAO;

import java.sql.PreparedStatement;
import java.sql.*;

public class AdmissionInfoDAOImpl implements AdmissionInfoDAO {
    String connectionUrl = "jdbc:sqlserver://fushuai.database.windows.net:1433;database=postgraduate;" +
            "user=fushuai@fushuai;password=Fzh123456789;encrypt=true;trustServerCertificate=false;" +
            "hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    @Override
    public AdmissionInfo getAdmissionInfo(String userid) {
        AdmissionInfo admissionInfo = new AdmissionInfo();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            String sql = "SELECT * FROM AdmissionInfo WHERE StudentID=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userid);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                admissionInfo.setStudentID(rs.getInt("StudentID"));
                admissionInfo.setEnrollmentYear(rs.getInt("EnrollmentYear"));
                admissionInfo.setCandidateID(rs.getInt("CandidateID"));
                admissionInfo.setApplicationCategory(rs.getString("ApplicationCategory"));
                admissionInfo.setCandidateSource(rs.getString("CandidateSource"));
                admissionInfo.setAdmissionCategory(rs.getString("AdmissionCategory"));
                admissionInfo.setExaminationMethods(rs.getString("ExaminationMethods"));
                admissionInfo.setReturnStatus(rs.getString("ReturnStatus"));
                admissionInfo.setRetentionQualificationYears(rs.getInt("RetentionQualificationYears"));
                admissionInfo.setTargetedTrainingUnits(rs.getString("TargetedTrainingUnits"));
                admissionInfo.setTargetedTrainingUnitsPlace(rs.getString("TargetedTrainingUnitsPlace"));
                admissionInfo.setRecommendedUnit(rs.getString("RecommendedUnit"));
                admissionInfo.setFinalGraduationSchool(rs.getString("FinalGraduationSchool"));
                admissionInfo.setFinalGraduationSchoolName(rs.getString("FinalGraduationSchoolName"));
                admissionInfo.setFinalGraduationMajor(rs.getString("FinalGraduationMajor"));
                admissionInfo.setFinalGraduationMajorName(rs.getString("FinalGraduationMajorName"));
                admissionInfo.setLastDegreeUnit(rs.getString("LastDegreeUnit"));
                admissionInfo.setFinalGraduationCertificateNumber(rs.getString("FinalGraduationCertificateNumber"));
                admissionInfo.setFinalEducation(rs.getString("FinalEducation"));
                admissionInfo.setFinalDegree(rs.getString("FinalDegree"));
                admissionInfo.setFinalGraduationDate(rs.getString("FinalGraduationDate"));
                admissionInfo.setFinalDegreeDate(rs.getString("FinalDegreeDate"));
                admissionInfo.setFinalAcademicLearningForm(rs.getString("FinalAcademicLearningForm"));

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
        return admissionInfo;
    }
}