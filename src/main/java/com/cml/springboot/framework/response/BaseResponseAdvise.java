package com.cml.springboot.framework.response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

//@ControllerAdvice()
public class BaseResponseAdvise implements ResponseBodyAdvice<BaseResponse> {

	private static Log log = LogFactory.getLog(BaseResponseAdvise.class);

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		log.info("===>" + (returnType.getGenericParameterType() instanceof BaseResponse));
		return returnType.getGenericParameterType() == BaseResponse.class;
	}

	@Override
	public BaseResponse beforeBodyWrite(BaseResponse body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
//		body.setMessage("被我修改了");
		return body;
	}

}
