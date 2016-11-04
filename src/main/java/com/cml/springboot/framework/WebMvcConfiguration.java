package com.cml.springboot.framework;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.WebMvcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class WebMvcConfiguration {

	private WebMvcProperties mvcProperties;
	private ResourceProperties resourceProperties;

	public WebMvcConfiguration(WebMvcProperties mvcProperties, ResourceProperties resourceProperties) {
		super();
		this.mvcProperties = mvcProperties;
		this.resourceProperties = resourceProperties;
	}

	/**
	 * 自定义viewResolver
	 * 
	 * @return
	 */
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix(mvcProperties.getView().getPrefix());
		resolver.setSuffix(mvcProperties.getView().getSuffix());
		return resolver;
	}
}
