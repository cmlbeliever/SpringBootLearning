package com.cml.springboot.sample.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cml.springboot.sample.bean.User;
import com.cml.springboot.sample.db.UserMapper;
import com.cml.springboot.sample.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserByToken(String token) throws SQLException {
		return userMapper.getUserByToken(token);
	}

}
