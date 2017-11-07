package com.cml.learn.jpa.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cml.learn.jpa.Application;
import com.cml.learn.jpa.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TransactionTest {

	@Autowired
	private UserService userService;

	@Test
	public void testTransaction() throws Exception {
		userService.testTransaction(1,2);
	}
}
