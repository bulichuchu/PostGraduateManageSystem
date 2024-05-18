package com.example.postgraduatemanagesystem.dao;

import com.example.postgraduatemanagesystem.bean.ExtensionInfo;
import com.example.postgraduatemanagesystem.bean.WorkExperience;

public interface WorkExperienceDAO {
    WorkExperience getWorkExperience(String userid);
}

