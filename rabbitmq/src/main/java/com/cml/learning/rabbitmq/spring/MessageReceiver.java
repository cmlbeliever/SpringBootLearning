package com.cml.learning.rabbitmq.spring;

import org.springframework.amqp.core.Message;

import com.rabbitmq.client.Channel;

public class MessageReceiver {

	public void onMessageArrived(String msg) throws Exception {

		try {
			System.out.println("MessageReceiver.onMessageArrived:" + msg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	public void onMessage(Message message, Channel channel) throws Exception {
		String msg = new String(message.getBody());

		try {
			System.out.println("MessageReceiver.onReceiveMessage:" + msg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 确认消息
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}
	}

}
