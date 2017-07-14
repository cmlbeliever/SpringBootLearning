package com.cml.learning.rabbitmq.spring.receiver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.MessageConverter;

import com.rabbitmq.client.Channel;

public abstract class AbstractReceiver<T> implements ChannelAwareMessageListener {

	static Log logger=LogFactory.getLog(AbstractReceiver.class);

	private MessageConverter messageConverter;
	private boolean autoACK;

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		boolean successHandle = false;
		try {
			@SuppressWarnings("unchecked")
			T msg = (T) messageConverter.fromMessage(message);
			successHandle = handle(msg);
		} catch (Exception e) {
			logger.error("", e);
		} finally {
			if (successHandle && !autoACK) {
				channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
			}
		}
	}

	/**
	 * 
	 * @param t
	 * @return true 处理成功
	 */
	public abstract boolean handle(T t);

	public MessageConverter getMessageConverter() {
		return messageConverter;
	}

	public void setMessageConverter(MessageConverter messageConverter) {
		this.messageConverter = messageConverter;
	}

	public boolean isAutoACK() {
		return autoACK;
	}

	public void setAutoACK(boolean autoACK) {
		this.autoACK = autoACK;
	}

}
