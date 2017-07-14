package com.cml.learning.rabbitmq.spring.receiver;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.cml.learning.rabbitmq.spring.model.EmailModel;
import com.rabbitmq.client.Channel;

@Component
public class MessageReceiver {

	/**
	 * 需要手动ACK
	 * 
	 * @param content
	 * @param channel
	 * @param message
	 * @throws Exception
	 */
	@RabbitListener(queues = "manualTopicQuene", containerFactory = "manualFactory")
	public void topicReceiver(EmailModel content, Channel channel, Message message) {
		System.out.println("topicReceiver收到消息==============================" + content);
		try {
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RabbitListener(queues = "mailFanoutQuene")
	public void fanoutReceiver(EmailModel content, Channel channel, Message message) {
		System.out.println("fanoutReceiver收到消息==============================" + content);
	}

	@RabbitListener(queues = "maildirectQuene")
	public void directReceiver(EmailModel content, Channel channel, Message message) {
		System.out.println("directReceiver收到消息==============================" + content);
	}
}
