package com.duoqio.cloud.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the distribution_info_tbl database table.
 * 
 */
@Entity
@Table(name="distribution_info_tbl")
public class DistributionInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="distribution_id")
	private Integer distributionId;

	@Column(name="distribution_address")
	private String distributionAddress;

	@Column(name="distribution_code")
	private String distributionCode;

	@Column(name="distribution_name")
	private String distributionName;

	@Column(name="distribution_status")
	private Short distributionStatus;

	@Column(name="distribution_tel")
	private String distributionTel;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserInfo userInfoTbl;
	
	@Temporal(TemporalType.DATE)
	@Column(name="success_time")
	private Date successTime;

	public DistributionInfo() {
	}

	public Integer getDistributionId() {
		return this.distributionId;
	}

	public void setDistributionId(Integer distributionId) {
		this.distributionId = distributionId;
	}

	public String getDistributionAddress() {
		return this.distributionAddress;
	}

	public void setDistributionAddress(String distributionAddress) {
		this.distributionAddress = distributionAddress;
	}

	public String getDistributionCode() {
		return this.distributionCode;
	}

	public void setDistributionCode(String distributionCode) {
		this.distributionCode = distributionCode;
	}

	public String getDistributionName() {
		return this.distributionName;
	}

	public void setDistributionName(String distributionName) {
		this.distributionName = distributionName;
	}

	public Short getDistributionStatus() {
		return this.distributionStatus;
	}

	public void setDistributionStatus(Short distributionStatus) {
		this.distributionStatus = distributionStatus;
	}

	public String getDistributionTel() {
		return this.distributionTel;
	}

	public void setDistributionTel(String distributionTel) {
		this.distributionTel = distributionTel;
	}

	public UserInfo getUserInfoTbl() {
		return this.userInfoTbl;
	}

	public void setUserInfoTbl(UserInfo userInfoTbl) {
		this.userInfoTbl = userInfoTbl;
	}

	public Date getSuccessTime() {
		return successTime;
	}

	public void setSuccessTime(Date successTime) {
		this.successTime = successTime;
	}
}