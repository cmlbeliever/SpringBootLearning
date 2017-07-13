package com.cml.springboot.framework.response;

public class BaseResponse {
	private Integer code;
	private String message;

	public BaseResponse() {
	}

	public BaseResponse(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
