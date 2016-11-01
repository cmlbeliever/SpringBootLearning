package com.cml.springboot.framework.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.cml.springboot.framework.Configuration;
import com.cml.springboot.framework.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("exceptionResolver")
public class ExceptionHandler implements HandlerExceptionResolver {

	private static Log log = LogFactory.getLog(ExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

		log.info("====exception====>" + ex.getMessage());

		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json");
		mapper.setSerializationInclusion(Include.NON_NULL);
		BaseResponse responseBean = new BaseResponse(Configuration.Status.STATUS_INVALID_TOKEN, ex.getMessage());
		try {
			mapper.writeValue(response.getWriter(), responseBean);
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}

}
