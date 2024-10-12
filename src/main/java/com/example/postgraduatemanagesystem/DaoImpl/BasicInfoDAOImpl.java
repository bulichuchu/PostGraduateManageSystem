package com.example.postgraduatemanagesystem.DaoImpl;

import com.example.postgraduatemanagesystem.bean.BasicInfo;
import com.example.postgraduatemanagesystem.dao.BasicInfoDAO;

import java.sql.*;


public class BasicInfoDAOImpl implements BasicInfoDAO {
    String connectionUrl = "jdbc:sqlserver://fushuai.database.windows.net:1433;database=postgraduate;" +
            "user=fushuai@fushuai;password=Fzh123456789;encrypt=true;trustServerCertificate=false;" +
            "hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    @Override
    public BasicInfo getBasicInfo(String StudentID) {
        BasicInfo basicinfo = new BasicInfo();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            String sql = "SELECT * FROM BasicInfo WHERE StudentID=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, StudentID);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                basicinfo.setStudentID(rs.getInt("StudentID"));
                basicinfo.setName(rs.getString("Name"));
                basicinfo.setNamePY(rs.getString("Name_PY"));
                basicinfo.setGender(rs.getString("Gender"));
                basicinfo.setNation(rs.getString("nation"));
                basicinfo.setBirthDate(rs.getDate("BirthDate"));
                basicinfo.setNativePlace(rs.getString("native_place"));
                basicinfo.setPoliticalStatus(rs.getString("political_status"));
                basicinfo.setIDType(rs.getString("ID_type"));
                basicinfo.setIDNumber(rs.getString("ID_number"));
                basicinfo.setCountry(rs.getString("country"));
                basicinfo.setMaritalStatus(rs.getString("marital_status"));
                basicinfo.setBirthPlace(rs.getString("BirthPlace"));
                basicinfo.setOriginPlace(rs.getString("origin_place"));
                basicinfo.setFamilyAddress(rs.getString("family_address"));
                basicinfo.setHuKouPlace(rs.getString("HuKou_place"));
                basicinfo.setHuKouDetailedPlace(rs.getString("HuKou_detailed_place"));
                basicinfo.setHuKouPostalCode(rs.getString("HuKou_postal_code"));
                basicinfo.setRailwayStationStart(rs.getString("Railway_Station_start"));
                basicinfo.setRailwayStationEnd(rs.getString("Railway_Station_end"));
                basicinfo.setPhoneNumber(rs.getString("phone_number"));
                basicinfo.setCampusEmail(rs.getString("campus_email"));
                basicinfo.setPersonalEmail(rs.getString("personal_email"));
                basicinfo.setJoinPartyDate(rs.getDate("Join_party_date"));
                basicinfo.setStudentLabel(rs.getString("student_label"));
                basicinfo.setDepartmentID(rs.getString("department_ID"));
                basicinfo.setAward(rs.getString("award"));
                basicinfo.setGrade(rs.getString("grade"));
                basicinfo.setEntranceSeason(rs.getString("entrance_season"));
                basicinfo.setCultivationLevel(rs.getString("Cultivation_level"));
                basicinfo.setStudentCategory(rs.getString("Student_category"));
                basicinfo.setCollege(rs.getString("college"));
                basicinfo.setManagementDepartment(rs.getString("management_department"));
                basicinfo.setMajor(rs.getString("major"));
                basicinfo.setLengthOfSchooling(rs.getString("length_of_schooling"));
                basicinfo.setEntranceMethod(rs.getString("entrance_method"));
                basicinfo.setCampusZone(rs.getString("campus_zone"));
                basicinfo.setEntranceDate(rs.getDate("entrance_date"));
                basicinfo.setStudentClass(rs.getString("class"));
                basicinfo.setEnrollmentMajor(rs.getString("Enrollment_major"));
                basicinfo.setDegreeCategory(rs.getString("Degree_Category"));
                basicinfo.setDegreeType(rs.getString("Degree_type"));
                basicinfo.setMajorWay(rs.getString("major_way"));
                basicinfo.setCultureMethod(rs.getString("culture_method"));
                basicinfo.setStudyMethod(rs.getString("study_method"));
                basicinfo.setJinXiuCategory(rs.getString("JinXiu_category"));
                basicinfo.setSpecialPlan(rs.getString("special_plan"));
                basicinfo.setExpectedGraduationTime(rs.getDate("Expected_graduation_time"));
                basicinfo.setJointTrainingUnit(rs.getString("Joint_Training_Unit"));
                basicinfo.setInterdisciplinary(rs.getString("interdisciplinary"));
                basicinfo.setOverseas(rs.getString("overseas"));
                basicinfo.setActualGraduationTime(rs.getDate("Actual_graduation_time"));
                basicinfo.setStudentStatus(rs.getString("Student_status"));
                basicinfo.setStudentStatusChangeStatus(rs.getString("Student_status_change_status"));
                basicinfo.setMentor(rs.getString("mentor"));
                basicinfo.setMentor2(rs.getString("mentor2"));
                basicinfo.setJointTrainingMentors(rs.getString("Joint_training_mentors"));
                basicinfo.setOnCampus(rs.getString("On_campus"));
                basicinfo.setResearchDirection(rs.getString("Research_Direction"));
                basicinfo.setRegistrationStatus(rs.getString("Registration_Status"));
                basicinfo.setPaymentStatus(rs.getString("Payment_status"));
                basicinfo.setDegrees(rs.getString("degrees"));
                basicinfo.setReceiveAcademicEducation(rs.getString("receive_academic_education"));
                basicinfo.setDegreeStatus(rs.getString("degree_status"));
                basicinfo.setProfessionalDegreeCategory(rs.getString("professional_degree_category"));
                basicinfo.setInterdisciplinaryTraining(rs.getString("Interdisciplinary_training"));
                basicinfo.setInterdisciplinaryTrainingDiscipline(rs.getString("Interdisciplinary_training_discipline"));
                basicinfo.setDateOfDegreeAward(rs.getDate("Date_of_degree_award"));
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
        return basicinfo;
    }

    @Override
    public boolean updateBasicInfo(BasicInfo updatedInfo) {
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            String sql = "UPDATE BasicInfo SET name = ?, gender = ?, BirthDate = ?, nation = ?, " +
                    "native_place = ?, political_status = ?, id_number = ?, id_type = ?, " +
                    "marital_status = ?, BirthPlace = ?, family_address = ?, phone_number = ?, " +
                    "campus_email = ?, personal_email = ?, join_party_date = ? WHERE StudentID = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, updatedInfo.getName());
            pstmt.setString(2, updatedInfo.getGender());
            pstmt.setDate(3, new Date(updatedInfo.getBirthDate().getTime()));
            pstmt.setString(4, updatedInfo.getNation());
            pstmt.setString(5, updatedInfo.getNativePlace());
            pstmt.setString(6, updatedInfo.getPoliticalStatus());
            pstmt.setString(7, updatedInfo.getIDNumber());
            pstmt.setString(8, updatedInfo.getIDType());
            pstmt.setString(9, updatedInfo.getMaritalStatus());
            pstmt.setString(10, updatedInfo.getBirthPlace());
            pstmt.setString(11, updatedInfo.getFamilyAddress());
            pstmt.setString(12, updatedInfo.getPhoneNumber());
            pstmt.setString(13, updatedInfo.getCampusEmail());
            pstmt.setString(14, updatedInfo.getPersonalEmail());
            pstmt.setDate(15, new Date(updatedInfo.getJoinPartyDate().getTime()));
            pstmt.setInt(16, updatedInfo.getStudentID());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
