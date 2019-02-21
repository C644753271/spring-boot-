package com.duoqio.cloud.orm.jpa.autoconfigure;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.context.annotation.Configuration;

import com.duoqio.cloud.orm.jpa.repository.BaseRepositoryFactoryBean;
import com.duoqio.cloud.orm.jpa.repository.BaseRepositoryImpl;

/**
 * 
 *************************************************
 * 功能描述:  Jpa的自动配置类                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2018年7月27日 创建文件                                             
 * @see     自动配置org.springframework.boot.autoconfigure.orm.jpa.JpaRepositoriesAutoConfiguration                   
 *************************************************
 */
@Configuration
@ConditionalOnBean(DataSource.class)
@ConditionalOnClass({JpaBaseConfiguration.class,HibernateJpaAutoConfiguration.class,BaseRepositoryImpl.class,BaseRepositoryFactoryBean.class})
public class JpaRepositoryConfiguration {

//	@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
	static class EnableBaseRepository{
		
	}
	
}
