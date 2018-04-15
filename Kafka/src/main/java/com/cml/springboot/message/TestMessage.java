package com.cml.springboot.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestMessage {
	private int code;
	private String value;

	public TestMessage() {
		super();
	}

	@JsonCreator
	public TestMessage(@JsonProperty("id") int code, @JsonProperty("value") String value) {
		super();
		this.code = code;
		this.value = value;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "TestMessage [code=" + code + ", value=" + value + "]";
	}

}
