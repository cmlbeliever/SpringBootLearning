package com.cml.learning.rabbitmq.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 整合Spring测试，接收消息
 * 
 * @author cml
 *
 */
public class SpringIntegrationReceiverTest {
	@Test
	public void testMessage() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/application-rabbitmq-listener.xml");
		System.out.println("receiver started!!!");
		Thread.sleep(1000000);
	}
}
