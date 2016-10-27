package com.cml.springboot.framework;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncTaskConfig implements AsyncConfigurer {

	@Override
	public Executor getAsyncExecutor() {
		System.out.println("====AsyncTaskConfig.getAsyncExecutor==================");
		ThreadPoolTaskExecutor ex = new ThreadPoolTaskExecutor();
		ex.setCorePoolSize(5);
		ex.setMaxPoolSize(500);
		ex.initialize();
		return ex;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}

}
