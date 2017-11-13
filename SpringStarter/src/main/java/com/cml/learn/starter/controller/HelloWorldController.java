package com.cml.learn.starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cml.learn.starter.framework.MyLog;
import com.cml.learn.starter.framework.MyLogScanner;
import com.cml.learn.starter.service.MyLogService;

@RequestMapping("/")
@Controller
public class HelloWorldController {

	@Autowired
	private MyLogService logService;

	@RequestMapping
	@ResponseBody
	public String helloWorld() {
		logService.logStart("hello world!!!");
		return logService.logEnd("log end!!!");
	}
}
