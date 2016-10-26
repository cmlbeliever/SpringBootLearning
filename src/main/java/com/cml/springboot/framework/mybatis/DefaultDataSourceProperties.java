package com.cml.springboot.framework.mybatis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("dataSourceProperties")
@ConfigurationProperties(prefix = "db.mybatis.jdbc")
public class DefaultDataSourceProperties {
	public String driverClassName;
	public String url;
	public String username;
	public String password;
	public int maxActive;
	public int maxIdle;
	public int minIdle;
	public int maxWait;
	public int initialSize;
	public String validationQuery;

	@Override
	public String toString() {
		return "DataSourceProperties [driverClassName=" + driverClassName + ", url=" + url + ", username=" + username
				+ ", password=" + password + ", maxActive=" + maxActive + ", maxIdle=" + maxIdle + ", minIdle="
				+ minIdle + ", maxWait=" + maxWait + ", initialSize=" + initialSize + ", validationQuery="
				+ validationQuery + "]";
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}

}