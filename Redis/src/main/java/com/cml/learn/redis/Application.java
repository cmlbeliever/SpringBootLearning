package com.cml.learn.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		CacheService service = context.getBean(CacheService.class);
		for (int i = 10; i < 20; i++) {
			System.out.println(i + ":" + service.getName());
			service.setName("name" + i);
		}

	}
}
