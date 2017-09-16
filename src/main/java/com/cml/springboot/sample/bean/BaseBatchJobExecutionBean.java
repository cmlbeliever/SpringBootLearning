package com.cml.springboot.sample.bean;

import java.math.BigInteger;
import org.joda.time.DateTime;

public class BaseBatchJobExecutionBean {
    private BigInteger jobExecutionId;

    private BigInteger version;

    private BigInteger jobInstanceId;

    private DateTime createTime;

    private DateTime startTime;

    private DateTime endTime;

    private String status;

    private String exitCode;

    private String exitMessage;

    private DateTime lastUpdated;

    private String jobConfigurationLocation;

    public BigInteger getJobExecutionId() {
        return jobExecutionId;
    }

    public void setJobExecutionId(BigInteger jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public BigInteger getJobInstanceId() {
        return jobInstanceId;
    }

    public void setJobInstanceId(BigInteger jobInstanceId) {
        this.jobInstanceId = jobInstanceId;
    }

    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExitCode() {
        return exitCode;
    }

    public void setExitCode(String exitCode) {
        this.exitCode = exitCode;
    }

    public String getExitMessage() {
        return exitMessage;
    }

    public void setExitMessage(String exitMessage) {
        this.exitMessage = exitMessage;
    }

    public DateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(DateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getJobConfigurationLocation() {
        return jobConfigurationLocation;
    }

    public void setJobConfigurationLocation(String jobConfigurationLocation) {
        this.jobConfigurationLocation = jobConfigurationLocation;
    }
}