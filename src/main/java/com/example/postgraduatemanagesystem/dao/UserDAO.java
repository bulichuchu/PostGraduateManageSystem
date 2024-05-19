package com.example.postgraduatemanagesystem.dao;

import com.example.postgraduatemanagesystem.bean.User;

public interface UserDAO {
    boolean available(String username, String password);
    User getUser(String username, String password);
    User getUser(String userid);
}
