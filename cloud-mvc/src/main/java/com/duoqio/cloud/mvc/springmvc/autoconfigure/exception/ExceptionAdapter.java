package com.duoqio.cloud.mvc.springmvc.autoconfigure.exception;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duoqio.cloud.core.constant.SystemConstant;
import com.duoqio.cloud.core.exception.BaseException;
import com.duoqio.cloud.core.result.GeneralResult;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *************************************************
 * 功能描述:  定义异常建言                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年1月8日 创建文件                                             
 * @see                        
 *************************************************
 */
@ControllerAdvice
@Slf4j
public class ExceptionAdapter {

	@ExceptionHandler(Exception.class)
	public @ResponseBody GeneralResult handlerException(Exception exception, HttpServletRequest request) {
		//获取到异常的信息
		String errorMessage = buildErrorTips(exception);
		GeneralResult result = null;
		if(isAjaxRequest(request)){
			// ajax请求 异常处理
			result = this.handleExceptionOfAjaxRequest(errorMessage);
		}else{
			// 普通请求 异常处理
			result = this.handleExceptionOfNormalRequest(errorMessage);
		}
		return result;
	}
	
	/**
	 * 组装给用户提示的异常消息
	 * @param e
	 * @return
	 */
	private String buildErrorTips(Exception e){
		// 给用户提示的数据
		String errorMessage = "亲，系统出错了！请联系管理员！";
		// 判断异常的类型 如果是BaseException
		if(e instanceof BaseException){
			BaseException be = (BaseException) e;
			// 拿到错误消息和码
			errorMessage = be.getErrorMessage();
			int errorCode = be.getErrorCode();
			// 若错误小于0，则在错误消息中添加错误用于提示
			if(errorCode < 0){
				errorMessage = errorMessage + "错误码：" + errorCode;
			}
		}else if(e instanceof BindException){
			//说明是数据绑定异常
			BindException be = (BindException) e;
			List<ObjectError> fieldErrors = be.getAllErrors();
			StringBuffer fieldErrorMessages = new StringBuffer();
			fieldErrors.forEach(fieldError -> fieldErrorMessages.append(fieldError.getDefaultMessage()));
		}
		return errorMessage;
	}
	
	
	/**
	 * 判断请求是否是Ajax请求
	 * @param request
	 * @return true表示ajax请求  false表示其他类型请求
	 */
	private boolean isAjaxRequest(HttpServletRequest request){
		String requestWith = request.getHeader("X-Requested-With");
		log.info("获取到的请求头是"+requestWith);
		// 比较忽略大小写 
		if("XMLHttpRequest".equalsIgnoreCase(requestWith)){
			return true;
		}
		return false;
	}
	
	
	/**
	 * 处理普通请求异常
	 * 直接将errorMessage放入request作用域
	 * @param request
	 * @param errorMessage
	 */
	private GeneralResult handleExceptionOfNormalRequest(String errorMessage){
		// 普通请求
		// 拿到将要执行Action的result属性
		GeneralResult result = new GeneralResult(SystemConstant.DEFAULT_ERROR_CODE, errorMessage);
		log.info("设置的普通请求返回结果为：错误码："+result.getCode()+",错误信息为："+result.getMessage());
		return result;
	}
	
	
	/**
	 * 处理Ajax请求异常
	 * 将错误消息封装GeneralResult对象
	 * @param invocation
	 * @param errorMessage
	 */
	private GeneralResult handleExceptionOfAjaxRequest(String errorMessage){
		// 拿到将要执行Action的result属性
		GeneralResult result = new GeneralResult(SystemConstant.DEFAULT_ERROR_CODE, errorMessage);
		log.info("设置的Ajax返回结果为：错误码："+result.getCode()+",错误信息为："+result.getMessage());
		return result;
	}

	
}
