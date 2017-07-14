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
public class SpringIntegrationTest {
	@Test
	public void testMessage() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/application-rabbitmq.xml");
		MailService service = context.getBean(MailService.class);

		// 发送次数的标识，每次执行后累加
		int time = 3;

		System.out.println("====================before send=======================");

		EmailModel model = new EmailModel();
		model.setTitle("邮箱验证,time:" + time);
		model.setTo("12347890@china.com");

		model.setContent("fanout");
		service.sendFanoutEmail(null, model);

		model.setContent("direct");
		service.sendDirectEmail("mail", model);

		model.setContent("topic mail.A");
		service.sendTopicEmail("mail.A", model);

		model.setContent("topic mail.B");
		service.sendTopicEmail("mail.B", model);
		// 接收不到的消息
		model.setContent("topic mailA");
		service.sendTopicEmail("mailA", model);

		model.setContent("manualTopic mailManul.A");
		service.sendTopicEmail("mailManul.A", model);
		// 接收不到的消息
		model.setContent("manualTopic mailManulA");
		service.sendTopicEmail("mailManulA", model);

		System.out.println("======================send success==============================");

		Thread.sleep(500000);
		context.close();
	}
}
