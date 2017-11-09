package com.cml.learn.jpa.test;

import static org.junit.Assert.assertNotNull;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cml.learn.jpa.Application;
import com.cml.learn.jpa.db.bean.User;
import com.cml.learn.jpa.db.write.UserRepository;
import com.cml.learn.jpa.framework.util.MD5;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserCreateTest {

	@Autowired
	private UserRepository userRepository;

	/**
	 * 用户创建测试
	 */
	@Test
	public void testCreateUser() {
		for (int i = 0; i < 50; i++) {
			User user = new User();
			user.setUsername("user" + i);
			user.setPassword(MD5.getMD5("111111"));
			user.setNickname("nickname" + i);
			user.setCreateTime(DateTime.now());
			user.setUpdateTime(DateTime.now());
			user = userRepository.save(user);
			Long userId = user.getUserId();

			System.out.println("create User success userId:" + userId);

			assertNotNull(userId);
		}
	}

}
