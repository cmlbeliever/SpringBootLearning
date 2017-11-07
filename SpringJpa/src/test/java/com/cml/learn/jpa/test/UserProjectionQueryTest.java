package com.cml.learn.jpa.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cml.learn.jpa.Application;
import com.cml.learn.jpa.db.UserRepository;
import com.cml.learn.jpa.dto.UserEmailDTO;
import com.cml.learn.jpa.dto.UserNickNameDTO;

/**
 * 部分字段查询
 * 
 * @author cml
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserProjectionQueryTest {
	@Autowired
	private UserRepository userRepository;

	/**
	 * 查询部分字段功能
	 */
	@Test
	public void testProjectionQuery() {
		UserEmailDTO emailDTO = userRepository.findByUserId(1, UserEmailDTO.class);
		System.out.println("emailDTO:" + emailDTO.getUserEmail());

		UserNickNameDTO userNickNameDTO = userRepository.findByUserId(1, UserNickNameDTO.class);
		System.out.println("userNickNameDTO:" + userNickNameDTO.getNickName());
	}

}
