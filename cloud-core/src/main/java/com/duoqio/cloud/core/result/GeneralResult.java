package com.duoqio.cloud.core.result;

import java.io.Serializable;

import com.duoqio.cloud.core.constant.SystemConstant;

/**
 * 
 *************************************************
 * 功能描述:  公用的数据交互实体                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年1月9日 创建文件                                             
 * @see                        
 *************************************************
 */
public class GeneralResult implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;
	
	/** 结果集码 **/
	private int code = SystemConstant.DEFAULT_RESULT_CODE;
	
	/** 结果消息 **/
	private String message;
	
	/** 防止重复提交的Token **/
	private String token;
	
	/** 结果数据 **/
	private Object result;
	
	public GeneralResult() {
		super();
	}

	public GeneralResult(int code) {
		super();
		this.code = code;
	}

	public GeneralResult(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public GeneralResult(int code, Object result) {
		super();
		this.code = code;
		this.result = result;
	}

	public GeneralResult(int code, String message, Object result) {
		super();
		this.code = code;
		this.message = message;
		this.result = result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
