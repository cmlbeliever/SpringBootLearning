package com.cml.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableTransactionManagement()
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
		SpringApplication.run(BootApplication.class, args);
	}
}
