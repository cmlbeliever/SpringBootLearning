package com.cml.learn.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Executor;

@Component
public class AsyncThreadPoolConfiguration2 implements AsyncConfigurer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(100);
        taskExecutor.setMaxPoolSize(500);
        taskExecutor.setThreadNamePrefix("async-threadpool2-");
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
                logger.error("AsyncUncaughtExceptionHandler:", throwable);
                System.out.println("method:" + method.getName());
                System.out.println("objects:" + Arrays.asList(objects));
            }
        };
    }

}
