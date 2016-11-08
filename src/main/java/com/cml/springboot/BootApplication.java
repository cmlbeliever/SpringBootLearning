package com.cml.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,XADataSourceAutoConfiguration.class })
//@EnableTransactionManagement()
//@EnableAsync
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
		SpringApplication.run(BootApplication.class, args);
	}
}
