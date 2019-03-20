package com.cml.learn.embedd.container.redis;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RedisTest implements ApplicationRunner {

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("-----------------------redis----------------");
        RBucket<Object> testKey = redissonClient.getBucket("testKey");
        testKey.set("myValue:" + System.currentTimeMillis());

        System.out.println(redissonClient.getBucket("testKey").get());
        System.out.println("-----------------------redis----------------");

    }
}
