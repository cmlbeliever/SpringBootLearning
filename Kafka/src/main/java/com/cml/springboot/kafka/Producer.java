package com.cml.springboot.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.cml.springboot.message.TestMessage;

@Component
public class Producer {

	private final KafkaTemplate<Object, TestMessage> kafkaTemplate;

	Producer(KafkaTemplate<Object, TestMessage> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void send(TestMessage message) {
		this.kafkaTemplate.send("test1", message);
		System.out.println("Sent sample message [" + message + "]");
	}

}