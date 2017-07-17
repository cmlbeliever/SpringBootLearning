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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cml.learning.rabbitmq.spring.constant.PlaceHolderConst;

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
	public Queue topicQueue(@Value(PlaceHolderConst.Queues.manualTopicQueue) String queue) {
		return new Queue(queue);
	}

	@Bean
	public Queue mailFanoutQuene(@Value(PlaceHolderConst.Queues.mailFanoutQueue) String queue) {
		return new Queue(queue);
	}

	@Bean
	public Queue directQueue(@Value(PlaceHolderConst.Queues.mailDirectQueue) String queue) {
		return new Queue(queue);
	}

	/******************* queue *********************************/

	/******************* exchange *********************************/

	@Bean
	public FanoutExchange fanoutExchange(@Value(PlaceHolderConst.Exchanges.mailFanoutExchange) String exchange) {
		return new FanoutExchange(exchange);
	}

	@Bean
	public TopicExchange topicExchange(@Value(PlaceHolderConst.Exchanges.manualTopicExchange) String exchange) {
		return new TopicExchange(exchange);
	}

	@Bean
	public DirectExchange directExchange(@Value(PlaceHolderConst.Exchanges.maildirectExchange) String exchange) {
		return new DirectExchange(exchange);
	}

	@Bean
	public Binding topicBinding(TopicExchange topicExchange, Queue topicQueue, @Value(PlaceHolderConst.Routes.mailTopicRoute) String route) {
		return BindingBuilder.bind(topicQueue).to(topicExchange).with(route);
	}

	@Bean
	public Binding directBinding(DirectExchange directExchange, Queue directQueue, @Value(PlaceHolderConst.Routes.mailDirectRoute) String route) {
		return BindingBuilder.bind(directQueue).to(directExchange).with(route);
	}

	@Bean
	public Binding fanoutBinding(FanoutExchange fanout, Queue mailFanoutQuene) {
		return BindingBuilder.bind(mailFanoutQuene).to(fanout);
	}
	/******************* exchange *********************************/
}
