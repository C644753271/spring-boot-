package com.duoqio.cloud.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the money_info_tbl database table.
 * 
 */
@Entity
@Table(name="money_info_tbl")
@NamedEntityGraph(name = "MoneyInfo.lazy", attributeNodes = {@NamedAttributeNode("moneyTypeInfoTbl")})
public class MoneyInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="money_id")
	private Integer moneyId;

	@Column(name="money_num")
	private BigDecimal moneyNum;

	@Column(name="oppo_user_id")
	private Integer oppoUserId;

	@Column(name="opt_type")
	private Short optType;

	//bi-directional many-to-one association to MoneyTypeInfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="money_type_id")
	private MoneyTypeInfo moneyTypeInfoTbl;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	@JsonIgnore
	private UserInfo userInfoTbl;
	
	@Temporal(TemporalType.DATE)
	@Column(name="add_time")
	private Date addTime;

	public MoneyInfo() {
	}

	public Integer getMoneyId() {
		return this.moneyId;
	}

	public void setMoneyId(Integer moneyId) {
		this.moneyId = moneyId;
	}

	public BigDecimal getMoneyNum() {
		return this.moneyNum;
	}

	public void setMoneyNum(BigDecimal moneyNum) {
		this.moneyNum = moneyNum;
	}

	public Integer getOppoUserId() {
		return this.oppoUserId;
	}

	public void setOppoUserId(Integer oppoUserId) {
		this.oppoUserId = oppoUserId;
	}

	public Short getOptType() {
		return this.optType;
	}

	public void setOptType(Short optType) {
		this.optType = optType;
	}

	public MoneyTypeInfo getMoneyTypeInfoTbl() {
		return this.moneyTypeInfoTbl;
	}

	public void setMoneyTypeInfoTbl(MoneyTypeInfo moneyTypeInfoTbl) {
		this.moneyTypeInfoTbl = moneyTypeInfoTbl;
	}

	public UserInfo getUserInfoTbl() {
		return this.userInfoTbl;
	}

	public void setUserInfoTbl(UserInfo userInfoTbl) {
		this.userInfoTbl = userInfoTbl;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

}