package com.cml.springboot.sample.bean;

import java.math.BigInteger;

public class BaseBatchJobExecutionContextBean {
    private BigInteger jobExecutionId;

    private String shortContext;

    private String serializedContext;

    public BigInteger getJobExecutionId() {
        return jobExecutionId;
    }

    public void setJobExecutionId(BigInteger jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }

    public String getShortContext() {
        return shortContext;
    }

    public void setShortContext(String shortContext) {
        this.shortContext = shortContext;
    }

    public String getSerializedContext() {
        return serializedContext;
    }

    public void setSerializedContext(String serializedContext) {
        this.serializedContext = serializedContext;
    }
}