package com.cml.springboot.framework.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class BaseController {
	public static String getAllErrors(Errors errors) {
		StringBuilder builder = new StringBuilder();
		for (ObjectError error : errors.getAllErrors()) {
			builder.append(error.getDefaultMessage()).append("\n");
		}
		return builder.toString();
	}
}
