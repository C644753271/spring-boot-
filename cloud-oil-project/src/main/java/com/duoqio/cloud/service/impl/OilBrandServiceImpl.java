package com.duoqio.cloud.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.duoqio.cloud.core.exception.BaseException;
import com.duoqio.cloud.entity.OilBrandInfo;
import com.duoqio.cloud.repository.OilBrandRepository;
import com.duoqio.cloud.service.OilBrandService;


/**
 * 
 *************************************************
 * 功能描述:  油类品牌的业务实现类                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2018年11月13日 创建文件                                             
 * @see                        
 *************************************************
 */
@Service
public class OilBrandServiceImpl implements OilBrandService {

	/** jpa持久化接口 **/
	private OilBrandRepository oilBrandRepository;
	
	@Autowired
	public OilBrandServiceImpl(OilBrandRepository oilBrandRepository) {
		super();
		this.oilBrandRepository = oilBrandRepository;
	}

	@Cacheable(value = "oilBrandInfo", key = "#root.methodName")
	@Override
	public List<OilBrandInfo> findAllOilBrandInfo() throws BaseException {
		Sort sort = new Sort(Direction.DESC, "oilBrandId");
		List<OilBrandInfo> result = oilBrandRepository.findAllByOilBrandDeleteFlag(sort, new Short((short) 0));
		if(Objects.isNull(result) || result.size() <= 0)
			throw new RuntimeException("NO MORE DATA");
		return result;
	}

	@Cacheable(value = "oilBrandInfo", key = "#root.methodName + '_' + #oilBrandInfo.oilBrandId.intValue()")
	@Override
	public OilBrandInfo findOilBrandInfo(OilBrandInfo oilBrandInfo) throws BaseException {
		Predicate<OilBrandInfo> deal = oilBrand -> ! Objects.isNull(oilBrand) && !Objects.isNull(oilBrand.getOilBrandId());
		if(! deal.test(oilBrandInfo)){
			throw new RuntimeException("NO MORE DATA");
		}
		Optional<OilBrandInfo> optionEntity = oilBrandRepository.findById(oilBrandInfo.getOilBrandId());
		OilBrandInfo entity = optionEntity.orElseThrow(() -> {throw new RuntimeException("error");});
		return entity;
	}

	
	
}
