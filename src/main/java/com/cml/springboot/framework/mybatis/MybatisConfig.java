package com.cml.springboot.framework.mybatis;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

@Configuration
@MapperScan(basePackages = "com.cml.springboot", sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig {

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(DataSource datasource, MybatisConfigurationProperties properties)
			throws Exception {

		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(datasource);
		sessionFactory.setTypeAliasesPackage(properties.typeAliasesPackage);
		sessionFactory.setTypeHandlersPackage(properties.typeHandlerPackage);

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(resolver.getResources(properties.mapperLocations));

		return sessionFactory.getObject();
	}

	@Bean(destroyMethod = "close", name = "dataSource")
	public DataSource dataSource(DataSourceProperties properties) {
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
		dataSource.setRemoveAbandoned(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setTimeBetweenEvictionRunsMillis(30000);
		dataSource.setNumTestsPerEvictionRun(30);
		dataSource.setMinEvictableIdleTimeMillis(1800000);
		return dataSource;
	}

	@ConfigurationProperties(prefix = "db.mybatis")
	@Component
	private static class MybatisConfigurationProperties {
		private String typeAliasesPackage;
		private String typeHandlerPackage;
		private String mapperLocations;

		public String getTypeAliasesPackage() {
			return typeAliasesPackage;
		}

		public void setTypeAliasesPackage(String typeAliasesPackage) {
			this.typeAliasesPackage = typeAliasesPackage;
		}

		public String getTypeHandlerPackage() {
			return typeHandlerPackage;
		}

		public void setTypeHandlerPackage(String typeHandlerPackage) {
			this.typeHandlerPackage = typeHandlerPackage;
		}

		public String getMapperLocations() {
			return mapperLocations;
		}

		public void setMapperLocations(String mapperLocations) {
			this.mapperLocations = mapperLocations;
		}

	}

	@Component("dataSourceProperties")
	@ConfigurationProperties(prefix = "db.mybatis.jdbc")
	public static class DataSourceProperties {
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
			return "DataSourceProperties [driverClassName=" + driverClassName + ", url=" + url + ", username="
					+ username + ", password=" + password + ", maxActive=" + maxActive + ", maxIdle=" + maxIdle
					+ ", minIdle=" + minIdle + ", maxWait=" + maxWait + ", initialSize=" + initialSize
					+ ", validationQuery=" + validationQuery + "]";
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

}
