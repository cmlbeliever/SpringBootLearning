package com.cml.learn.embedd.container.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EmbeddedZookeeperTest implements ApplicationRunner {
    @Autowired
    private CuratorFramework curatorFramework;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("-----------------------zk----------------");

        System.out.println(curatorFramework.getChildren().forPath("/"));
        curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath("/test", "dataValue".getBytes());
        System.out.println("/test 节点数据：" + new String(curatorFramework.getData().forPath("/test")));
        System.out.println("-----------------------zk----------------");

    }
}
