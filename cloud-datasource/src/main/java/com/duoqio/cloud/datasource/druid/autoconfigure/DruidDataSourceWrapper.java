package com.duoqio.cloud.datasource.druid.autoconfigure;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.alibaba.druid.filter.config.ConfigFilter;
import com.alibaba.druid.filter.encoding.EncodingConvertFilter;
import com.alibaba.druid.filter.logging.CommonsLogFilter;
import com.alibaba.druid.filter.logging.Log4j2Filter;
import com.alibaba.druid.filter.logging.Log4jFilter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallFilter;

@ConfigurationProperties("spring.datasource.druid")
class DruidDataSourceWrapper extends DruidDataSource implements InitializingBean {

	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private DataSourceProperties basicProperties;

	@Override
	public void afterPropertiesSet() throws Exception {
		// if not found prefix 'spring.datasource.druid' jdbc properties
		// ,'spring.datasource' prefix jdbc properties will be used.
		if (super.getUsername() == null) {
			super.setUsername(basicProperties.determineUsername());
		}
		if (super.getPassword() == null) {
			super.setPassword(basicProperties.determinePassword());
		}
		if (super.getUrl() == null) {
			super.setUrl(basicProperties.determineUrl());
		}
		if (super.getDriverClassName() == null) {
			super.setDriverClassName(basicProperties.getDriverClassName());
		}

	}

	@Autowired(required = false)
	public void addStatFilter(StatFilter statFilter) {
		super.filters.add(statFilter);
	}

	@Autowired(required = false)
	public void addConfigFilter(ConfigFilter configFilter) {
		super.filters.add(configFilter);
	}

	@Autowired(required = false)
	public void addEncodingConvertFilter(EncodingConvertFilter encodingConvertFilter) {
		super.filters.add(encodingConvertFilter);
	}

	@Autowired(required = false)
	public void addSlf4jLogFilter(Slf4jLogFilter slf4jLogFilter) {
		super.filters.add(slf4jLogFilter);
	}

	@Autowired(required = false)
	public void addLog4jFilter(Log4jFilter log4jFilter) {
		super.filters.add(log4jFilter);
	}

	@Autowired(required = false)
	public void addLog4j2Filter(Log4j2Filter log4j2Filter) {
		super.filters.add(log4j2Filter);
	}

	@Autowired(required = false)
	public void addCommonsLogFilter(CommonsLogFilter commonsLogFilter) {
		super.filters.add(commonsLogFilter);
	}

	@Autowired(required = false)
	public void addWallFilter(WallFilter wallFilter) {
		super.filters.add(wallFilter);
	}

}
