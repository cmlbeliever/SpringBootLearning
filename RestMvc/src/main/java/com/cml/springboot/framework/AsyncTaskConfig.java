package com.cml.springboot.framework;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncTaskConfig implements AsyncConfigurer {

	@Value("${async.task.config.corePoolSize}")
	private Integer corePoolSize;
	@Value("${async.task.config.maxPoolSize}")
	private Integer maxPoolSize;

	@Override
	public Executor getAsyncExecutor() {

		ThreadPoolTaskExecutor ex = new ThreadPoolTaskExecutor();
		ex.setCorePoolSize(corePoolSize);
		ex.setMaxPoolSize(maxPoolSize);
		ex.initialize();
		return ex;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}

}
