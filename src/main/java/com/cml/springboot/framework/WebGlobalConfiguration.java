package com.cml.springboot.framework;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cml.springboot.framework.deserializer.DateTimeDeserializer;
import com.cml.springboot.framework.interceptor.ParamInterceptor;
import com.cml.springboot.framework.interceptor.TokenInterceptor;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;

@Configuration
public class WebGlobalConfiguration extends WebMvcConfigurerAdapter {

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

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		
		SimpleModule serModule = new SimpleModule();
		serModule.addSerializer(DateTime.class, new DateTimeDeserializer());
		objectMapper.registerModule(serModule);
		
		jsonConverter.setObjectMapper(objectMapper);
		
		return jsonConverter;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(paramInterceptor).addPathPatterns("/*");
		registry.addInterceptor(tokenInterceptor).addPathPatterns("/*").excludePathPatterns("/user/login*");
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
		// argumentResolvers.add(new MyArgumentsResolver());
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
