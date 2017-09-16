package com.cml.springboot.sample.bean;

import java.math.BigInteger;
import org.joda.time.DateTime;

public class BaseWechatApiLogBean {
    private BigInteger id;

    private String param;

    private String result;

    /**
     * 1、微信
2、api
     */
    private Integer caller;

    private String resultStatus;

    private DateTime createDate;

    private DateTime updateTime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getCaller() {
        return caller;
    }

    public void setCaller(Integer caller) {
        this.caller = caller;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
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