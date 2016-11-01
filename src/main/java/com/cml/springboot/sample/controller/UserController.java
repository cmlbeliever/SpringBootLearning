package com.cml.springboot.sample.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cml.springboot.framework.Configuration;
import com.cml.springboot.framework.response.BaseResponse;
import com.cml.springboot.framework.util.LogUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	protected static Log LOG = LogFactory.getLog(UserController.class);

	@RequestMapping("/login")
	@ResponseBody
	public BaseResponse login(@RequestParam(required = true) String username,
			@RequestParam("password") String password) {

		// if (result.hasErrors()) {
		// LOG.info(LogUtil.formatControllerLog(this, "有错误信息需要处理"));
		// }
		return new BaseResponse(Configuration.Status.STATUS_OK, "登录成功");
	}

	@ExceptionHandler({ MissingServletRequestParameterException.class })
	@ResponseBody
	public BaseResponse exception(MissingServletRequestParameterException e) {
		LOG.info(LogUtil.formatControllerLog(this, e.getMessage()));
		throw new RuntimeException(e);
		// return new BaseResponse(Configuration.Status.STATUS_OK, "异常处理");
	}
}
