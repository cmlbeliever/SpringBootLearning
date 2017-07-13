package com.cml.springboot.sample.bean;

import java.math.BigInteger;

import org.joda.time.DateTime;

public class LogBean {
	private BigInteger id;

	private String idStr;

	private Integer callDay;

	private String callDayStr;

	private String parameters;

	private String parametersStr;

	private Integer returnStatusCode;

	private String returnStatusCodeStr;

	private String returns;

	private String returnsStr;

	private String apiUrl;

	private String createDateStr;
	private DateTime createDate;

	private String updateDateStr;

	public DateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(DateTime createDate) {
		this.createDate = createDate;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getIdStr() {
		return idStr;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	public Integer getCallDay() {
		return callDay;
	}

	public void setCallDay(Integer callDay) {
		this.callDay = callDay;
	}

	public String getCallDayStr() {
		return callDayStr;
	}

	public void setCallDayStr(String callDayStr) {
		this.callDayStr = callDayStr;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public String getParametersStr() {
		return parametersStr;
	}

	public void setParametersStr(String parametersStr) {
		this.parametersStr = parametersStr;
	}

	public Integer getReturnStatusCode() {
		return returnStatusCode;
	}

	public void setReturnStatusCode(Integer returnStatusCode) {
		this.returnStatusCode = returnStatusCode;
	}

	public String getReturnStatusCodeStr() {
		return returnStatusCodeStr;
	}

	public void setReturnStatusCodeStr(String returnStatusCodeStr) {
		this.returnStatusCodeStr = returnStatusCodeStr;
	}

	public String getReturns() {
		return returns;
	}

	public void setReturns(String returns) {
		this.returns = returns;
	}

	public String getReturnsStr() {
		return returnsStr;
	}

	public void setReturnsStr(String returnsStr) {
		this.returnsStr = returnsStr;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getCreateDateStr() {
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public String getUpdateDateStr() {
		return updateDateStr;
	}

	public void setUpdateDateStr(String updateDateStr) {
		this.updateDateStr = updateDateStr;
	}

}
