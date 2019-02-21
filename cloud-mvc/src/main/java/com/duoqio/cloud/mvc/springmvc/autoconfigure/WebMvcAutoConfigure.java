package com.duoqio.cloud.mvc.springmvc.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.duoqio.cloud.mvc.springmvc.autoconfigure.submit.AvoidDuplicateSubmissionInterceptor;

/**
 * 
 *************************************************
 * 功能描述:  web mvc的自动配置类                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年1月8日 创建文件                                             
 * @see                        
 *************************************************
 */
@Configuration
@ConditionalOnClass(WebMvcConfigurer.class)
public class WebMvcAutoConfigure implements WebMvcConfigurer {

	/** 防重复提交的拦截器 **/
	private AvoidDuplicateSubmissionInterceptor avoidDuplicateSubmissionInterceptor;
	
	@Autowired
	public WebMvcAutoConfigure(AvoidDuplicateSubmissionInterceptor avoidDuplicateSubmissionInterceptor) {
		this.avoidDuplicateSubmissionInterceptor = avoidDuplicateSubmissionInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(avoidDuplicateSubmissionInterceptor).addPathPatterns("/**").excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**","/csrf","/");;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
         registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
}
