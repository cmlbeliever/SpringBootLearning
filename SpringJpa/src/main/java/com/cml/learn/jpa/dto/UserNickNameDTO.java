package com.cml.learn.jpa.dto;

/**
 * 只需要获取用户昵称等信息，可以根据实际情况添加需要的字段
 * 
 * @author cml
 *
 */
public class UserNickNameDTO {
	private final String nickName;

	public UserNickNameDTO(String nickName) {
		super();
		this.nickName = nickName;
	}

	public String getNickName() {
		return nickName;
	}

}
