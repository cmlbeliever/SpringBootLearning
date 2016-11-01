package com.cml.springboot.framework;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.cml.springboot.framework.response.BaseResponseAdvise;
import com.cml.springboot.framework.response.MethodResponseHandler;

public class RequestAdapter extends RequestMappingHandlerAdapter {

	@Override
	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		System.out.println("----------------------------------");
		setCustomArgumentResolvers(new ArrayList<HandlerMethodArgumentResolver>());
		getCustomArgumentResolvers().add(new MyArgumentsResolver());

		setCustomReturnValueHandlers(new ArrayList<HandlerMethodReturnValueHandler>());
		getCustomReturnValueHandlers().add(new MethodResponseHandler());

		// response advise
		setResponseBodyAdvice(handleResponseAdvice());

		// message converter
		setMessageConverters(handleMessageConverter());

	}

	private List<ResponseBodyAdvice<?>> handleResponseAdvice() {
		List<ResponseBodyAdvice<?>> responseAdvise = new ArrayList<ResponseBodyAdvice<?>>();
		responseAdvise.add(new BaseResponseAdvise());
		return responseAdvise;
	}

	private List<HttpMessageConverter<?>> handleMessageConverter() {

		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();

		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);

		jsonConverter.setSupportedMediaTypes(mediaTypes);

		List<HttpMessageConverter<?>> msgConverters = new ArrayList<HttpMessageConverter<?>>();
		msgConverters.add(jsonConverter);
		return msgConverters;
	}
}
