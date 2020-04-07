package com.easyway.covid19.model;

import java.util.Date;

public class UserSession {

    private Integer id;
    private String sessionToken;
    private Date sessionStartTime;
    private Date sessionExpiryTime;
    private Integer userInfoId;


    public UserSession() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public Date getSessionStartTime() {
        return sessionStartTime;
    }

    public void setSessionStartTime(Date sessionStartTime) {
        this.sessionStartTime = sessionStartTime;
    }

    public Date getSessionExpiryTime() {
        return sessionExpiryTime;
    }

    public void setSessionExpiryTime(Date sessionExpiryTime) {
        this.sessionExpiryTime = sessionExpiryTime;
    }

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }


    @Override
    public String toString() {
        return "UserSession{" +
                "id=" + id +
                ", sessionToken='" + sessionToken + '\'' +
                ", sessionStartTime=" + sessionStartTime +
                ", sessionExpiryTime=" + sessionExpiryTime +
                ", userInfoId=" + userInfoId +
                '}';
    }
}

