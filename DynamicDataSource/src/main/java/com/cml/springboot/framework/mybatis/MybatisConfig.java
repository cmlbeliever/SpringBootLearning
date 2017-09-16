package com.cml.springboot.framework.mybatis;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

@Configuration
public class MybatisConfig {

	protected static Log log = LogFactory.getLog(MybatisConfig.class);

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(DataSource datasource, MybatisConfigurationProperties properties)
			throws Exception {

		log.info("*************************sqlSessionFactory:begin***********************" + properties);

		VFS.addImplClass(SpringBootVFS.class);

		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(datasource);
		sessionFactory.setTypeAliasesPackage(properties.typeAliasesPackage);
		sessionFactory.setTypeHandlersPackage(properties.typeHandlerPackage);

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(resolver.getResources(properties.mapperLocations));

		// sessionFactory
		// .setConfigLocation(new
		// PathMatchingResourcePatternResolver().getResource(properties.configLocation));

		SqlSessionFactory resultSessionFactory = sessionFactory.getObject();

		log.info("*************************sqlSessionFactory:successs:" + resultSessionFactory
				+ "***********************" + properties);

		return resultSessionFactory;

	}

	@Bean(destroyMethod = "close", name = "dataSource")
	public DataSource dataSource(DataSourceProperties properties) {

		log.info("*************************dataSource***********************");

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
