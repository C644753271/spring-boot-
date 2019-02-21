package com.duoqio.cloud.mybatis.mybatisplus.autoconfigure;

import java.util.function.Supplier;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.plugins.SqlExplainInterceptor;
import com.baomidou.mybatisplus.spring.boot.starter.MybatisPlusAutoConfiguration;

/**
 * 
 *************************************************
 * 功能描述:  拦截器的自动配置                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年1月8日 创建文件                                             
 * @see                        
 *************************************************
 */
@Configuration
@ConditionalOnClass({MybatisPlusAutoConfiguration.class})
public class InterceptorAutoConfigure {

	/**
	 * MybatisPlus性能分析插件
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean
	public PerformanceInterceptor performanceInterceptor() {
		Supplier<PerformanceInterceptor> supplier = () -> {
			PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
			//sql的最大执行时间
			performanceInterceptor.setMaxTime(1000);
			//是否格式化Sql
			performanceInterceptor.setFormat(true);
			return performanceInterceptor;
		};
		return supplier.get();
	}
	
	/**
	 * MybatisPlus分页插件
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean
	public PaginationInterceptor paginationInterceptor() {
		Supplier<PaginationInterceptor> supplier = PaginationInterceptor::new;
		return supplier.get();
	}
	
	/**
	 * MybatisPlus执行分析插件,只支持MYSQL-5.6.3以上
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean
	public SqlExplainInterceptor sqlExplainInterceptor() {
		SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
		sqlExplainInterceptor.setStopProceed(false);
		return sqlExplainInterceptor;
	}
	
}
