package com.cml.springboot.sample.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cml.springboot.sample.bean.LogBean;
import com.cml.springboot.sample.service.LogService;

@Component
public class ParamInterceptor implements HandlerInterceptor {

	@Resource(name = "logServiceImpl")
	private LogService logService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		try {
			LogBean logbean = new LogBean();
			logbean.setApiUrl(request.getRequestURL().toString());
			logbean.setCallDayStr("20161111");
			logbean.setParameters("param:" + request.getParameterMap());
			logbean.setReturnStatusCode(200);
			logbean.setReturns("returns");
			Integer count = logService.insertLog(logbean);
			System.out.println("=========================>" + request.getRequestURL() + ",log:" + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("======>postHandle,handler:" + handler);
		System.out.println("======>postHandle,modelAndView:" + modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("======>afterCompletion,handler:" + handler);
		System.out.println("======>afterCompletion,ex:" + ex);
	}

}
