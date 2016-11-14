package com.cml.springboot.framework.shiro;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:shiro/shiro.properties")
@ConfigurationProperties(prefix = "shiro")
public class ShiroConfigProperties {
	private String loginUrl;
	private String loginSuccess;
	private String unauthorized;
	private Map<String, String> filters;

	public Map<String, String> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, String> filters) {
		this.filters = filters;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getLoginSuccess() {
		return loginSuccess;
	}

	public void setLoginSuccess(String loginSuccess) {
		this.loginSuccess = loginSuccess;
	}

	public String getUnauthorized() {
		return unauthorized;
	}

	public void setUnauthorized(String unauthorized) {
		this.unauthorized = unauthorized;
	}

}
