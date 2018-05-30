# SpringBoot Learning #

此项目主要作为SpringBoot学习，和根据实际项目对SpringBoot进行配置改造
主要使用框架：SpringBoot(Spring,SpringMVC),Mybatis,ehcache,javamail

# 项目结构 #
 - **程序入口**
> com.cml.springboot.consumer.BootApplication

 - **核心配置**
> com.cml.springboot.framework 是核心包，取代原有的xml配置，将xml配置等价转换为注解配置！ 

 - **demo代码**
> com.cml.springboot.sample为测试使用的代码，主要结构为Controller,bean,db,service几个常用的包层级。

 - **db**
> db文件夹下为demo工程的数据库ddl

# 执行程序 #
 详见：wiki Home page
# 分支说明 #

 1. master 

 >    主要分支，模拟常用api功能。

 2. branch_learn

  >   初始化分支，混杂各种spring boot学习代码，未做具体区分

 3. branch_shiro
    
  >   整合shiro框架，实现授权，认证与自定义拦截器授权处理
  
 4. deploy_jar_bugfind 
    
  >   查找与解决打包jar后Mybatis扫描问题
  
 5. branch_i18n 
    
  >   国际化支持
  
 6. branch_mail
    
  >   邮件发送功能整合，注意需要在config/application.properties配置邮箱服务密码
  
 7. branch-mybatis-scanner 
    
  >   添加Mybatis MapperScan动态扫描（占位符）功能 ，详情见博客：http://blog.csdn.net/cml_blog/article/details/65658654
  
 8. branch-mybatis-generate 
    
  >   mybatis beans生成工具，默认日期类型为DateTime类型，入口类：com.cml.springboot.sample.mbg.MybatisGenerateEntrance 
  
  
#问题与解决
1、Mybatis打包jar后无法扫描到bean与mapper问题，解决对应地址http://blog.csdn.net/cml_blog/article/details/53138851
2、163发送邮件功能问题，解决对应地址http://blog.csdn.net/cml_blog/article/details/54235510

# 当前分支（master）测试说明 #
  >  详见demo.html
  >   端口号为2222，可在config/application.properties 中server.port进行配置  

# 更多信息请查看wiki #
  

