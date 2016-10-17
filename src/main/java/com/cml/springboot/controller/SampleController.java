package com.cml.springboot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;

@Controller()
@EnableAutoConfiguration
@ServletComponentScan(basePackages="com.cml.springboot")
public class SampleController {

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
		return registration;
	}

//	@Bean
//	public FilterRegistrationBean filterRegistration(Filter filter) {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(filter);
//		// registration.getUrlMappings().clear();
//		// registration.addUrlMappings("*.do");
//		// registration.addUrlMappings("*.json");
//		return registration;
//	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleController.class, args);
	}
}