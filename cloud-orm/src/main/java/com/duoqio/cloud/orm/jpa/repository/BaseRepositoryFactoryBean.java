package com.duoqio.cloud.orm.jpa.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/**
 * 
 *************************************************
 * 功能描述:  Repository创建工厂
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2018年7月27日 创建文件                                             
 * @see                        
 *************************************************
 */
public class BaseRepositoryFactoryBean<R extends JpaRepository<T,I>,T,I extends Serializable> extends JpaRepositoryFactoryBean<R, T, I>{

	public BaseRepositoryFactoryBean(Class<? extends R> repositoryInterface) {
		super(repositoryInterface);
	}

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new BaseRepositoryFactory<>(entityManager);
	}

	/**
	 * 
	 *************************************************
	 * 功能描述:  使用自定义的RepositoryFactory来创建Repository                 
	 * @author  Mr.Chen                   
	 * @version 1.0                
	 * @date    2018年7月27日 创建文件                                             
	 * @see                        
	 *************************************************
	 */
	static class BaseRepositoryFactory<T, ID extends Serializable> extends JpaRepositoryFactory {
		
			private final EntityManager entityManager;
			
			public BaseRepositoryFactory(EntityManager entityManager) {
			    super(entityManager);
			    this.entityManager = entityManager;
			}
			
			//设置具体的实现类是BaseRepositoryImpl
			@SuppressWarnings("unchecked")
			@Override
			protected Object getTargetRepository(RepositoryInformation information) {
			    return new BaseRepositoryImpl<T, ID>((Class<T>) information.getDomainType(), entityManager);
			}
			
			//设置具体的实现类的class
			@Override
			protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			    return BaseRepositoryImpl.class;
			}
	}
	
}
