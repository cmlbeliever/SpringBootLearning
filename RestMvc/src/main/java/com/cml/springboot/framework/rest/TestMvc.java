package com.cml.springboot.framework.rest;

import org.springframework.web.bind.annotation.ResponseBody;

@RestMvcTesst
public class TestMvc {
	@ResponseBody
	public String testA(String name) {
		return "dddd" + name;
	}
}
