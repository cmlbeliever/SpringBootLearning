package com.cml.springboot.sample.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cml.springboot.framework.Configuration;
import com.cml.springboot.framework.response.BaseResponse;
import com.cml.springboot.sample.bean.LogBean;
import com.cml.springboot.sample.service.LogService;

@Controller
public class SampleController {

	@Resource(name = "logServiceImpl")
	private LogService logService;

	// @Value("${message}")
	private String message;

	@RequestMapping("/demo")
	public String demo(Model model) {
		model.addAttribute("message", "我是你的message!!!");
		// HandlerMethodArgumentResolver
		throw new IllegalArgumentException("你就错了！！");
	}

	@RequestMapping("/test")
	@ResponseBody
	public BaseResponse test() {
		return new BaseResponse(Configuration.Status.STATUS_OK, "测试访问成功");
	}

	@RequestMapping("/ex")
	@ResponseBody
	public BaseResponse ex() {
		throw new RuntimeException("controller报错了！！");
	}

	@RequestMapping("/addLog")
	@ResponseBody
	public String addLog(HttpServletRequest request) {
		System.out.println("SampleController.addLog threadId:" + Thread.currentThread().getId() + "," + Thread.currentThread().getName());
		LogBean logbean = new LogBean();
		logbean.setApiUrl(request.getRequestURL().toString());
		logbean.setCallDayStr("20161111");
		logbean.setParameters("param:" + request.getParameterMap());
		logbean.setReturnStatusCode(200);
		logbean.setReturns("returns");
		logService.insertLog(logbean);
		return "addLog count=" + 1;
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
		logService.insertLogReadOnly(logbean);
		return "addLog count=" + 1;
	}

	// @ExceptionHandler(Exception.class)
	// @ResponseBody
	// public String onError(Exception e, HttpServletRequest request) throws
	// Exception {
	// return "报错了:" + e.getMessage();
	// }
	// @ExceptionHandler(Exception.class)
	// public String onError(Exception e, HttpServletRequest request) {
	// System.out.println("------------------->exception!!!!");
	// return "redirect:/error.jsp";
	// }

}
