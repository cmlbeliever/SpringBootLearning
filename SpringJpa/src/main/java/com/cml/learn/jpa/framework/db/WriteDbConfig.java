package com.cml.learn.jpa.framework.db;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

//@EnableJpaRepositories(value = "com.cml.learn.jpa", entityManagerFactoryRef = "writeEntityManagerFactory", transactionManagerRef = "writeTransactionManager")
//@Configuration
public class WriteDbConfig {

	@Autowired
	JpaProperties jpaProperties;

	@Autowired
	@Qualifier("writeableDataSource")
	private DataSource writeDataSource;

	@Primary
	@Bean(name = "writeableDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource writeDataSource() {
		System.out.println("===================================================================");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setRemoveAbandoned(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setTimeBetweenEvictionRunsMillis(30000);
		dataSource.setNumTestsPerEvictionRun(30);
		dataSource.setMinEvictableIdleTimeMillis(1800000);
		return dataSource;
	}

	/**
	 * 我们通过LocalContainerEntityManagerFactoryBean来获取EntityManagerFactory实例
	 * 
	 * @return
	 */
	@Bean(name = "writeEntityManagerFactoryBean")
	@Primary
	public LocalContainerEntityManagerFactoryBean writeEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(writeDataSource).properties(jpaProperties.getProperties())
				.packages("com.cml.learn.jpa.db.bean", "com.cml.learn.jpa.dto") // 设置实体类所在位置
				.persistenceUnit("writePersistenceUnit").build();
	}

	/**
	 * EntityManagerFactory类似于Hibernate的SessionFactory,mybatis的SqlSessionFactory
	 * 总之,在执行操作之前,我们总要获取一个EntityManager,这就类似于Hibernate的Session,
	 * mybatis的sqlSession.
	 * 
	 * @param builder
	 * @return
	 */
	@Bean(name = "writeEntityManagerFactory")
	@Primary
	public EntityManagerFactory writeEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return this.writeEntityManagerFactoryBean(builder).getObject();
	}

	/**
	 * 配置事物管理器
	 * 
	 * @return
	 */
	@Bean(name = "writeTransactionManager")
	@Primary
	public PlatformTransactionManager writeTransactionManager(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(writeEntityManagerFactory(builder));
	}
}
