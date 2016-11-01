package com.cml.springboot.framework;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class MyArgumentsResolver implements HandlerMethodArgumentResolver {

	protected static Log log = LogFactory.getLog(MyArgumentsResolver.class);

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		log.info("===================>MyArgumentsResolver.supportsParameter:" + parameter);
		return true;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		log.info("===================>MyArgumentsResolver.resolveArgument:" + parameter);
		return null;
	}

}
