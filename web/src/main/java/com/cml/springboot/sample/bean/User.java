package com.cml.springboot.sample.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;

public class User {

	@Length(min = 3, message = "用户名长度不对")
	@NotBlank(message = "${user.empty.username}")
	private String username;

	@Length(min = 3, message = "密码长度不对")
	@NotBlank(message = "请输入密码")
	private String password;

	private String token;

	private String newToken;

	private Integer userId;

	private DateTime birthday;

	private String nickName;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public DateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(DateTime birthday) {
		this.birthday = birthday;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNewToken() {
		return newToken;
	}

	public void setNewToken(String newToken) {
		this.newToken = newToken;
	}

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
