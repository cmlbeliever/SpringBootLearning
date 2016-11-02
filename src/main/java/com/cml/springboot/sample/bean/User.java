package com.cml.springboot.sample.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class User {

	
	@Length(min = 3, message = "用户名长度不对")
	@NotBlank(message = "请输入用户名")
	private String username;

	@Length(min = 3, message = "密码长度不对")
	@NotBlank(message = "请输入密码")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
