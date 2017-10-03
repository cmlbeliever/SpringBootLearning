package com.cml.springboot.controller.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cml.springboot.BootApplication;
import com.cml.springboot.sample.bean.User;
import com.cml.springboot.sample.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
public class DynamicDataSourceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testLogin() throws Exception {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("111111");
		User loginUser = userService.login(user);
		System.out.println("登录结果：" + loginUser);
	}

	@Test
	public void testFindUser() throws Exception {
		User loginUser = userService.findUserByToken("xxx");
		System.out.println("查询用户结果：" + loginUser);
	}
}