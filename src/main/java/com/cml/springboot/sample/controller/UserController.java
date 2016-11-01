package com.cml.springboot.sample.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cml.springboot.framework.response.BaseResponse;
import com.cml.springboot.framework.util.LogUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	protected static Log LOG = LogFactory.getLog(UserController.class);

	@RequestMapping
	@ResponseBody
	public BaseResponse login(@RequestParam(required = true) String username,
			@RequestParam(required = true) String password, BindingResult result) {
		if (result.hasErrors()) {
			LOG.info(LogUtil.formatControllerLog(this, "有错误信息需要处理"));
		}
		return null;
	}
}
