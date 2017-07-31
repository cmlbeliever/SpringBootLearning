package com.cml.springboot.framework.exception;

import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import com.cml.springboot.framework.Configuration;
import com.cml.springboot.framework.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("exceptionResolver")
public class ExceptionHandler extends DefaultHandlerExceptionResolver {

	private static Log log = LogFactory.getLog(ExceptionHandler.class);

	@Value("${exception.response.filter:false}")
	private boolean filterErrorMsg;
	@Value("${exception.response.messasge:errors occurs}")
	private String defaultErrorMsg;
	@Value("${exception.response.contentType:application/json}")
	private String contentType;

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

		log.warn("<<< exception occurs >>>", ex);
		log.info("handler:====>" + handler);
		// if (handler instanceof HandlerMethod) {
		// HandlerMethod method = (HandlerMethod) handler;
		// MethodParameter[] params = method.getMethodParameters();
		// if (null != params) {
		// for (MethodParameter param : params) {
		// log.info(param.getParameterName() + ":" + param.getParameterType());
		// }
		// }
		// log.info("HandlerMethod handler:====>" + handler);
		// }
		
		log.info("dddddddddddd:"+request.getAttribute("dddddddddddd"));

//		Enumeration<String> em = request.getAttributeNames();
//		while (em.hasMoreElements()) {
//			String key = em.nextElement();
//			Object value = request.getAttribute(key);
//			log.info("key:" + key + ",value:" + value);
//		}
		ObjectMapper mapper = new ObjectMapper();

		mapper.setSerializationInclusion(Include.NON_NULL);

		BaseResponse responseBean = new BaseResponse(Configuration.Status.STATUS_FAIL, filterErrorMsg ? defaultErrorMsg : ex.getMessage());
		try {
			String message = mapper.writeValueAsString(responseBean);
			response.reset();
			response.setContentType(contentType);
			response.getOutputStream().write(message.getBytes());
			response.getOutputStream().flush();
		} catch (Exception e) {
			log.error(e);
		}
		return new ModelAndView();
	}

}
