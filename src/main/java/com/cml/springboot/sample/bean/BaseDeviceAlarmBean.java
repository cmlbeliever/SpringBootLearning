package com.cml.springboot.sample.bean;

import java.math.BigInteger;
import org.joda.time.DateTime;

public class BaseDeviceAlarmBean {
    private BigInteger id;

    /**
     * 微信生成的id
     */
    private BigInteger deviceId;

    private DateTime alarmTime;

    /**
     * 1、有姿势不正确
2、用时太长
3、光线太暗
     */
    private Integer alarmType;

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

    public DateTime getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(DateTime alarmTime) {
        this.alarmTime = alarmTime;
    }

    public Integer getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(Integer alarmType) {
        this.alarmType = alarmType;
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