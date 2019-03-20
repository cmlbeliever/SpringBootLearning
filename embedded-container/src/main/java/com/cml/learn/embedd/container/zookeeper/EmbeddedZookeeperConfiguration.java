package com.cml.learn.embedd.container.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmbeddedZookeeperConfiguration {

    @Bean(destroyMethod = "stop", initMethod = "start")
    public EmbeddedZooKeeper embeddedZooKeeper() {
        return new EmbeddedZooKeeper();
    }

    @Bean(destroyMethod = "close", initMethod = "start")
    public CuratorFramework zkCuratorFramework() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000, 5);
        return CuratorFrameworkFactory.builder().retryPolicy(retryPolicy)
                .connectString("localhost:2181")
                .connectionTimeoutMs(1000)
                .sessionTimeoutMs(1000)
                .build();
    }
}
