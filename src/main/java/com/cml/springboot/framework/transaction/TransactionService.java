package com.cml.springboot.framework.transaction;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement()
public class TransactionService {

	@Resource
	private DataSource dataSource;

	@Bean(name = "txManager")
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource);
	}

}
