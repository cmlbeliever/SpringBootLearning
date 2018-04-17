package com.cml.springboot.kafka;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.cml.springboot.message.TestMessage;

@KafkaListener(topics = "test2")
@Component
class Consumer {

	@KafkaHandler()
	public void processMessage(TestMessage message) {
		if (message.getCode() < 200) {
			throw new IllegalArgumentException("code must gt 200 [" + message.getCode() + "]");
		}
		System.out.println("Received sample message [" + message + "]");
	}
	// @KafkaHandler()
	// public void processMessage(Acknowledgment ack, TestMessage message) {
	// System.out.println("Received sample message [" + message + "]" + ack);
	// }

}