package com.cml.learning.rabbitmq.spring.receiver;

import com.cml.learning.rabbitmq.spring.model.EmailModel;

public class TopicManualACKMessageReceiver extends AbstractEmailReceiver {

	@Override
	public boolean handle(EmailModel t) {
		logger.info("TopicManualACKMessageReceiver:" + t.toString());
		return true;
	}

}
