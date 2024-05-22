package com.example.postgraduatemanagesystem.dao;
import com.example.postgraduatemanagesystem.bean.BasicInfo;

public interface BasicInfoDAO {
    BasicInfo getBasicInfo(String userid);

    boolean updateBasicInfo(BasicInfo updatedInfo);
}
