package com.cml.learning.rabbitmq.spring.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cml.learning.rabbitmq.spring.model.EmailModel;

@Component
public class MailServiceImpl implements MailService {
	@Autowired
	private AmqpTemplate template;
	@Value("${rabbitmq.exchange.topic}")
	private String topicExchange;
	@Value("${rabbitmq.exchange.direct}")
	private String directExchange;
	@Value("${rabbitmq.exchange.fanout}")
	private String fanoutExchange;

	public MailServiceImpl(AmqpTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public void sendTopicEmail(String routeKey, EmailModel model) {
		template.convertAndSend(topicExchange, routeKey, model);
	}

	@Override
	public void sendDirectEmail(String routeKey, EmailModel model) {
		template.convertAndSend(directExchange, routeKey, model);
	}

	@Override
	public void sendFanoutEmail(String routeKey, EmailModel model) {
		template.convertAndSend(fanoutExchange, routeKey, model);
	}
}
