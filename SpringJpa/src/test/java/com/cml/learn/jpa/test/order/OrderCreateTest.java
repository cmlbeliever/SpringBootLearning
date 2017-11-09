package com.cml.learn.jpa.test.order;

import java.util.UUID;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cml.learn.jpa.Application;
import com.cml.learn.jpa.db.bean.Order;
import com.cml.learn.jpa.db.bean.User;
import com.cml.learn.jpa.db.write.OrderRepository;
import com.cml.learn.jpa.db.write.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class OrderCreateTest {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserRepository userRepository;

	@Test
	public void testAddOrder() {
		for (int i = 1; i < 50; i++) {
			Order order = new Order();
			order.setOrderName("orderName"+i);
			order.setOrderNumber(UUID.randomUUID().toString());
			order.setCreateTime(DateTime.now());
			order.setUpdateTime(DateTime.now());

			User user = userRepository.findOne((long) i);
			order.setUser(user);

			orderRepository.save(order);
		}
	}
}
