package com.cml.springboot.sample.bean;

import java.math.BigInteger;
import org.joda.time.DateTime;

public class BaseBatchJobExecutionParamsBean {
    private BigInteger jobExecutionId;

    private String typeCd;

    private String keyName;

    private String stringVal;

    private DateTime dateVal;

    private BigInteger longVal;

    private Double doubleVal;

    private String identifying;

    public BigInteger getJobExecutionId() {
        return jobExecutionId;
    }

    public void setJobExecutionId(BigInteger jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getStringVal() {
        return stringVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }

    public DateTime getDateVal() {
        return dateVal;
    }

    public void setDateVal(DateTime dateVal) {
        this.dateVal = dateVal;
    }

    public BigInteger getLongVal() {
        return longVal;
    }

    public void setLongVal(BigInteger longVal) {
        this.longVal = longVal;
    }

    public Double getDoubleVal() {
        return doubleVal;
    }

    public void setDoubleVal(Double doubleVal) {
        this.doubleVal = doubleVal;
    }

    public String getIdentifying() {
        return identifying;
    }

    public void setIdentifying(String identifying) {
        this.identifying = identifying;
    }
}