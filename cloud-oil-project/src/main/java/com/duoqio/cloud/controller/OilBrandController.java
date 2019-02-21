package com.duoqio.cloud.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoqio.cloud.core.result.GeneralResult;
import com.duoqio.cloud.entity.OilBrandInfo;
import com.duoqio.cloud.service.OilBrandService;

@RestController
@RequestMapping("/oilBrand")
public class OilBrandController {

	/** 油类品牌的业务接口 **/
	private OilBrandService oilBrandService;

	@Autowired
	public OilBrandController(OilBrandService oilBrandService) {
		this.oilBrandService = oilBrandService;
	}
	
	/**
	 * 获取到所有的油类品牌
	 * @return
	 */
	@GetMapping("/findAllOilBrandInfo")
	public GeneralResult findAllOilBrandInfo() {
		List<OilBrandInfo> oilBrands = oilBrandService.findAllOilBrandInfo();
		GeneralResult result = new GeneralResult(0);
		result.setResult(oilBrands);
		return result;
	}
	
	/**
	 * 查询出单个油品牌的信息
	 * @param oilBrandInfo
	 * @return
	 */
	@GetMapping("/findOilBrandInfo")
	public GeneralResult findOilBrandInfo(OilBrandInfo oilBrandInfo) {
		OilBrandInfo oilBrand = oilBrandService.findOilBrandInfo(oilBrandInfo);
		GeneralResult result = new GeneralResult(0);
		result.setResult(oilBrand);
		return result;
	}
	
	
}
