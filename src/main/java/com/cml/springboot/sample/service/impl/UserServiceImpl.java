package com.cml.springboot.sample.service.impl;

import java.sql.SQLException;

import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CacheResult;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cml.springboot.framework.util.MD5;
import com.cml.springboot.framework.util.UUIDUtil;
import com.cml.springboot.sample.bean.User;
import com.cml.springboot.sample.db.UserMapper;
import com.cml.springboot.sample.service.CacheKeys;
import com.cml.springboot.sample.service.UserService;

@Transactional
@Component("userServiceImpl")
@CacheDefaults(cacheName = CacheKeys.CACHE_DEFAULT)
public class UserServiceImpl implements UserService, CacheKeys {

	protected static Log log = LogFactory.getLog(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;

	@Override
	@CacheResult()
	public User findUserByToken(@CacheKey String token) throws SQLException {
		User u = userMapper.getUserByToken(token);
		log.info("====================read user from db=========");
		return u;
	}

	@Override
	public User login(User user) throws Exception {

		user.setPassword(MD5.getMD5(user.getPassword()));

		User loginUser = userMapper.getUser(user);
		if (null != loginUser) {
			String newToken = UUIDUtil.generateUUID();
			// 重新生成token
			user.setNewToken(newToken);
			user.setToken(loginUser.getToken());
			int updateCount = userMapper.updateToken(user);

			if (updateCount > 0) {
				loginUser.setToken(newToken);
				return loginUser;
			}

		}
		return null;
	}

}
