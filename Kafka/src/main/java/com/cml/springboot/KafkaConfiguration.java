package com.cml.springboot;

import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.AbstractMessageListenerContainer.AckMode;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.config.ContainerProperties;

//@Configuration
public class KafkaConfiguration {

//	@Bean(name = "stringConsumerFactory")
//	public DefaultKafkaConsumerFactory<Object, Object> stringConsumerFactory(KafkaProperties pro) {
//		Map<String, Object> proMap = pro.buildConsumerProperties();
//		proMap.put("enable.auto.commit", false);
//		System.out.println("promap===>" + proMap);
//		DefaultKafkaConsumerFactory<Object, Object> factory = new DefaultKafkaConsumerFactory<>(proMap);
//		return factory;
//	}
//
//	@Bean(initMethod = "doStart")
//	public KafkaMessageListenerContainer<Object, Object> kafkaMessageListenerContainer(
//			@Qualifier("stringConsumerFactory") ConsumerFactory<Object, Object> consumerFactory, ManualAcknoledgeListener manualConsumer) {
//		ContainerProperties properties = new ContainerProperties("test2");
//		properties.setAckMode(AckMode.MANUAL);
//		properties.setMessageListener(manualConsumer);
//		KafkaMessageListenerContainer<Object, Object> container = new KafkaMessageListenerContainer<>(consumerFactory, properties);
//		return container;
//	}
}
