package com.cml.springboot.framework.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.cml.springboot", sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig {

	@Value("${db.mybatis.type-aliases-package}")
	private String typeAliasesPackage;

	private String configLocation;

	@Value("${db.mybatis.mapper-locations}")
	private String mapperLocations;

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(DataSource datasource) throws Exception {

		// System.out.println(
		// "=============typeAliasesPackage：" + typeAliasesPackage +
		// ",mapperLocations:" + mapperLocations);

		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(datasource);
		sessionFactory.setTypeAliasesPackage(typeAliasesPackage);

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(resolver.getResources(mapperLocations));

		return sessionFactory.getObject();
	}
}
