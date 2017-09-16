package com.cml.springboot.sample.bean;

import org.joda.time.DateTime;

public class BaseAccessTokenBean {
    private String accessToken;

    private DateTime expireTime;

    private DateTime createDate;

    private DateTime updateTime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public DateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(DateTime expireTime) {
        this.expireTime = expireTime;
    }

    public DateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(DateTime createDate) {
        this.createDate = createDate;
    }

    public DateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(DateTime updateTime) {
        this.updateTime = updateTime;
    }
}