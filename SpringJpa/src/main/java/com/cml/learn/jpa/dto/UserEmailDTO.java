package com.cml.learn.jpa.dto;

/**
 * 只需要获取用户邮箱等信息
 * 
 * @author cml
 *
 */
public class UserEmailDTO {
	private final String userEmail;

	public UserEmailDTO(String userEmail) {
		super();
		this.userEmail = userEmail;
	}

	public String getUserEmail() {
		return userEmail;
	}

}
