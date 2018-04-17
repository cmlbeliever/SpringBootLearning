package com.cml.springboot.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingConsumerAwareMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.cml.springboot.message.TestMessage;

@KafkaListener(topics = "test2")
@Component
public class ManualAcknowledgeConsumer implements AcknowledgingConsumerAwareMessageListener<String, TestMessage> {

	@Override
	public void onMessage(ConsumerRecord<String, TestMessage> data, Acknowledgment acknowledgment, Consumer<?, ?> consumer) {
		System.out.println("onmessage====>");
	}

}
