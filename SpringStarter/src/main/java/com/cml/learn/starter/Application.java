package com.cml.learn.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cml.learn.starter.framework.EnableMyLogAutoConfiguration;

@EnableMyLogAutoConfiguration(basePackage = "com.cml.learn.starter.service")
// @EnableJpaRepositories
@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
