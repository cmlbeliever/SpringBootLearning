package com.cml.learn.jpa;

import java.util.Arrays;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching
@EnableTransactionManagement
@EnableAspectJAutoProxy
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class })
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * 添加缓存配置
	 * 
	 * @return
	 */
	@Bean
	public CacheManager cacheManager() {

		Cache cache = new ConcurrentMapCache("simpleCache");

		SimpleCacheManager manager = new SimpleCacheManager();
		manager.setCaches(Arrays.asList(cache));

		return manager;
	}

	@Bean
	public CustomizableTraceInterceptor interceptor() {

		CustomizableTraceInterceptor interceptor = new CustomizableTraceInterceptor();
		interceptor.setEnterMessage("Entering $[methodName]($[arguments]).");
		interceptor.setExitMessage("Leaving $[methodName](..) with return value $[returnValue], took $[invocationTime]ms.");

		return interceptor;
	}

	@Bean
	public Advisor traceAdvisor() {

		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(public * org.springframework.data.repository.Repository+.*(..))");

		return new DefaultPointcutAdvisor(pointcut, interceptor());
	}

	// 在页面上允许加载延时的数据
	// @Bean
	// public FilterRegistrationBean test() {
	// FilterRegistrationBean filter = new FilterRegistrationBean();
	// filter.setEnabled(true);
	// OpenEntityManagerInViewFilter filterInView = new
	// OpenEntityManagerInViewFilter();
	// filterInView.setEntityManagerFactoryBeanName("readEntityManagerFactory");
	// filter.setFilter(filterInView);
	// filter.setUrlPatterns(Arrays.asList("/*"));
	// return filter;
	// }
}
