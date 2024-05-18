package com.example.postgraduatemanagesystem.bean;
import java.io.Serializable;
import java.util.Date;

public class WorkExperience implements Serializable{
    private int studentID;
    private Date startTime;
    private Date endTime;
    private String workUnit;
    private String workPosition;
    private String workDuty;
    private String provePerson;
    private String notes;
    public WorkExperience() {
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    public String getWorkDuty() {
        return workDuty;
    }

    public void setWorkDuty(String workDuty) {
        this.workDuty = workDuty;
    }

    public String getProvePerson() {
        return provePerson;
    }

    public void setProvePerson(String provePerson) {
        this.provePerson = provePerson;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
