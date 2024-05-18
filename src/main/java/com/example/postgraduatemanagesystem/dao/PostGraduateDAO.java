package com.example.postgraduatemanagesystem.dao;


public interface PostGraduateDAO {
    boolean changePassword(String userid, String newPassword);
    boolean changeLoginStatus(String userid, String Password);
}