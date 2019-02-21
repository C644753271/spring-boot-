package com.duoqio.cloud.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the classify_info_tbl database table.
 * 
 */
@Entity
@Table(name="classify_info_tbl")
public class ClassifyInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="classify_id")
	private Integer classifyId;

	@Column(name="classify_delete_flag")
	private Short classifyDeleteFlag;

	@Column(name="classify_img")
	private String classifyImg;

	@Column(name="classify_level")
	private Short classifyLevel;

	@Column(name="classify_name")
	private String classifyName;

	@Column(name="classify_p_id")
	private Integer classifyPId;

	//bi-directional many-to-one association to ProductInfo
	@OneToMany(mappedBy="classifyInfoTbl")
	@JsonIgnore
	private List<ProductInfo> productInfoTbls;
	
	/** 用于存储子类的集合 **/
	@Transient
	private List<ClassifyInfo> childClassifys;

	public ClassifyInfo() {
	}

	public Integer getClassifyId() {
		return this.classifyId;
	}

	public void setClassifyId(Integer classifyId) {
		this.classifyId = classifyId;
	}

	public Short getClassifyDeleteFlag() {
		return this.classifyDeleteFlag;
	}

	public void setClassifyDeleteFlag(Short classifyDeleteFlag) {
		this.classifyDeleteFlag = classifyDeleteFlag;
	}

	public String getClassifyImg() {
		return this.classifyImg;
	}

	public void setClassifyImg(String classifyImg) {
		this.classifyImg = classifyImg;
	}

	public Short getClassifyLevel() {
		return this.classifyLevel;
	}

	public void setClassifyLevel(Short classifyLevel) {
		this.classifyLevel = classifyLevel;
	}

	public String getClassifyName() {
		return this.classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	public Integer getClassifyPId() {
		return this.classifyPId;
	}

	public void setClassifyPId(Integer classifyPId) {
		this.classifyPId = classifyPId;
	}

	public List<ProductInfo> getProductInfoTbls() {
		return this.productInfoTbls;
	}

	public void setProductInfoTbls(List<ProductInfo> productInfoTbls) {
		this.productInfoTbls = productInfoTbls;
	}

	public ProductInfo addProductInfoTbl(ProductInfo productInfoTbl) {
		getProductInfoTbls().add(productInfoTbl);
		productInfoTbl.setClassifyInfoTbl(this);

		return productInfoTbl;
	}

	public ProductInfo removeProductInfoTbl(ProductInfo productInfoTbl) {
		getProductInfoTbls().remove(productInfoTbl);
		productInfoTbl.setClassifyInfoTbl(null);

		return productInfoTbl;
	}

	public List<ClassifyInfo> getChildClassifys() {
		return childClassifys;
	}

	public void setChildClassifys(List<ClassifyInfo> childClassifys) {
		this.childClassifys = childClassifys;
	}
	
}