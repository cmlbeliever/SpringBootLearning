package com.cml.springboot.framework;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class MyArgumentsResolver implements HandlerMethodArgumentResolver {

	protected static Log log = LogFactory.getLog(MyArgumentsResolver.class);

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		System.out.println("=================sssssssssssssssssssss HandlerMethodArgumentResolverComposite");
		log.info("===================>MyArgumentsResolver.supportsParameter:" + parameter);
		return true;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		log.info("===================>MyArgumentsResolver.resolveArgument:" + parameter);
		System.out.println("=================sssssssssssssssssssss");
		return null;
	}

}
