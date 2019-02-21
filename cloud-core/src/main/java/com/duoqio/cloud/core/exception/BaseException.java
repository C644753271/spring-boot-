package com.duoqio.cloud.core.exception;

import com.duoqio.cloud.core.constant.SystemConstant;

/**
 * 
 *************************************************
 * 功能描述:  自定义异常,用于项目抛出自定义信息的异常                 
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年1月8日 创建文件                                             
 * @see                        
 *************************************************
 */
public class BaseException extends RuntimeException {

	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 1L;

	/** 异常码 **/
	private int errorCode = SystemConstant.DEFAULT_ERROR_CODE;
	
	/** 异常消息 **/
	private String errorMessage;

	public BaseException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public BaseException(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
