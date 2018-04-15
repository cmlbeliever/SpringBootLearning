package com.cml.springboot.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.cml.springboot.message.TestMessage;

@Component
class Consumer {

	@KafkaListener(topics = "test1")
	public void processMessage(TestMessage message) {
		System.out.println("Received sample message [" + message + "]");
	}

}