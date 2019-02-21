package com.duoqio.cloud.service;

import java.util.List;

import com.duoqio.cloud.core.exception.BaseException;
import com.duoqio.cloud.entity.OilBrandInfo;

/**
 * 
 *************************************************
 * 功能描述:  油品品牌业务接口                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2018年11月13日 创建文件                                             
 * @see                        
 *************************************************
 */
public interface OilBrandService {

	/**
	 * 查询所有的油类品牌信息
	 * @return
	 * @throws BaseException
	 */
	List<OilBrandInfo> findAllOilBrandInfo() throws BaseException;
	
	/**
	 * 根据油类编号查询出油品牌的信息
	 * @param oilBrandInfo
	 * @return
	 * @throws BaseException
	 */
	OilBrandInfo findOilBrandInfo(OilBrandInfo oilBrandInfo) throws BaseException;
	
}
