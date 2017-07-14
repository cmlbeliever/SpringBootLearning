package com.cml.learning.rabbitmq.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cml.learning.rabbitmq.spring.model.EmailModel;
import com.cml.learning.rabbitmq.spring.service.MailService;

/**
 * 整合Spring测试
 * 
 * @author cml
 *
 */
public class SpringIntegrationReceiverTest {
	@Test
	public void testMessage() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/application-rabbitmq.xml");
		System.out.println("receiver started!!!");
	}
}
