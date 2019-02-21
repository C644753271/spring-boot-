package com.duoqio.cloud.mvc.springmvc.autoconfigure.submit;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface Token {

	/** 是否创建Token **/
	boolean createToken() default false;
	
	/** 是否需要移除Token **/
	boolean needRemoveToken() default false;

	/** 检查并修改Token **/
	boolean checkAndUpdateToken() default false;
}
