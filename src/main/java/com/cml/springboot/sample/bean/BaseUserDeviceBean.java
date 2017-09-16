package com.cml.springboot.sample.bean;

import java.math.BigInteger;
import org.joda.time.DateTime;

public class BaseUserDeviceBean {
    private BigInteger id;

    /**
     * 微信生成的id
     */
    private BigInteger deviceId;

    private BigInteger userId;

    /**
     * 0 解绑
1 绑定
     */
    private Integer bindStatus;

    private DateTime bindTime;

    private DateTime createDate;

    private DateTime updateTime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(BigInteger deviceId) {
        this.deviceId = deviceId;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public Integer getBindStatus() {
        return bindStatus;
    }

    public void setBindStatus(Integer bindStatus) {
        this.bindStatus = bindStatus;
    }

    public DateTime getBindTime() {
        return bindTime;
    }

    public void setBindTime(DateTime bindTime) {
        this.bindTime = bindTime;
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