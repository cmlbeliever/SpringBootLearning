package com.cml.springboot.framework.mybatis;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

/**
 * 只读数据库配置
 * 
 * @author cml
 *
 */
@Configuration
public class MybatisRConfig {

	protected static Log log = LogFactory.getLog(MybatisRConfig.class);

	@Bean(name = "readOnlySqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("readOnlyDataSource") DataSource readOnlyDataSource,
			@Qualifier("readOnlyConfiguration") MybatisConfigurationProperties readOnlyConfiguration) throws Exception {

		log.info("*************************sqlSessionFactory:begin***********************" + readOnlyConfiguration);

		VFS.addImplClass(SpringBootVFS.class);

		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(readOnlyDataSource);
		sessionFactory.setTypeAliasesPackage(readOnlyConfiguration.typeAliasesPackage);
		sessionFactory.setTypeHandlersPackage(readOnlyConfiguration.typeHandlerPackage);

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(resolver.getResources(readOnlyConfiguration.mapperLocations));

		// sessionFactory
		// .setConfigLocation(new
		// PathMatchingResourcePatternResolver().getResource(properties.configLocation));

		SqlSessionFactory resultSessionFactory = sessionFactory.getObject();

		log.info("*************************sqlSessionFactory:successs:" + resultSessionFactory
				+ "***********************" + readOnlyConfiguration);

		return resultSessionFactory;

	}

	@Bean(destroyMethod = "close", name = "readOnlyDataSource")
	public DataSource dataSource(@Qualifier("readOnlyDataSourceProperties") DataSourceProperties readOnlyDataSourceProperties) {

		log.info("*************************dataSource***********************");

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(readOnlyDataSourceProperties.driverClassName);
		dataSource.setUrl(readOnlyDataSourceProperties.url);
		dataSource.setUsername(readOnlyDataSourceProperties.username);
		dataSource.setPassword(readOnlyDataSourceProperties.password);
		dataSource.setMaxIdle(readOnlyDataSourceProperties.maxIdle);
		dataSource.setMaxActive(readOnlyDataSourceProperties.maxActive);
		dataSource.setMaxWait(readOnlyDataSourceProperties.maxWait);
		dataSource.setInitialSize(readOnlyDataSourceProperties.initialSize);
		dataSource.setValidationQuery(readOnlyDataSourceProperties.validationQuery);
		dataSource.setRemoveAbandoned(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setTimeBetweenEvictionRunsMillis(30000);
		dataSource.setNumTestsPerEvictionRun(30);
		dataSource.setMinEvictableIdleTimeMillis(1800000);
		return dataSource;
	}

	@ConfigurationProperties(prefix = "db.mybatis.r")
	@Component("readOnlyConfiguration")
	public static class MybatisConfigurationProperties {
		private String typeAliasesPackage;
		private String typeHandlerPackage;
		private String mapperLocations;
		private String configLocation;

		public String getConfigLocation() {
			return configLocation;
		}

		public void setConfigLocation(String configLocation) {
			this.configLocation = configLocation;
		}

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

		@Override
		public String toString() {
			return "MybatisConfigurationProperties [typeAliasesPackage=" + typeAliasesPackage + ", typeHandlerPackage="
					+ typeHandlerPackage + ", mapperLocations=" + mapperLocations + ", configLocation=" + configLocation
					+ "]";
		}

	}

	@Component("readOnlyDataSourceProperties")
	@ConfigurationProperties(prefix = "db.mybatis.r.jdbc")
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
