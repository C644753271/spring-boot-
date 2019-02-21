package com.duoqio.cloud.mvc.api.swagger;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

/**
 * 
 *************************************************
 * 功能描述:  swagger2的自动配置                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年1月10日 创建文件                                             
 * @see                        
 *************************************************
 */
@Configuration
@ConditionalOnClass({EnableSwagger2.class})
@AutoConfigureAfter({Swagger2DocumentationConfiguration.class})
public class SwaggerConfiguration {

	@EnableSwagger2
	static class swaggerAutoConfiguration{
		
	}
	
}
