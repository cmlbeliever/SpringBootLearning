package com.cml.learning.rabbitmq.spring.receiver;

import com.cml.learning.rabbitmq.spring.model.EmailModel;

public class FanoutMessageReceiver extends AbstractEmailReceiver {

	@Override
	public boolean handle(EmailModel t) {
		logger.info("FanoutMessageReceiver:"+t.toString());
		return false;
	}

}
