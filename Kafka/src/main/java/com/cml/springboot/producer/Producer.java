package com.cml.springboot.producer;

import com.cml.springboot.message.TestMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private final KafkaTemplate<Object, Object> kafkaTemplate;

    public Producer(KafkaTemplate<Object, Object> kafkaTemplate) {
        super();
        this.kafkaTemplate = kafkaTemplate;
    }

//	public void send(TestMessage message) {
//		this.kafkaTemplate.send("test2", message);
//		System.out.println("Sent sample message [" + message + "]");
//	}

    public void send(String message) {
        this.kafkaTemplate.send("test2", message);
        System.out.println("11111111111 Sent sample str message [" + message + "]");
    }

    public void send2(String message) {
        TestMessage testMessage = new TestMessage(11, message);
        this.kafkaTemplate.send("test2", testMessage);
        System.out.println("22222222222 Sent2 sample str message [" + testMessage + "]");
    }

}