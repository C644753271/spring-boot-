package com.duoqio.cloud.mvc.springmvc.autoconfigure.submit;

import java.lang.reflect.Method;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.duoqio.cloud.core.result.GeneralResult;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *************************************************
 * 功能描述:  更改Spring mvc @ResponseBody 中的值                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年1月21日 创建文件                                             
 * @see                        
 *************************************************
 */
@Slf4j
@ControllerAdvice
public class ResponseBodyAdviceToken implements ResponseBodyAdvice<GeneralResult> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		log.debug("advice to responseBody method");
		//获取到方法上对应的参数
		Method method = returnType.getMethod();
		Token token = method.getAnnotation(Token.class);
		//判断是否需要执行beforeBodyWrite方法
		if(! Objects.isNull(token) && token.createToken() == true){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public GeneralResult beforeBodyWrite(GeneralResult body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		log.debug("put token to result");
		//获取到HttpServletResponse
		ServletServerHttpResponse responseTemp = (ServletServerHttpResponse) response;
		@SuppressWarnings("unused")
		HttpServletResponse servletResponse = responseTemp.getServletResponse();
		//获取到HttpServletRequest
		ServletServerHttpRequest requestTemp = (ServletServerHttpRequest) request;
		HttpServletRequest servletRequest = requestTemp.getServletRequest();
		if(body instanceof GeneralResult){
			Object token = servletRequest.getSession().getAttribute("token");
			if(! Objects.isNull(token)){
				body.setToken(token.toString());
			}
		}
		return body;
	}

}
