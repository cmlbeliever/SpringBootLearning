package com.cml.learning.rabbitmq.spring.service;

import org.springframework.amqp.core.AmqpTemplate;

import com.cml.learning.rabbitmq.spring.model.EmailModel;

public class MailServiceImpl implements MailService {
	private AmqpTemplate template;
	private String topicExchange;
	private String directExchange;
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

	public AmqpTemplate getTemplate() {
		return template;
	}

	public void setTemplate(AmqpTemplate template) {
		this.template = template;
	}

	public String getTopicExchange() {
		return topicExchange;
	}

	public void setTopicExchange(String topicExchange) {
		this.topicExchange = topicExchange;
	}

	public String getFanoutExchange() {
		return fanoutExchange;
	}

	public void setFanoutExchange(String fanoutExchange) {
		this.fanoutExchange = fanoutExchange;
	}

	public String getDirectExchange() {
		return directExchange;
	}

	public void setDirectExchange(String directExchange) {
		this.directExchange = directExchange;
	}

}
