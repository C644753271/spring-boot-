package com.duoqio.cloud.mvc.springmvc.autoconfigure.submit;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.duoqio.cloud.core.result.GeneralResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *************************************************
 * 功能描述:  防止重复提交的拦截器                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年1月9日 创建文件                                             
 * @see                        
 *************************************************
 */
@Configuration
@Slf4j
public class AvoidDuplicateSubmissionInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 预处理器
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取到方法上的注解
		Token annotation = getAnnotation(handler, Token.class);
		//说明方法需要进行拦截
		if(Objects.isNull(annotation)) {
			return true;
		}
		log.debug("deal submit");
		
		//是否需要验证创建口令
		boolean needSaveSession = annotation.createToken();
		//是否移除口令
		boolean needRemoveSession = annotation.needRemoveToken();
		//是否检查口令并修改口令的值
		boolean checkAndUpdateToken = annotation.checkAndUpdateToken();
		if(needSaveSession == true) {
			//创建口令
			request.getSession(false).setAttribute("token", UUID.randomUUID().toString());
		}else if(needRemoveSession == true) {
			//移除口令
			if(!isValidSubmit(request)){
				//进行对应的异常提示
				errorHandler(response);
				return false;
			}
			//移除session
			request.getSession(false).removeAttribute("token");
		}else if(checkAndUpdateToken == true){
			//检查口令并修改口令的值
			if(!isValidSubmit(request)){
				//进行对应的异常提示
				errorHandler(response);
				return false;
			}
			String token = UUID.randomUUID().toString();
			request.getSession().setAttribute("token", token);
			return true;
		}
		return true;
	}
	
	/**
	 * 后置处理器
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//获取到方法上的注解
		Token annotation = getAnnotation(handler, Token.class);
		if (! Objects.isNull(annotation)) {
			if(! Objects.isNull(modelAndView) && annotation.createToken()){
				log.info("token to client");
				Object token = request.getSession().getAttribute("token");
				if(token != null)
					modelAndView.addObject("token", token.toString());
			}
		}
	}
	
	/**
	 * 获取到方法上的注解
	 * @param handler
	 * @param annotation
	 * @return
	 */
	private <T extends Annotation> T getAnnotation(Object handler, Class<T> annotation) {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		T token = method.getAnnotation(annotation);
		return token;
	}
	
	/**
	 * 校验是否重复提交
	 * @param request
	 * @return
	 */
	private boolean isValidSubmit(HttpServletRequest request){
		log.warn("不正确的提交方式：[user:" + request.getRemoteUser() + ",url:" + request.getServletPath() + "]");
		//校验是否存在token
		Object token = request.getSession().getAttribute("token");
		if (Objects.isNull(token))
			return false;
		//获取到服务器端的token和客户端所提交的token进行比对
		String serverToken = WebUtils.getSessionAttribute(request, "token").toString();
		String clientToken = request.getParameter("token");
		if(Objects.isNull(clientToken))
			return false;
		if(!serverToken.equals(clientToken))
			return false;
		return true;
	}
	
	/**
	 * 进行对应的异常处理
	 * @param response
	 * @throws IOException 
	 */
	private void errorHandler(HttpServletResponse response) throws IOException{
		GeneralResult result = new GeneralResult(-1, "错误的提交方式");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		writer.write(mapper.writeValueAsString(result));
		writer.close();
	}
}
