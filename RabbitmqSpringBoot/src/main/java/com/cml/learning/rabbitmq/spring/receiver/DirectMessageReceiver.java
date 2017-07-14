package com.cml.learning.rabbitmq.spring.receiver;

import com.cml.learning.rabbitmq.spring.model.EmailModel;

public class DirectMessageReceiver extends AbstractEmailReceiver {

	@Override
	public boolean handle(EmailModel t) {
		logger.info("DirectMessageReceiver:"+t.toString());
		return false;
	}

}
