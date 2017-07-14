package com.cml.learning.rabbitmq.spring;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.cml.learning.rabbitmq.spring.model.EmailModel;
import com.cml.learning.rabbitmq.spring.service.MailService;

@EnableRabbit
@SpringBootApplication
@PropertySources({ @PropertySource("classpath:config/rabbitmq/rabbitmq.properties") })
public class Application {
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		MailService service = context.getBean(MailService.class);

		// 发送次数的标识，每次执行后累加
		int time = 6;

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

		Thread.sleep(2000);
		context.close();
	}
}
