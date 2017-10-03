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

@Configuration
public class MybatisConfig {

	protected static Log log = LogFactory.getLog(MybatisConfig.class);

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource datasource,
			MybatisConfigurationProperties properties) throws Exception {

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

	@ConfigurationProperties(prefix = "db.mybatis.jdbc")
	@Bean(destroyMethod = "close", name = "write")
	public DataSource dataSourceWrite() {

		log.info("*************************dataSource***********************");

		BasicDataSource dataSource = new BasicDataSource();
		// dataSource.setDriverClassName(properties.driverClassName);
		// dataSource.setUrl(properties.url);
		// dataSource.setUsername(properties.username);
		// dataSource.setPassword(properties.password);
		// dataSource.setMaxIdle(properties.maxIdle);
		// dataSource.setMaxActive(properties.maxActive);
		// dataSource.setMaxWait(properties.maxWait);
		// dataSource.setInitialSize(properties.initialSize);
		// dataSource.setValidationQuery(properties.validationQuery);
		dataSource.setRemoveAbandoned(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setTimeBetweenEvictionRunsMillis(30000);
		dataSource.setNumTestsPerEvictionRun(30);
		dataSource.setMinEvictableIdleTimeMillis(1800000);
		return dataSource;
	}

	@ConfigurationProperties(prefix = "db.mybatis2.jdbc")
	@Bean(destroyMethod = "close", name = "read")
	public DataSource dataSourceRead() {

		log.info("*************************dataSource***********************");

		BasicDataSource dataSource = new BasicDataSource();
		// dataSource.setDriverClassName(properties.driverClassName);
		// dataSource.setUrl(properties.url);
		// dataSource.setUsername(properties.username);
		// dataSource.setPassword(properties.password);
		// dataSource.setMaxIdle(properties.maxIdle);
		// dataSource.setMaxActive(properties.maxActive);
		// dataSource.setMaxWait(properties.maxWait);
		// dataSource.setInitialSize(properties.initialSize);
		// dataSource.setValidationQuery(properties.validationQuery);
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

}
