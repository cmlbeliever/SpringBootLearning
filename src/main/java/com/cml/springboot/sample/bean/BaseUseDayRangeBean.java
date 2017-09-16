package com.cml.springboot.sample.bean;

import java.math.BigInteger;
import org.joda.time.DateTime;

public class BaseUseDayRangeBean {
    private BigInteger id;

    /**
     * 微信生成的id
     */
    private BigInteger deviceId;

    /**
     * 日期 yyyyMMdd 
     */
    private String day;

    private BigInteger totalTime;

    private Integer dayRange;

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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public BigInteger getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(BigInteger totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getDayRange() {
        return dayRange;
    }

    public void setDayRange(Integer dayRange) {
        this.dayRange = dayRange;
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