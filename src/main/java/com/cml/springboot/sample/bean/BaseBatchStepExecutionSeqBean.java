package com.cml.springboot.sample.bean;

import java.math.BigInteger;

public class BaseBatchStepExecutionSeqBean {
    private BigInteger id;

    private String uniqueKey;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }
}