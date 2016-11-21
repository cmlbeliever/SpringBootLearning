package com.cml.springboot.framework.mybatis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(MybatisRWConfig.class)
@MapperScan(basePackages = { "com.cml.springboot.sample.db.rw" }, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisRWScanConfiguration {
	protected static Log log = LogFactory.getLog(MybatisRWScanConfiguration.class);

	public MybatisRWScanConfiguration() {
		log.info("*************************MybatisScanConfiguration***********************");
	}
}
