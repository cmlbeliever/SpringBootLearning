# rabbitmq项目说明 #
    通过pringBoot方式整合，完成rabbitmq基本消息发送与接收功能,TODO

# 项目运行要求 #
- 正确安装好rabbitmq
- 正确配置好config/rabbitmq/rabbitmq.properties中rabbitmq连接信息

# 基于docker的rabbitmq环境安装 #
1. 获取镜像： docker pull rabbitmq:management
2. 执行镜像
docker run -d --name rabbitmq --publish 5671:5671 \
--publish 5672:5672 --publish 4369:4369 --publish 25672:25672 --publish 15671:15671 --publish 15672:15672 \rabbitmq:management
1. 查看docker容器ip:docker-machine ip
2. 根据获取的ip，在浏览器上访问:http://${ip}:15672 打开管理页面，则说明rabbitmq安装成功
![](screenshots/rabbit-admin.png)

# 整合SpringBoot工程说明 #

# src/main/resource说明 #
1. config/rabbitmq/rabbitmq.properties是对rabbitmq的基本信息配置
2. application.properties 是SpringBoot配置文件
3. logback-spring.xml为log配置文件，默认为INFO级别的控制台输出。

# 项目运行 #
- 直接运行Application类，可以看到控制台发送消息与接收消息的log。发送Rabbitmq消息，已有fanout,direct,topic。




