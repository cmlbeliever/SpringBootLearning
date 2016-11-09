package com.cml.springboot.framework.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import com.cml.springboot.sample.db.LogMapper;

@Configuration
@AutoConfigureAfter(MybatisConfig.class)
@MapperScan(basePackageClasses = LogMapper.class, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisScanConfiguration {
}
