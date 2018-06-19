package com.cml.learn.async;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@ConditionalOnProperty(name = "async.threadpool.enable", matchIfMissing = false)
@Configuration
public class AsyncThreadPoolConfiguration {

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(100);
        taskExecutor.setMaxPoolSize(500);
        taskExecutor.setThreadNamePrefix("async-thread-pool-");
        return taskExecutor;
    }
}
