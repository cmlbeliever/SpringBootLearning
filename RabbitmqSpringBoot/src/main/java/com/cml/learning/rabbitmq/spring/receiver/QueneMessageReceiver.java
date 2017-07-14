package com.cml.learning.rabbitmq.spring.receiver;

import com.cml.learning.rabbitmq.spring.model.EmailModel;

public class QueneMessageReceiver extends AbstractEmailReceiver{

	@Override
	public boolean handle(EmailModel t) {
		return false;
	}

}
