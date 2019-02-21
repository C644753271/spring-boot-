package com.duoqio.cloud.datasource.druid.autoconfigure;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.alibaba.druid.pool.DruidDataSource;
import com.duoqio.cloud.datasource.druid.properties.DruidStatProperties;
import com.duoqio.cloud.datasource.druid.stat.DruidFilterConfiguration;
import com.duoqio.cloud.datasource.druid.stat.DruidSpringAopConfiguration;
import com.duoqio.cloud.datasource.druid.stat.DruidStatViewServletConfiguration;
import com.duoqio.cloud.datasource.druid.stat.DruidWebStatFilterConfiguration;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *************************************************
 * 功能描述:  自动配置切换数据源                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年1月4日 创建文件                                             
 * @see                        
 *************************************************
 */
@Configuration
@ConditionalOnClass(DruidDataSource.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@EnableConfigurationProperties({DruidStatProperties.class, DataSourceProperties.class})
@Import({DruidSpringAopConfiguration.class,
    DruidStatViewServletConfiguration.class,
    DruidWebStatFilterConfiguration.class,
    DruidFilterConfiguration.class})
@Slf4j
public class DataSourceAutoConfigure {
	
	/** 数据源配置信息 **/
	private DataSourceProperties dataSourceProperties;
	
	public DataSourceAutoConfigure(DataSourceProperties dataSourceProperties) {
		this.dataSourceProperties = dataSourceProperties;
	}

	/**
	 * 创建数据源
	 * @return
	 */
	@Bean
    @ConditionalOnMissingBean
    public DataSource dataSource() {
		log.info("dataSourceType is :" + dataSourceProperties.getType().getName());
		dataSourceProperties.getType();
		DataSource dataSource = null;
		if(dataSourceProperties.getType() == DruidDataSourceWrapper.class) {
			log.info("Init DruidDataSource");
			dataSource = new DruidDataSourceWrapper();
			DruidDataSourceWrapper dataSourceWrapper = (DruidDataSourceWrapper) dataSource;
			try {
				dataSourceWrapper.init();
			} catch (SQLException e) {
				log.error("init Druid DataSource failed, exception message is : " + e.getMessage());
				throw new RuntimeException("init Druid DataSource failed");
			}
		}else{
			log.info("Init dataSource " + dataSourceProperties.getType().getName());
			dataSource = createDataSource(dataSourceProperties, dataSourceProperties.getType());
		}
        return dataSource;
    }
	
	/**
	 * 根据所传入的类型创建对应的数据源连接池
	 * @param properties
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> T createDataSource(DataSourceProperties properties,
			Class<? extends DataSource> type) {
		return (T) properties.initializeDataSourceBuilder().type(type).build();
	}
	
}
