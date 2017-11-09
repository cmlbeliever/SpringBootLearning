package com.cml.learn.jpa.framework.db;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@EnableJpaRepositories(value = "com.cml.learn.jpa.db.write", entityManagerFactoryRef = "writeEntityManagerFactory", transactionManagerRef = "writeTransactionManager")
@Configuration
public class WriteDbConfig {

	// @Autowired
	// JpaProperties jpaProperties;

	@Autowired
	@Qualifier("writeableDataSource")
	private DataSource writeDataSource;

	@Primary
	@Bean(name = "writeableDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource writeDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setRemoveAbandoned(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setTimeBetweenEvictionRunsMillis(30000);
		dataSource.setNumTestsPerEvictionRun(30);
		dataSource.setMinEvictableIdleTimeMillis(1800000);
		return dataSource;
	}

	@Primary
	@Bean("writeTransactionManager")
	PlatformTransactionManager writeTransactionManager() {
		return new JpaTransactionManager(writeEntityManagerFactory().getObject());
	}

	@Bean
	LocalContainerEntityManagerFactoryBean writeEntityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(false);
		vendorAdapter.setShowSql(true);
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLInnoDBDialect");
		// vendorAdapter.setDatabasePlatform("org.springframework.boot.orm.jpa.hibernate.SpringJtaPlatform");

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(writeDataSource);
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan("com.cml.learn.jpa.db.bean", "com.cml.learn.jpa.dto");

		Map<String, Object> jpaProperties = new HashMap<>();
		jpaProperties.put("hibernate.physical_naming_strategy", new SpringPhysicalNamingStrategy());
		jpaProperties.put("hibernate.implicit_naming_strategy", new SpringImplicitNamingStrategy());
		factoryBean.setJpaPropertyMap(jpaProperties);

		factoryBean.setJpaDialect(new HibernateJpaDialect());

		return factoryBean;
	}
}
