package com.cml.springboot.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableScheduling
@EnableKafka
public class ProducerBootApplication {

    private List<String> data = Arrays.asList("1111", "2222", "3333", "44444", "5555");

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(ProducerBootApplication.class);
        app.run(args);
//		SpringApplication.run(BootApplication.class, args);
    }

    @Autowired
    private Producer producer;

    private int index = 10;

    @Scheduled(fixedRate = 1)
    public void scheduleSendMessage() {
        System.out.println("<----scheduled--->");
        data.stream().map(t -> t + "-" + index).forEach(t -> {
            producer.send2(t);
        });
        index++;
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
