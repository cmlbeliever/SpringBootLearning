package com.cml.springboot.sample.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.cml.springboot.sample.bean.LogBean;
import com.cml.springboot.sample.service.LogService;

@Controller
public class SampleController {

	@Resource(name = "logServiceImpl")
	private LogService logService;

	@RequestMapping("/addLog")
	@ResponseBody
	public String addLog(HttpServletRequest request) {
		LogBean logbean = new LogBean();
		logbean.setApiUrl(request.getRequestURL().toString());
		logbean.setCallDayStr("20161111");
		logbean.setParameters("param:" + request.getParameterMap());
		logbean.setReturnStatusCode(200);
		logbean.setReturns("returns");
		Integer count = logService.insertLog(logbean);
		return "addLog count=" + count;
	}

	@RequestMapping("/addReadOnlyLog")
	@ResponseBody
	@Transactional(readOnly = true)
	public String addReadOnlyLog(HttpServletRequest request) {
		LogBean logbean = new LogBean();
		logbean.setApiUrl(request.getRequestURL().toString());
		logbean.setCallDayStr("20161111");
		logbean.setParameters("param:" + request.getParameterMap());
		logbean.setReturnStatusCode(200);
		logbean.setReturns("returns");
		Integer count = logService.insertLogReadOnly(logbean);
		return "addLog count=" + count;
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String onError(Exception e, HttpServletRequest request)throws Exception {
		return "报错了:" + e.getMessage();
	}
	// @ExceptionHandler(Exception.class)
	// public String onError(Exception e, HttpServletRequest request) {
	// System.out.println("------------------->exception!!!!");
	// return "redirect:/error.jsp";
	// }

}
