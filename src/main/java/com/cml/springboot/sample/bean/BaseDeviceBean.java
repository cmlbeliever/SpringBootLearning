package com.cml.springboot.sample.bean;

import java.math.BigInteger;
import org.joda.time.DateTime;

public class BaseDeviceBean {
    /**
     * 微信生成的id
     */
    private BigInteger deviceId;

    private String memo;

    private String name;

    private String qrCodeUrl;

    private String mac;

    /**
     * 0 未注册
1 已注册
注册指已注册到微信
     */
    private Integer registerStatus;

    private DateTime createDate;

    private DateTime updateTime;

    public BigInteger getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(BigInteger deviceId) {
        this.deviceId = deviceId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Integer getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(Integer registerStatus) {
        this.registerStatus = registerStatus;
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