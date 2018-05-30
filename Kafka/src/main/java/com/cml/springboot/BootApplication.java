package com.cml.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.cml.springboot.kafka.Producer;

@SpringBootApplication
@EnableScheduling
@EnableKafka
public class BootApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(BootApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        // app.setWebEnvironment(false);
        app.run(args);
//		SpringApplication.run(BootApplication.class, args);
    }

    @Autowired
    private Producer producer;

    @Scheduled(fixedRate = 5_000)
    public void scheduleSendMessage() {
//        producer.send((Math.random() * 1000) + "A simple test message");
        producer.send2((Math.random() * 1000) + "A simple test message");
    }

    // @Bean
    // public ConcurrentKafkaListenerContainerFactory
    // myKafkaListenerContainerFactory() {
    // ConcurrentKafkaListenerContainerFactory factory = new
    // ConcurrentKafkaListenerContainerFactory();
    // factory.setConcurrency(4);
    // return factory;
    // }

    // @Bean
    // public ApplicationRunner runner(Producer producer) {
    // return (args) -> {
    // new Thread(() -> {
    // int i = 0;
    // while (i < 10) {
    // producer.send(new TestMessage(1, "A simple test message" + i++));
    // try {
    // Thread.sleep(1000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // }
    // }).start();
    //
    // };
    // }
}
