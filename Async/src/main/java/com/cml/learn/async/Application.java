package com.cml.learn.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.IntStream;

@SpringBootApplication()
@EnableAsync
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private AsyncService asyncService;

    @Bean
    public ApplicationRunner runner() {
        return (arguments) -> {
            IntStream.range(1, 1000).forEach(index -> {
                asyncService.testAsync(index);
            });
        };
    }
}
