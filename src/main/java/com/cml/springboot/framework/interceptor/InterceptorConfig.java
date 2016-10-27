package com.cml.springboot.framework.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private ParamInterceptor paramInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(paramInterceptor).addPathPatterns("/*");
		super.addInterceptors(registry);
	}

//	@Override
//	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//
//		ThreadPoolTaskExecutor ex = new ThreadPoolTaskExecutor();
//		ex.setCorePoolSize(5);
//		ex.setMaxPoolSize(500);
//
//		configurer.setTaskExecutor(ex);
//
//		System.out.println("====InterceptorConfig.configureAsyncSupport==================");
//	}

}
