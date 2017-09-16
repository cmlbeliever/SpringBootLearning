package com.cml.springboot.sample.bean;

import java.math.BigInteger;
import org.joda.time.DateTime;

public class BaseDeviceUseLogDetailBean {
    private BigInteger useLogId;

    /**
     * 微信生成的id
     */
    private BigInteger deviceId;

    /**
     * yyyyMMdd
     */
    private String useDate;

    /**
     * 单位 s
     */
    private BigInteger spendTime;

    private DateTime createDate;

    private DateTime updateTime;

    public BigInteger getUseLogId() {
        return useLogId;
    }

    public void setUseLogId(BigInteger useLogId) {
        this.useLogId = useLogId;
    }

    public BigInteger getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(BigInteger deviceId) {
        this.deviceId = deviceId;
    }

    public String getUseDate() {
        return useDate;
    }

    public void setUseDate(String useDate) {
        this.useDate = useDate;
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
}