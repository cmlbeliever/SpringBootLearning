package com.cml.springboot.sample.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cml.springboot.framework.Configuration;
import com.cml.springboot.framework.controller.BaseController;
import com.cml.springboot.framework.response.BaseResponse;
import com.cml.springboot.framework.util.LogUtil;
import com.cml.springboot.sample.bean.User;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	protected static Log LOG = LogFactory.getLog(UserController.class);

	@RequestMapping("/login")
	@ResponseBody
	public BaseResponse login(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			LOG.info(LogUtil.formatControllerLog(this, "有错误信息需要处理"));
			return new BaseResponse(Configuration.Status.STATUS_FAIL, getAllErrors(result));
		}
		return new BaseResponse(Configuration.Status.STATUS_OK, "登录成功");
	}

	// @RequestMapping("/login2")
	// @ResponseBody
	// public BaseResponse login2(User user) {
	// // if (result.hasErrors()) {
	// // LOG.info(LogUtil.formatControllerLog(this, "有错误信息需要处理"));
	// // }
	// return new BaseResponse(Configuration.Status.STATUS_OK, "登录成功" +
	// user.getUsername());
	// }

	// @ExceptionHandler({ MissingServletRequestParameterException.class })
	// @ResponseBody
	// public BaseResponse exception(MissingServletRequestParameterException e)
	// {
	// LOG.info(LogUtil.formatControllerLog(this, e.getMessage()));
	// throw new RuntimeException(e);
	// // return new BaseResponse(Configuration.Status.STATUS_OK, "异常处理");
	// }
}
