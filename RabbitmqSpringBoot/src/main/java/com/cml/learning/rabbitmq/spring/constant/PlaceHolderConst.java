package com.cml.learning.rabbitmq.spring.constant;

public interface PlaceHolderConst {
	interface Queues {
		String manualTopicQueue = "${rabbitmq.exchange.manualTopic.queue}";
		String mailDirectQueue = "${rabbitmq.exchange.direct.queue}";
		String mailFanoutQueue = "${rabbitmq.exchange.fanout.queue}";
	}

	interface Exchanges {
		String mailFanoutExchange = "${rabbitmq.exchange.fanout}";
		String manualTopicExchange = "${rabbitmq.exchange.manualTopic}";
		String maildirectExchange = "${rabbitmq.exchange.direct}";
	}

	interface Routes {
		String mailTopicRoute = "${rabbitmq.exchange.manualTopic.route}";
		String mailDirectRoute = "${rabbitmq.exchange.direct.route}";
	}
}
