package com.cml.learn.test;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() throws InterruptedException {
        System.out.println("===================模拟延迟--------------------");
        Thread.sleep(30000);
        return args -> {
            System.out.println("===================模拟延迟启动--------------------");
        };
    }
}
