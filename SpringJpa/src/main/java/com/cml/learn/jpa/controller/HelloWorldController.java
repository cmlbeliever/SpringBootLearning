package com.cml.learn.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cml.learn.jpa.db.read.UserReadRepository;
import com.cml.learn.jpa.service.UserService;

@Controller
@RequestMapping("/")
public class HelloWorldController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserReadRepository userReadRepository;

	@RequestMapping
	@ResponseBody
	public String test(int id, String nickName) throws Exception {
		userService.modifyUser(id, nickName);
		return "数据操作完成,只读数据库数据：" + userReadRepository.findOne(id);
	}
}
