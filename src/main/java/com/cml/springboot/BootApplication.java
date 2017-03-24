package com.cml.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan()
@EnableAsync
@PropertySources({ @PropertySource("classpath:config/application-jdbc.properties") })
public class BootApplication {

	// @Bean
	// public PropertyPlaceholderConfigurer placeHolder() {
	//
	// PropertyPlaceholderConfigurer configure = new
	// PropertyPlaceholderConfigurer();
	// configure.setLocations(null);
	//
	// return configure;
	// }

	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(BootApplication.class);
		Map<String, Object> defaultProperties = new HashMap<>();
		// defaultProperties.put("db.mybatis.mapperScanner.basePackage",
		// "com.cml.springboot.sample.db");
		application.setDefaultProperties(defaultProperties);
		application.setWebEnvironment(true);
		application.run(args);
		// SpringApplication.run(BootApplication.class, args);
	}
}
