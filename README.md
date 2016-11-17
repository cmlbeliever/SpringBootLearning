# SpringBoot Learning #

此项目主要作为SpringBoot学习，和根据实际项目对SpringBoot进行配置改造

# 项目结构 #
 - **程序入口**
> com.cml.springboot.BootApplication

 - **核心配置**
> com.cml.springboot.framework 是核心包，取代原有的xml配置，将xml配置等价转换为注解配置！ 

 - **demo代码**
> com.cml.springboot.sample为测试使用的代码，主要结构为Controller,bean,db,service几个常用的包层级。

 - **db**
> demo工程的数据库ddl


# 分支说明 #

 1. master 

 >    主要分支，模拟常用api功能。

 2. branch_learn

  >   初始化分支，混杂各种spring boot学习代码，未做具体区分

 3. branch_shiro
    
  >   整合shiro框架，实现授权，认证与自定义拦截器授权处理
  
  4. deploy_jar_bugfind 
    
  >   查找与解决打包jar后Mybatis扫描问题
  
#问题与解决
1、Mybatis打包jar后无法扫描到bean与mapper问题，解决对应地址http://blog.csdn.net/cml_blog/article/details/53138851

# 当前分支（master）测试说明 #
  

    
  

