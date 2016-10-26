package com.cml.springboot.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cml.springboot.sample.bean.LogBean;
import com.cml.springboot.sample.db.LogMapper;
import com.mysql.jdbc.Driver;

@Controller
public class SampleController {

	@Autowired
	private LogMapper logMapper;

	@RequestMapping("/addLog")
	@ResponseBody
	public String addLog(HttpServletRequest request) {
		LogBean logbean = new LogBean();
		logbean.setApiUrl(request.getRequestURL().toString());
		logbean.setCallDayStr("20161111");
		logbean.setParameters("param:" + request.getParameterMap());
		logbean.setReturnStatusCode(200);
		logbean.setReturns("returns");
		Integer count = logMapper.insertLog(logbean);
		return "addLog count=" + count;
	}

}
