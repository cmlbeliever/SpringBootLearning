package com.cml.springboot.sample.bean;

import java.math.BigInteger;

public class BaseBatchJobInstanceBean {
    private BigInteger jobInstanceId;

    private BigInteger version;

    private String jobName;

    private String jobKey;

    public BigInteger getJobInstanceId() {
        return jobInstanceId;
    }

    public void setJobInstanceId(BigInteger jobInstanceId) {
        this.jobInstanceId = jobInstanceId;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobKey() {
        return jobKey;
    }

    public void setJobKey(String jobKey) {
        this.jobKey = jobKey;
    }
}