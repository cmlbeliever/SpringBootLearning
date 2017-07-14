package com.cml.learning.rabbitmq.spring.receiver;

import com.cml.learning.rabbitmq.spring.model.EmailModel;

public class TopicMessageReceiver extends AbstractEmailReceiver{

	@Override
	public boolean handle(EmailModel t) {
		logger.info("TopicMessageReceiver:"+t.toString());
		return false;
	}

}
