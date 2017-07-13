package com.cml.springboot.sample.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cml.springboot.sample.bean.User;
import com.cml.springboot.sample.service.UserService;

/**
 * ModelAttribute demo
 * 
 * @author team-lab
 *
 */
@Controller
@RequestMapping("/model")
public class ModelAttributeController {

	@Resource(name = "userServiceImpl")
	private UserService userService;

	@ModelAttribute("user")
	public User user(@RequestParam String token) throws SQLException {
		System.out.println("==================================================token:"+token);
		if (StringUtils.isBlank(token)) {
			return null;
		}
		return userService.findUserByToken(token);
	}

	@RequestMapping("/testA")
	@ResponseBody
	public String testA(@ModelAttribute() User user) {
		if (user == null) {
			return "user is null!!!!";
		}
		return "user:" + user.getUsername() + "," + user.getNickName();
	}

}
