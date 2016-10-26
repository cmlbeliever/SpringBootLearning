package com.cml.springboot.framework.mybatis;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {

	@Resource(name = "dataSourceProperties")
	private DefaultDataSourceProperties properties;

	@Bean(destroyMethod = "close", name = "dataSource")
	public DataSource dataSource() {
		System.out.println("=========>" + properties);
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(properties.driverClassName);
		dataSource.setUrl(properties.url);
		dataSource.setUsername(properties.username);
		dataSource.setPassword(properties.password);
		dataSource.setMaxIdle(properties.maxIdle);
		dataSource.setMaxActive(properties.maxActive);
		dataSource.setMaxWait(properties.maxWait);
		dataSource.setInitialSize(properties.initialSize);
		dataSource.setValidationQuery(properties.validationQuery);
		return dataSource;
	}
}
