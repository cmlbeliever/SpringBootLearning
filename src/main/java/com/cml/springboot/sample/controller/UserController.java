package com.cml.springboot.sample.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	protected static Log LOG = LogFactory.getLog(UserController.class);

	public static final int SUCCESS = 1;
	public static final int FAIL = 2;

	public static String getAllErrors(Errors errors) {
		StringBuilder builder = new StringBuilder();
		for (ObjectError error : errors.getAllErrors()) {
			builder.append(error.getDefaultMessage()).append("\n");
		}
		return builder.toString();
	}

	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestParam String username) throws Exception {

		return "用户名或密码错误";
	}

	@RequestMapping(path = "/sss/{username}/{password}")
	@ResponseBody
	public String login4(@PathVariable String username, @PathVariable String password) throws Exception {
		return username + "," + password;
	}

	@RequestMapping(path = "/dt/{username}/{password}")
	@ResponseBody
	public String loginRestful(@PathVariable String username, @PathVariable String password) throws Exception {

		return username + ",," + password;
	}

	@RequestMapping("/login54/{username}/{password}")
	@ResponseBody
	public String login3(@PathVariable String username, @PathVariable String password) throws Exception {

		return username + ",," + password;
	}

	@RequestMapping("/{username}/login")
	@ResponseBody
	public String login2(@PathVariable String username, String password) throws Exception {

		return username + ",," + password;
	}

}
