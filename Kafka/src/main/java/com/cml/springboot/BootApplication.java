package com.cml.springboot;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cml.springboot.kafka.Producer;
import com.cml.springboot.message.TestMessage;

@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BootApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner runner(Producer producer) {
		return (args) -> producer.send(new TestMessage(1, "A simple test message"));
	}
}
