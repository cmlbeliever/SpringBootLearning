package com.cml.springboot.sample.service.impl;

import java.sql.SQLException;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cml.springboot.framework.util.MD5;
import com.cml.springboot.framework.util.UUIDUtil;
import com.cml.springboot.sample.bean.LogBean;
import com.cml.springboot.sample.bean.User;
import com.cml.springboot.sample.db.UserMapper;
import com.cml.springboot.sample.service.LogService;
import com.cml.springboot.sample.service.UserService;

@Transactional
@Component("userServiceImpl")
public class UserServiceImpl implements UserService {

	protected static Log LOG = LogFactory.getLog(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private LogService logService;

	@Override
	public User findUserByToken(String token) throws SQLException {
		return userMapper.getUserByToken(token);
	}

	@Transactional()
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
			LOG.info("更新的数量===》" + updateCount);
			// 特意更新两次，验证事务
//			updateCount = userMapper.updateToken(user);
//			LOG.info("更新的数量2===》" + updateCount);

			LogBean logbean = new LogBean();
			logbean.setApiUrl("login");
			logbean.setCallDayStr("20171010");
			logbean.setParameters("none");
			logService.insertLog(logbean);
			
			if (updateCount > 0) {
				loginUser.setToken(newToken);
				return loginUser;
			} else {
				throw new RuntimeException("发生并发错误！");
			}

		}
	
		return null;
	}

}
