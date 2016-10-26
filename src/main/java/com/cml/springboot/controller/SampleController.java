package com.cml.springboot.controller;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.DispatcherServlet;

public class SampleController {

	@RequestMapping("/upload")
	@ResponseBody
	public String upload(MultipartHttpServletRequest req) {
		MultipartFile file = req.getFile("file");
		System.out.println(file.getName());
		return file.getName();
	}

	@RequestMapping("/upload2")
	@ResponseBody
	public String upload2(@RequestParam(name = "file2", required = true) MultipartFile file) {
		System.out.println(file.getName());
		return file.getName();
	}

	@RequestMapping("/test")
	public String test() {
		System.out.println("test");
		return "test";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		System.out.println("test");
		return "welcome";
	}

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	// @Bean
	public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
		registration.getUrlMappings().clear();
		registration.addUrlMappings("*.do");
		registration.addUrlMappings("*.json");
		// WebMvcAutoConfiguration
		return registration;
	}

}