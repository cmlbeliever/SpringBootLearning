package com.cml.springboot.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class ManualAcknoledgeListener implements AcknowledgingMessageListener<Object, Object> {

	@Override
	public void onMessage(ConsumerRecord<Object, Object> data, Acknowledgment acknowledgment) {
		System.out.println("=====>接收到data:" + data);
		try {
			// 模拟长时间处理
			// Thread.sleep(1000);
			if (data.offset() % 2 == 1) {
				acknowledgment.acknowledge();
			}
			acknowledgment.acknowledge();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
