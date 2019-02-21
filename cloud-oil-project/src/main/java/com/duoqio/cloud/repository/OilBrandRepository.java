package com.duoqio.cloud.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.duoqio.cloud.entity.OilBrandInfo;
import com.duoqio.cloud.orm.jpa.repository.BaseRepository;


/**
 * 
 *************************************************
 * 功能描述:  油类品牌的持久化接口                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2018年11月13日 创建文件                                             
 * @see                        
 *************************************************
 */
@Repository
public interface OilBrandRepository extends BaseRepository<OilBrandInfo, Integer> {
	
	/**
	 * 查询所有的油类品牌
	 * @param sort
	 * @param oilBrandDeleteFlag
	 * @return
	 */
	List<OilBrandInfo> findAllByOilBrandDeleteFlag(Sort sort, Short oilBrandDeleteFlag);

	/**
	 * 根据Id来修改油品牌信息
	 * @param oilBrandName
	 * @param oilBrandId
	 * @return
	 */
	@Query(value = "update oil_brand_info_tbl set oil_brand_name = ?1 where oil_brand_id = ?2", nativeQuery = true)
	@Modifying
	int modOilBrandById(String oilBrandName, Integer oilBrandId);
	
	/**
	 * 根据Id来删除油品牌信息
	 * @param oilBrandId
	 * @return
	 */
	@Query(value = "update oil_brand_info_tbl set oil_brand_delete_flag = -1 where oil_brand_id = ?1", nativeQuery = true)
	@Modifying
	int delOilBrandById(Integer oilBrandId);
}
