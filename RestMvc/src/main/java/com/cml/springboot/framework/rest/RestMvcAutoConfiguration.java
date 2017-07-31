package com.cml.springboot.framework.rest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
@Configuration
public class RestMvcAutoConfiguration {
	@Autowired
	RequestMappingHandlerMapping mapping;

	@PostConstruct
	public void config() throws Exception, SecurityException {
		RequestMappingInfo info = RequestMappingInfo.paths("/test/hh/name").mappingName("mine").build();
		mapping.registerMapping(info, new TestMvc(), TestMvc.class.getDeclaredMethod("testA", String.class));
		System.out.println("===========xxxxxxxxxxxxxxxxxxxxxxxxxxx==============");
	}
	//
	// @Bean
	// public RequestMappingHandlerMapping handlerMapping() throws Exception {
	// RequestMappingHandlerMapping mapping = new
	// RequestMappingHandlerMapping();
	// RequestMappingInfo info =
	// RequestMappingInfo.paths("/test/hh/name").mappingName("mine").build();
	// mapping.registerMapping(info, new TestMvc(),
	// TestMvc.class.getDeclaredMethod("testA", String.class));
	// System.out.println("===========xxxxxxxxxxxxxxxxxxxxxxxxxxx==============");
	// return mapping;
	// }
}
