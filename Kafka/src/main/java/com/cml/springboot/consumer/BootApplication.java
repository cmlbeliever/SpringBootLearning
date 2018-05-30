package com.cml.springboot.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableKafka
public class BootApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(BootApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        // app.setWebEnvironment(false);
        app.run(args);
//		SpringApplication.run(BootApplication.class, args);
    }

}
