package com.cml.springboot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

	protected static Log LOG = LogFactory.getLog(UserController.class);

	@RequestMapping("/login")
	@ResponseBody
	public String login(String username, String password) throws Exception {

		return username + ",," + password;
	}

	@RequestMapping("/{username}/login")
	@ResponseBody
	public String login2(@PathVariable String username, String password) throws Exception {

		return username + ",," + password;
	}

	@RequestMapping("/login/{username}/{password}")
	@ResponseBody
	public String login3(@PathVariable String username, @PathVariable String password) throws Exception {

		return username + ",," + password;
	}

}
