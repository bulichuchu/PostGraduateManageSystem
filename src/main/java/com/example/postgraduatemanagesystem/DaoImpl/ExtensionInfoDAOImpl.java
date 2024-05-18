package com.example.postgraduatemanagesystem.DaoImpl;

import com.example.postgraduatemanagesystem.bean.ExtensionInfo;
import com.example.postgraduatemanagesystem.dao.ExtensionInfoDAO;

import java.sql.*;

public class ExtensionInfoDAOImpl implements ExtensionInfoDAO {
    String connectionUrl = "jdbc:sqlserver://fushuai.database.windows.net:1433;database=postgraduate;" +
            "user=fushuai@fushuai;password=Fzh123456789;encrypt=true;trustServerCertificate=false;" +
            "hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    @Override
    public ExtensionInfo getExtensionInfo(String userid) {
        ExtensionInfo extensionInfo = new ExtensionInfo();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            String sql = "SELECT * FROM ExtensionInfo WHERE StudentID=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userid);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                extensionInfo.setStudentID(rs.getInt("StudentID"));
                extensionInfo.setWxID(rs.getString("WxID"));
                extensionInfo.setQqID(rs.getString("QQID"));
                extensionInfo.setPhone(rs.getString("Phone"));
                extensionInfo.setAddress(rs.getString("Address"));
                extensionInfo.setPostCode(rs.getString("PostCode"));
                extensionInfo.setStudyUnit(rs.getString("StudyUnit"));
                extensionInfo.setUnitPhone(rs.getString("UnitPhone"));
                extensionInfo.setUnitPostCode(rs.getString("UnitPostCode"));
                extensionInfo.setUnitAddress(rs.getString("UnitAddress"));
                extensionInfo.setEmergencyContact(rs.getString("EmergencyContact"));
                extensionInfo.setEmergencyPhone(rs.getString("EmergencyPhone"));
                extensionInfo.setEmergencyPostCode(rs.getString("EmergencyPostCode"));
                extensionInfo.setEmergencyAddress(rs.getString("EmergencyAddress"));
                extensionInfo.setDormitoryAddress(rs.getString("DormitoryAddress"));
                extensionInfo.setDormitoryPhone(rs.getString("DormitoryPhone"));
                extensionInfo.setTechnicalPosition(rs.getString("TechnicalPosition"));
                extensionInfo.setAdministrativePositionLevel(rs.getString("AdministrativePositionLevel"));
                extensionInfo.setFamilyAddress(rs.getString("FamilyAddress"));
                extensionInfo.setFamilyPostCode(rs.getString("FamilyPostCode"));
                extensionInfo.setFamilyPhone(rs.getString("FamilyPhone"));
                extensionInfo.setFamilyContact(rs.getString("FamilyContact"));
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
        return extensionInfo;
    }
}
