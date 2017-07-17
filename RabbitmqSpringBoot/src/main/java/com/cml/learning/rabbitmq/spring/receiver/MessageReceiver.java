package com.cml.learning.rabbitmq.spring.receiver;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.cml.learning.rabbitmq.spring.constant.PlaceHolderConst;
import com.cml.learning.rabbitmq.spring.model.EmailModel;
import com.rabbitmq.client.Channel;

@Component
public class MessageReceiver {

	private static final Logger logger = LoggerFactory.getLogger(MessageReceiver.class);

	/**
	 * 需要手动ACK
	 * 
	 * @param content
	 * @param channel
	 * @param message
	 * @throws Exception
	 */
	@RabbitListener(queues = PlaceHolderConst.Queues.manualTopicQueue, containerFactory = "manualFactory")
	public void topicReceiver(EmailModel content, Channel channel, Message message) {
		logger.info("topicReceiver收到消息>>>" + content);
		try {
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RabbitListener(queues = PlaceHolderConst.Queues.mailFanoutQueue)
	public void fanoutReceiver(EmailModel content, Channel channel, Message message) {
		logger.info("fanoutReceiver收到消息>>>" + content);
	}

	@RabbitListener(queues = PlaceHolderConst.Queues.mailDirectQueue)
	public void directReceiver(EmailModel content, Channel channel, Message message) {
		logger.info("directReceiver收到消息>>>" + content);
	}
}
