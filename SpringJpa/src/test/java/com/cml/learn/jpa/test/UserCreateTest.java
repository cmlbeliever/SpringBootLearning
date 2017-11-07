package com.cml.learn.jpa.test;

import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cml.learn.jpa.Application;
import com.cml.learn.jpa.db.bean.User;
import com.cml.learn.jpa.db.write.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserCreateTest {

	@Autowired
	private UserRepository userRepository;

	private Integer userId;

	/**
	 * 用户创建测试
	 */
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUserEmail("testUser" + Math.random() * 10000);
		user.setPassword("111111");
		user.setBirthday(DateTime.now());
		user.setNickName("nickName" + Math.random() * 10000);
		user.setToken(UUID.randomUUID().toString());
		user.setGender((short) 1);
		user.setMobile("130xxxxx");
		user.setCreateDate(DateTime.now());
		user.setUpdateDate(DateTime.now());
		user.setLastLoginDate(DateTime.now());
		user = userRepository.save(user);
		userId = user.getUserId();

		System.out.println("create User success userId:" + userId);

		assertNotNull(userId);
	}

	/**
	 * 删除新创建的用户信息
	 */
	@After
	public void tearDown() {
		userRepository.delete(userId);
	}
}
