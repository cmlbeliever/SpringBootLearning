package com.cml.learn.embedd.container.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import redis.embedded.RedisServer;

import java.io.IOException;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisServer redisServer() throws IOException {
        RedisServer redisServer = new RedisServer(6379);
        redisServer.start();
        return redisServer;
    }

    @Bean
    @DependsOn({"redisServer"})
    public RedissonClient createRedisson() throws InterruptedException {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379")
                .setTimeout(1000);
        return Redisson.create(config);
    }
}
