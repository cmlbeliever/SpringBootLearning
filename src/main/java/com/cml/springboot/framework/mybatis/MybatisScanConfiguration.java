package com.cml.springboot.framework.mybatis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import com.cml.springboot.framework.mybatis.scanner.MapperScanner;

@Configuration
@AutoConfigureAfter(MybatisConfig.class)
@MapperScanner(basePackages = { "com.cml.springboot.sample.db" }, sqlSessionFactoryRef = "sqlSessionFactory")
// @MapperScan(basePackages = { "com.cml.springboot.sample.db" },
// sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisScanConfiguration {
	protected static Log log = LogFactory.getLog(MybatisScanConfiguration.class);

	public MybatisScanConfiguration() {
		log.info("*************************MybatisScanConfiguration***********************");
	}
}
