package com.cml.springboot.sample.bean;

import java.math.BigInteger;

public class BaseBatchStepExecutionContextBean {
    private BigInteger stepExecutionId;

    private String shortContext;

    private String serializedContext;

    public BigInteger getStepExecutionId() {
        return stepExecutionId;
    }

    public void setStepExecutionId(BigInteger stepExecutionId) {
        this.stepExecutionId = stepExecutionId;
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