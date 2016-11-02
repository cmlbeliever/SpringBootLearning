package com.cml.springboot.framework;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cml.springboot.framework.interceptor.ParamInterceptor;
import com.cml.springboot.framework.interceptor.TokenInterceptor;

@Configuration
public class GlobalConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private ParamInterceptor paramInterceptor;

	@Autowired
	private TokenInterceptor tokenInterceptor;

	/**
	 * 1、 extends WebMvcConfigurationSupport 2、重写下面方法; setUseSuffixPatternMatch
	 * : 设置是否是后缀模式匹配，如“/user”是否匹配/user.*，默认真即匹配； setUseTrailingSlashMatch :
	 * 设置是否自动后缀路径模式匹配，如“/user”是否匹配“/user/”，默认真即匹配；
	 */
	// @Override
	// public void configurePathMatch(PathMatchConfigurer configurer) {
	// configurer.setUseSuffixPatternMatch(false).setUseTrailingSlashMatch(true);
	// }

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(paramInterceptor).addPathPatterns("/*");
		registry.addInterceptor(tokenInterceptor).addPathPatterns("/*");
		super.addInterceptors(registry);
	}

	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		exceptionResolvers.clear();
		super.extendHandlerExceptionResolvers(exceptionResolvers);
		System.out.println("====================================================");
		System.out.println(exceptionResolvers);
		// org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver,
		// org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver@7e307087,
		// org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver@1220ef43]
		System.out.println("====================================================");
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new MyArgumentsResolver());
	}

	// @Override
	// public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
	//
	// ThreadPoolTaskExecutor ex = new ThreadPoolTaskExecutor();
	// ex.setCorePoolSize(5);
	// ex.setMaxPoolSize(500);
	//
	// configurer.setTaskExecutor(ex);
	//
	// System.out.println("====InterceptorConfig.configureAsyncSupport==================");
	// }

}
