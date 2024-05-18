package com.example.postgraduatemanagesystem.bean;

import java.io.Serializable;

public class User implements Serializable {
    private String UserID;
    private String username;
    private String password;
    private String role;
    private String isfirstlogin;

    public User() {
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIsfirstlogin() {
        return isfirstlogin;
    }

    public void setIsfirstlogin(String isfirstlogin) {
        this.isfirstlogin = isfirstlogin;
    }
}
