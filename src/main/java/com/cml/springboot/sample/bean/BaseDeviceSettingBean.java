package com.cml.springboot.sample.bean;

import java.math.BigInteger;

public class BaseDeviceSettingBean {
    /**
     * 微信生成的id
     */
    private BigInteger deviceId;

    private String name;

    /**
     * cm
     */
    private Integer personDistance;

    /**
     * min
     */
    private Integer studySpan;

    /**
     * min
     */
    private Integer studyIdle;

    /**
     * lx
     */
    private Integer envLightAlarm;

    private Integer lightDiffAlarm;

    public BigInteger getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(BigInteger deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPersonDistance() {
        return personDistance;
    }

    public void setPersonDistance(Integer personDistance) {
        this.personDistance = personDistance;
    }

    public Integer getStudySpan() {
        return studySpan;
    }

    public void setStudySpan(Integer studySpan) {
        this.studySpan = studySpan;
    }

    public Integer getStudyIdle() {
        return studyIdle;
    }

    public void setStudyIdle(Integer studyIdle) {
        this.studyIdle = studyIdle;
    }

    public Integer getEnvLightAlarm() {
        return envLightAlarm;
    }

    public void setEnvLightAlarm(Integer envLightAlarm) {
        this.envLightAlarm = envLightAlarm;
    }

    public Integer getLightDiffAlarm() {
        return lightDiffAlarm;
    }

    public void setLightDiffAlarm(Integer lightDiffAlarm) {
        this.lightDiffAlarm = lightDiffAlarm;
    }
}