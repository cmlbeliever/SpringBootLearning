package com.cml.springboot.framework.mybatis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(MybatisConfig.class)
//@MapperScan(basePackages = { "com.cml.springboot.sample.db" }, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisScanConfiguration {
	protected static Log log = LogFactory.getLog(MybatisScanConfiguration.class);

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScanner = new MapperScannerConfigurer();
		mapperScanner.setBasePackage("com.cml.springboot.sample.db");
		mapperScanner.setSqlSessionFactoryBeanName("sqlSessionFactory");
		return mapperScanner;
	}

	public MybatisScanConfiguration() {
		log.info("*************************MybatisScanConfiguration***********************");
	}
}
