package com.duoqio.cloud.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the address_info_tbl database table.
 * 
 */
@Entity
@Table(name="address_info_tbl")
public class AddressInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private Integer addressId;

	@Column(name="address_addr")
	private String addressAddr;

	@Column(name="address_delete_flag")
	private Short addressDeleteFlag;
	
	@Column(name="address_default")
	private Short addressDefault;

	@Column(name="address_name")
	private String addressName;

	@Column(name="address_tel")
	private String addressTel;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	@JsonIgnore
	private UserInfo userInfoTbl;
	
	//bi-directional many-to-one association to ApplyOilCardInfo
	@OneToMany(mappedBy="addressInfoTbl")
	@JsonIgnore
	private List<ApplyOilCardInfo> applyOilCardInfoTbls;

	public AddressInfo() {
	}

	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddressAddr() {
		return this.addressAddr;
	}

	public void setAddressAddr(String addressAddr) {
		this.addressAddr = addressAddr;
	}

	public Short getAddressDeleteFlag() {
		return this.addressDeleteFlag;
	}

	public void setAddressDeleteFlag(Short addressDeleteFlag) {
		this.addressDeleteFlag = addressDeleteFlag;
	}

	public String getAddressName() {
		return this.addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getAddressTel() {
		return this.addressTel;
	}

	public void setAddressTel(String addressTel) {
		this.addressTel = addressTel;
	}

	public UserInfo getUserInfoTbl() {
		return this.userInfoTbl;
	}

	public void setUserInfoTbl(UserInfo userInfoTbl) {
		this.userInfoTbl = userInfoTbl;
	}

	public Short getAddressDefault() {
		return addressDefault;
	}

	public void setAddressDefault(Short addressDefault) {
		this.addressDefault = addressDefault;
	}

	public List<ApplyOilCardInfo> getApplyOilCardInfoTbls() {
		return this.applyOilCardInfoTbls;
	}

	public void setApplyOilCardInfoTbls(List<ApplyOilCardInfo> applyOilCardInfoTbls) {
		this.applyOilCardInfoTbls = applyOilCardInfoTbls;
	}
		
	public ApplyOilCardInfo addApplyOilCardInfoTbl(ApplyOilCardInfo applyOilCardInfoTbl) {
		getApplyOilCardInfoTbls().add(applyOilCardInfoTbl);
		applyOilCardInfoTbl.setAddressInfoTbl(this);

		return applyOilCardInfoTbl;
	}

	public ApplyOilCardInfo removeApplyOilCardInfoTbl(ApplyOilCardInfo applyOilCardInfoTbl) {
		getApplyOilCardInfoTbls().remove(applyOilCardInfoTbl);
		applyOilCardInfoTbl.setAddressInfoTbl(null);

		return applyOilCardInfoTbl;
	}
}