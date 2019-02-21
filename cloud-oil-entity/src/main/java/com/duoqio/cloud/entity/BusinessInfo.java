package com.duoqio.cloud.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the business_info_tbl database table.
 * 
 */
@Entity
@Table(name="business_info_tbl")
public class BusinessInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="business_id")
	private Integer businessId;

	@Column(name="business_idcard")
	private String businessIdcard;

	@Column(name="business_img_card")
	private String businessImgCard;

	@Column(name="business_img_card_reversed")
	private String businessImgCardReversed;

	@Column(name="business_img_certificate")
	private String businessImgCertificate;

	@Column(name="business_img_licence")
	private String businessImgLicence;

	@Column(name="business_name")
	private String businessName;
	
	@Column(name="manager_name")
	private String managerName;

	@Column(name="business_status")
	private Short businessStatus;

	@Column(name="business_tel")
	private String businessTel;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserInfo userInfoTbl;
	
	//bi-directional one-to-one association to ShopInfo
	@OneToOne(fetch=FetchType.LAZY, cascade = {CascadeType.PERSIST})
	@JoinColumn(name="shop_id")
	private ShopInfo shopInfoTbl;


	public BusinessInfo() {
	}

	public Integer getBusinessId() {
		return this.businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public String getBusinessIdcard() {
		return this.businessIdcard;
	}

	public void setBusinessIdcard(String businessIdcard) {
		this.businessIdcard = businessIdcard;
	}

	public String getBusinessImgCard() {
		return this.businessImgCard;
	}

	public void setBusinessImgCard(String businessImgCard) {
		this.businessImgCard = businessImgCard;
	}

	public String getBusinessImgCardReversed() {
		return this.businessImgCardReversed;
	}

	public void setBusinessImgCardReversed(String businessImgCardReversed) {
		this.businessImgCardReversed = businessImgCardReversed;
	}

	public String getBusinessImgCertificate() {
		return this.businessImgCertificate;
	}

	public void setBusinessImgCertificate(String businessImgCertificate) {
		this.businessImgCertificate = businessImgCertificate;
	}

	public String getBusinessImgLicence() {
		return this.businessImgLicence;
	}

	public void setBusinessImgLicence(String businessImgLicence) {
		this.businessImgLicence = businessImgLicence;
	}

	public String getBusinessName() {
		return this.businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public Short getBusinessStatus() {
		return this.businessStatus;
	}

	public void setBusinessStatus(Short businessStatus) {
		this.businessStatus = businessStatus;
	}

	public String getBusinessTel() {
		return this.businessTel;
	}

	public void setBusinessTel(String businessTel) {
		this.businessTel = businessTel;
	}

	public UserInfo getUserInfoTbl() {
		return this.userInfoTbl;
	}

	public void setUserInfoTbl(UserInfo userInfoTbl) {
		this.userInfoTbl = userInfoTbl;
	}

	public ShopInfo getShopInfoTbl() {
		return this.shopInfoTbl;
	}

	public void setShopInfoTbl(ShopInfo shopInfoTbl) {
		this.shopInfoTbl = shopInfoTbl;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
}