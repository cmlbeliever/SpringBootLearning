package com.cml.springboot.sample.service.impl;

import java.sql.SQLException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cml.springboot.framework.util.MD5;
import com.cml.springboot.framework.util.UUIDUtil;
import com.cml.springboot.sample.bean.User;
import com.cml.springboot.sample.db.UserMapper;
import com.cml.springboot.sample.service.UserService;

@Transactional
@Component("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserByToken(String token) throws SQLException {
		return userMapper.getUserByToken(token);
	}


	@Override
	public User login(User user) throws Exception {

		user.setPassword(MD5.getMD5(user.getPassword()));

		User loginUser = userMapper.getUser(user);
		if (null != loginUser) {
			// 重新生成token
			user.setNewToken(UUIDUtil.generateUUID());
			user.setToken(loginUser.getToken());
			int updateCount = userMapper.updateToken(user);
			return updateCount > 0 ? loginUser : null;
		}
		return null;
	}

}
