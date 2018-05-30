package com.cml.springboot.consumer;

import com.cml.springboot.message.TestMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
class Consumer {

//    @KafkaListener(topics = "test2")
//    public void processMessage(String message) throws Exception {
//        System.out.println("processMessage receivced sample message [" + message + "] threadId:" + Thread.currentThread().getId());
//
//    }

    @KafkaListener(topics = "test2")
    public void processMessage2(TestMessage testMessage) throws Exception {
        System.out.println("processMessage2 receivced sample message [" + testMessage.toString() + "] threadId:" + Thread.currentThread().getId());
//        Thread.sleep(100);
//        if (Math.random() < 0.5)
//            throw new Exception("出错了:" + testMessage.toString());

    }
//	@KafkaListener(topics = "test2")
//	public void processMessage(ConsumerRecord<Object, Object> message) throws Exception {
//		message.headers().forEach(t -> {
//			System.out.println("header:" + t.key() + ":" + new String(t.value()));
//		});
//		System.out.println("Received sample message [" + message + "] threadId:" + Thread.currentThread().getId());
//
//	}

}