package com.cml.springboot.framework.transaction;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cml.springboot.framework.db.DynamicDataSourceAutoConfiguration.DynamicDataSource;

@Configuration
@EnableTransactionManagement()
public class TransactionService {

	@Resource
	private DynamicDataSource dataSource;

	@Bean(name = "txManager")
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource);
	}

}
