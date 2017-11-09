package com.cml.learn.jpa.test;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cml.learn.jpa.Application;
import com.cml.learn.jpa.db.bean.Order;
import com.cml.learn.jpa.db.bean.User;
import com.cml.learn.jpa.db.write.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserQueryTest {
	@Autowired
	private UserRepository userRepository;

	/**
	 * 注意要添加上事务，否则延迟加载时连接已经关闭，导致无法加载
	 */
	@Test
	@Transactional
	public void testQueryUserById() {
		User user = userRepository.findOne(1L);
		System.out.println("username:" + user.getUsername());
		List<Order> orders = user.getOrders();
		System.out.println(orders);
	}

	@Test
	public void testQueryUsers() {
		System.out.println(userRepository.count());
	}

	@Test
	public void testFindFirstOrderByNickNameAsc() {
		System.out.println(userRepository.findFirstByOrderByNicknameAsc());
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
