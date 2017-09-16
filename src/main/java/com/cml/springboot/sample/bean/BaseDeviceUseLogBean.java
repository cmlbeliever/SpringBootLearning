package com.cml.springboot.sample.bean;

import java.math.BigInteger;
import org.joda.time.DateTime;

public class BaseDeviceUseLogBean {
    private BigInteger id;

    /**
     * 微信生成的id
     */
    private BigInteger deviceId;

    private DateTime startTime;

    private DateTime endTime;

    private BigInteger spendTime;

    private DateTime createDate;

    private DateTime updateTime;

    private Integer detailHandleStatus;

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

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public BigInteger getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(BigInteger spendTime) {
        this.spendTime = spendTime;
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

    public Integer getDetailHandleStatus() {
        return detailHandleStatus;
    }

    public void setDetailHandleStatus(Integer detailHandleStatus) {
        this.detailHandleStatus = detailHandleStatus;
    }
}