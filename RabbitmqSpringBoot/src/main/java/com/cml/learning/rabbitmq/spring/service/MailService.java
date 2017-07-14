package com.cml.learning.rabbitmq.spring.service;

import com.cml.learning.rabbitmq.spring.model.EmailModel;

public interface MailService {
	void sendTopicEmail(String routeKey,EmailModel model);

	void sendDirectEmail(String routeKey,EmailModel model);

	void sendFanoutEmail(String routeKey,EmailModel model);
}
