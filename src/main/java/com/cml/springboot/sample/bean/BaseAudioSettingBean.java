package com.cml.springboot.sample.bean;

import java.math.BigInteger;

public class BaseAudioSettingBean {
    /**
     * 微信生成的id
     */
    private BigInteger deviceId;

    private Integer posture;

    private Integer timeSpan;

    private Integer envLight;

    public BigInteger getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(BigInteger deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getPosture() {
        return posture;
    }

    public void setPosture(Integer posture) {
        this.posture = posture;
    }

    public Integer getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(Integer timeSpan) {
        this.timeSpan = timeSpan;
    }

    public Integer getEnvLight() {
        return envLight;
    }

    public void setEnvLight(Integer envLight) {
        this.envLight = envLight;
    }
}