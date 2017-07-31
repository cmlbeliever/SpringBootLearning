package com.cml.springboot.framework.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.util.WebUtils;

import com.cml.springboot.sample.bean.LogBean;
import com.cml.springboot.sample.service.LogService;

@Component
public class ParamInterceptor implements HandlerInterceptor {

	protected static Log LOG = LogFactory.getLog(ParamInterceptor.class);

	@Resource(name = "logServiceImpl")
	private LogService logService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		try {
//			LogBean logbean = new LogBean();
//			logbean.setApiUrl(request.getRequestURL().toString());
//			logbean.setCallDayStr("20161111");
//			logbean.setParameters("param:" + request.getParameterMap());
//			logbean.setReturnStatusCode(200);
//			logbean.setReturns("returns");
//			logService.insertLog(logbean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		LOG.info("======>postHandle,handler:" + handler);
		LOG.info("======>postHandle,modelAndView:" + modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		LOG.info("======>afterCompletion,handler:" + handler);
		LOG.info("======>afterCompletion,ex:" + ex);
	}

}
