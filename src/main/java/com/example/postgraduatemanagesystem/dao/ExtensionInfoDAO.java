package com.example.postgraduatemanagesystem.dao;

import com.example.postgraduatemanagesystem.bean.ExtensionInfo;

public interface ExtensionInfoDAO {
    ExtensionInfo getExtensionInfo(String userid);
    boolean updateExtensionInfo(ExtensionInfo updatedInfo);
}