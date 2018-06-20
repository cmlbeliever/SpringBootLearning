package com.cml.learn.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

@SpringBootApplication()
@EnableAsync
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AsyncService asyncService;

    @Bean
    public ApplicationRunner exceptionRunner() {
        return (arguments) -> {
            asyncService.testAsyncException(0);
        };
    }

    @Bean
    public ApplicationRunner runner() {
        return (arguments) -> {
            IntStream.range(1, 1000).forEach(index -> {
                asyncService.testAsync(index);
            });
        };
    }

    @Bean
    public ApplicationRunner futureRunner() {
        return (arguments) -> {
            Future<String> future = asyncService.testFuture(1);
            logger.info("---->future get:" + future.get());
        };
    }

    @Bean
    public ApplicationRunner completableFutureRunner() {
        return (arguments) -> {
            CompletableFuture<String> future = asyncService.testCompletableFuture(1);
            future.thenAccept(v -> {
                logger.info("---->CompletableFuture get:" + v);
            });
        };
    }

    @Bean
    public ApplicationRunner listenerableRunner() {
        return (arguments) -> {
            IntStream.range(1, 11).forEach(index -> {
                asyncService.testLisenableAsync(index).addCallback(s -> {
                    logger.info("asyncSuccess----->" + s);
                }, e -> {
                    logger.error("asyncFail", e);
                });
            });

        };
    }
}
