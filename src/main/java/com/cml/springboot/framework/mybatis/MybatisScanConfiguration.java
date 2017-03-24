package com.cml.springboot.framework.mybatis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import com.cml.springboot.framework.mybatis.scanner.MapperScanner;

@Configuration
@AutoConfigureAfter(MybatisConfig.class)
@MapperScanner(basePackages = { "${db.mybatis.mapperScanner.basePackage}" }, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisScanConfiguration {
	protected static Log log = LogFactory.getLog(MybatisScanConfiguration.class);

	public MybatisScanConfiguration() {
		log.info("*************************MybatisScanConfiguration***********************");
	}
}
