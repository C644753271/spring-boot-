package com.duoqio.cloud.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the apply_oil_card_info_tbl database table.
 * 
 */
@Entity
@Table(name="apply_oil_card_info_tbl")
public class ApplyOilCardInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="apply_oil_card_id")
	private Integer applyOilCardId;

	@Column(name="apply_oil_card_status")
	private Short applyOilCardStatus;

	@Column(name="driver_img")
	private String driverImg;

	@Column(name="idcard_img")
	private String idcardImg;

	@Column(name="idcard_img_reverse")
	private String idcardImgReverse;

	@Column(name="oil_card_type")
	private Short oilCardType;
	
	@Column(name="oil_virtual")
	private Short oilVirtual;

	@Column(name="travel_img")
	private String travelImg;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserInfo userInfoTbl;
	
	//bi-directional many-to-one association to AddressInfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="address_id")
	private AddressInfo addressInfoTbl;

	public ApplyOilCardInfo() {
	}

	public Integer getApplyOilCardId() {
		return this.applyOilCardId;
	}

	public void setApplyOilCardId(Integer applyOilCardId) {
		this.applyOilCardId = applyOilCardId;
	}

	public Short getApplyOilCardStatus() {
		return this.applyOilCardStatus;
	}

	public void setApplyOilCardStatus(Short applyOilCardStatus) {
		this.applyOilCardStatus = applyOilCardStatus;
	}

	public String getDriverImg() {
		return this.driverImg;
	}

	public void setDriverImg(String driverImg) {
		this.driverImg = driverImg;
	}

	public String getIdcardImg() {
		return this.idcardImg;
	}

	public void setIdcardImg(String idcardImg) {
		this.idcardImg = idcardImg;
	}

	public String getIdcardImgReverse() {
		return this.idcardImgReverse;
	}

	public void setIdcardImgReverse(String idcardImgReverse) {
		this.idcardImgReverse = idcardImgReverse;
	}

	public Short getOilCardType() {
		return this.oilCardType;
	}

	public void setOilCardType(Short oilCardType) {
		this.oilCardType = oilCardType;
	}

	public String getTravelImg() {
		return this.travelImg;
	}

	public void setTravelImg(String travelImg) {
		this.travelImg = travelImg;
	}

	public UserInfo getUserInfoTbl() {
		return this.userInfoTbl;
	}

	public void setUserInfoTbl(UserInfo userInfoTbl) {
		this.userInfoTbl = userInfoTbl;
	}

	public AddressInfo getAddressInfoTbl() {
		return addressInfoTbl;
	}

	public void setAddressInfoTbl(AddressInfo addressInfoTbl) {
		this.addressInfoTbl = addressInfoTbl;
	}

	public Short getOilVirtual() {
		return oilVirtual;
	}

	public void setOilVirtual(Short oilVirtual) {
		this.oilVirtual = oilVirtual;
	}
	
}