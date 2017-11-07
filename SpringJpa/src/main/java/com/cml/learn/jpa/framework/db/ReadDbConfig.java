package com.cml.learn.jpa.framework.db;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ReadDbConfig {

	@Bean(name = "readOnlayDataSource")
	@ConfigurationProperties(prefix = "spring.datasource2")
	public DataSource writeDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setRemoveAbandoned(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setTimeBetweenEvictionRunsMillis(30000);
		dataSource.setNumTestsPerEvictionRun(30);
		dataSource.setMinEvictableIdleTimeMillis(1800000);
		return dataSource;
	}
}
