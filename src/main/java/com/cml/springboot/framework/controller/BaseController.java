package com.cml.springboot.framework.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import com.cml.springboot.framework.Configuration;

public class BaseController {

	public static final int SUCCESS = Configuration.Status.STATUS_OK;
	public static final int FAIL = Configuration.Status.STATUS_FAIL;

	public static String getAllErrors(Errors errors) {
		StringBuilder builder = new StringBuilder();
		for (ObjectError error : errors.getAllErrors()) {
			builder.append(error.getDefaultMessage()).append("\n");
		}
		return builder.toString();
	}
}
