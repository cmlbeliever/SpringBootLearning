package com.cml.springboot.framework.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(MybatisConfig.class)
@MapperScan(basePackages = { "com.cml.springboot.sample.db" }, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisScanConfiguration {
}
