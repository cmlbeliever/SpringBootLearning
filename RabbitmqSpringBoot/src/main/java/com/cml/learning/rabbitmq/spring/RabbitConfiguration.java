package com.cml.learning.rabbitmq.spring;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
	@Autowired
	private ConnectionFactory connectionFactory;

	@Bean
	public Jackson2JsonMessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	/**
	 * 设置消息转换器为json转换
	 * 
	 * @param configurer
	 * @return
	 */
	@Bean
	public SimpleRabbitListenerContainerFactory myFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		factory.setMessageConverter(jsonMessageConverter());
		return factory;
	}

	@Bean
	public SimpleRabbitListenerContainerFactory manualFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		factory.setMessageConverter(jsonMessageConverter());
		factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		return factory;
	}
	
	@Bean
	public RabbitAdmin rabbitAdmmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	/******************* queue *********************************/
	@Bean
	public Queue topicQueue() {
		return new Queue("manualTopicQuene");
	}

	@Bean
	public Queue mailFanoutQuene() {
		return new Queue("mailFanoutQuene");
	}

	@Bean
	public Queue directQueue() {
	 return new Queue("maildirectQuene");
	}


	/******************* queue *********************************/

	/******************* exchange *********************************/

	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("mailFanout");
	}

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange("manualTopic");
	}

	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange("maildirect");
	}

	@Bean
	public Binding topicBinding(TopicExchange topicExchange, Queue topicQueue) {
		return BindingBuilder.bind(topicQueue).to(topicExchange).with("mailManul.*");
	}

	@Bean
	public Binding directBinding(DirectExchange directExchange, Queue directQueue) {
		return BindingBuilder.bind(directQueue).to(directExchange).with("mail");
	}

	@Bean
	public Binding fanoutBinding(FanoutExchange fanout, Queue mailFanoutQuene) {
		return BindingBuilder.bind(mailFanoutQuene).to(fanout);
	}
	/******************* exchange *********************************/
}
