package com.cml.learning.rabbitmq.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class MailService {
	private RabbitTemplate rabbitTemplate;

	public boolean sendMsg(String from, String to, String msg) {
		rabbitTemplate.convertAndSend("newquene", msg);
		return false;
	}

	public RabbitTemplate getRabbitTemplate() {
		return rabbitTemplate;
	}

	public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

}
