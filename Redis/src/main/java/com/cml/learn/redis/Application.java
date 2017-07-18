package com.cml.learn.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		CacheService service = context.getBean(CacheService.class);
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println(service.getName3());
				}
			}).start();
		}
		Thread.sleep(10000);
		// for (int i = 10; i < 20; i++) {
		// System.out.println(i + ":" + service.getName());
		// service.setName("name" + i);
		// }
		// service.setList("1", "2","11", "22","44");
		// System.out.println(service.getList());
	}
}
