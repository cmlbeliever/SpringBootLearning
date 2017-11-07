package com.cml.learn.jpa.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cml.learn.jpa.Application;
import com.cml.learn.jpa.db.bean.User;
import com.cml.learn.jpa.db.write.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserQueryTest {
	@Autowired
	private UserRepository userRepository;

	@Test
	public void testQueryUserById() {
		System.out.println(userRepository.findOne(1));
	}

	@Test
	public void testQueryUsers() {
		System.out.println(userRepository.count());
	}

	@Test
	public void testFindByEmail() {
		System.out.println(userRepository.findByUserEmail("testUser2714.874622074711"));
	}

	@Test
	public void testFindFirstOrderByNickNameAsc() {
		System.out.println(userRepository.findFirstByOrderByNickNameAsc());
	}

	@Test
	public void testFindByPage() {
		int pageSize = 5;
		int page = 0;

		PageRequest pageReq = new PageRequest(page, pageSize);

		Page<User> users = userRepository.findAll(pageReq);
		System.out.println("totalElement:" + users.getTotalElements());
		System.out.println("totalPage:" + users.getTotalPages());
		System.out.println("getUsers:" + users.getContent());

	}
	
}
