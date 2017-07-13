package com.cml.springboot.framework;

public interface Configuration {
	interface Status {
		int STATUS_OK = 1;
		int STATUS_FAIL = 2;
		int STATUS_INVALID_TOKEN = 3;
	}
}
