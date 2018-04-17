package com.cml.springboot.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.cml.springboot.message.TestMessage;

@Component
public class Producer {

	private final KafkaTemplate<Object, Object> kafkaTemplate;

	public Producer(KafkaTemplate<Object, Object> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	public void send(TestMessage message) {
		this.kafkaTemplate.send("test2", message);
		System.out.println("Sent sample message [" + message + "]");
	}

	public void send(String message) {
		this.kafkaTemplate.send("test2", message);
		System.out.println("Sent sample str message [" + message + "]");
	}

}