package com.cml.springboot.sample.controller;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cml.springboot.framework.controller.BaseController;
import com.cml.springboot.framework.response.BaseResponse;
import com.cml.springboot.sample.bean.User;
import com.cml.springboot.sample.bean.UserResponse;
import com.cml.springboot.sample.service.UserService;

@RequestMapping("/cache")
@Controller
public class CacheController extends BaseController {

	protected static Log log = LogFactory.getLog(CacheController.class);

	@Resource(name = "userServiceImpl")
	private UserService userService;

	@RequestMapping("/{token}")
	@ResponseBody
	public BaseResponse userInfo(@PathVariable String token) throws Exception {

		if (StringUtils.isBlank(token)) {
			return new BaseResponse(FAIL, "token 必须传入！");
		}
		User user = userService.findUserByToken(token);
		log.info("read data token=" + token + ",user:" + user);
		return new UserResponse(SUCCESS, user);
	}
}
