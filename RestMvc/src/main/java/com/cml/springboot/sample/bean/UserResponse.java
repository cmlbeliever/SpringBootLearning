package com.cml.springboot.sample.bean;

import com.cml.springboot.framework.response.BaseResponse;

public class UserResponse extends BaseResponse {
	private User user;

	public UserResponse(Integer code, String message, User user) {
		super(code, message);
		this.user = user;
	}

	public UserResponse(Integer code, User user) {
		super(code, null);
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
