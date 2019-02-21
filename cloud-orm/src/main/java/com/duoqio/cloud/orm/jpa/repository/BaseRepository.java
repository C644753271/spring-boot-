package com.duoqio.cloud.orm.jpa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 
 *************************************************
 * 功能描述:  自定义拓展Jpa所提供的Repository                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2018年7月27日 创建文件                                             
 * @see                        
 *************************************************
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

}
