package com.cml.springboot.framework;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cml.springboot.filter.MyFilter;

@Configuration
public class FilterGlobalConfiguration {
	@Bean
	public FilterRegistrationBean myFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.addUrlPatterns("/*");
		registrationBean.setFilter(new MyFilter());
		registrationBean.setEnabled(true);
		return registrationBean;
	}

}
