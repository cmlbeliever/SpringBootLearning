package com.cml.springboot.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class Consumer {

	@KafkaListener(topics = "test2")
	public void processMessage(ConsumerRecord<Object, Object> message) throws Exception {
		message.headers().forEach(t -> {
			System.out.println("header:" + t.key() + ":" + new String(t.value()));
		});
		System.out.println("Received sample message [" + message + "] threadId:" + Thread.currentThread().getId());

	}

}