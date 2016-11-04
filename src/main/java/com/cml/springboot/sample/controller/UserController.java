package com.cml.springboot.sample.controller;

import javax.annotation.Resource;
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
import com.cml.springboot.sample.bean.UserResponse;
import com.cml.springboot.sample.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	protected static Log LOG = LogFactory.getLog(UserController.class);

	@Resource(name = "userServiceImpl")
	private UserService userService;

	@RequestMapping("/login")
	@ResponseBody
	public BaseResponse login(@Valid User user, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			LOG.info(LogUtil.formatControllerLog(this, "有错误信息需要处理"));
			return new BaseResponse(FAIL, getAllErrors(result));
		}

		User loginUser = userService.login(user);

		if (null != loginUser) {
			return new UserResponse(SUCCESS, loginUser);
		}

		return new BaseResponse(FAIL, "用户名或密码错误");
	}
}
