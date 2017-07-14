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


