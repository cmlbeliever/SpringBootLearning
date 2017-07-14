package com.cml.learning.rabbitmq.spring.receiver;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.cml.learning.rabbitmq.spring.model.EmailModel;
import com.rabbitmq.client.Channel;

@Component
public class MessageReceiver {
	@RabbitListener(queues = "mailTopicQuene")
	public void processMessage(EmailModel content, Channel channel, Message message) {
		System.out.println("收到消息==============================" + content);
		// AmqpRejectAndDontRequeueException
		// throw new AmqpRejectAndDontRequeueException("不要啦");
	}
}
