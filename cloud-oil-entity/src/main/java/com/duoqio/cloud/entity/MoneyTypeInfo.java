package com.duoqio.cloud.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the money_type_info_tbl database table.
 * 
 */
@Entity
@Table(name="money_type_info_tbl")
public class MoneyTypeInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="money_type_id")
	private Integer moneyTypeId;

	@Column(name="delete_flag")
	private Short deleteFlag;

	@Column(name="money_type")
	private String moneyType;

	//bi-directional many-to-one association to MoneyInfo
	@OneToMany(mappedBy="moneyTypeInfoTbl")
	@JsonIgnore
	private List<MoneyInfo> moneyInfoTbls;

	public MoneyTypeInfo() {
	}

	public Integer getMoneyTypeId() {
		return this.moneyTypeId;
	}

	public void setMoneyTypeId(Integer moneyTypeId) {
		this.moneyTypeId = moneyTypeId;
	}

	public Short getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(Short deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getMoneyType() {
		return this.moneyType;
	}

	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}

	public List<MoneyInfo> getMoneyInfoTbls() {
		return this.moneyInfoTbls;
	}

	public void setMoneyInfoTbls(List<MoneyInfo> moneyInfoTbls) {
		this.moneyInfoTbls = moneyInfoTbls;
	}

	public MoneyInfo addMoneyInfoTbl(MoneyInfo moneyInfoTbl) {
		getMoneyInfoTbls().add(moneyInfoTbl);
		moneyInfoTbl.setMoneyTypeInfoTbl(this);

		return moneyInfoTbl;
	}

	public MoneyInfo removeMoneyInfoTbl(MoneyInfo moneyInfoTbl) {
		getMoneyInfoTbls().remove(moneyInfoTbl);
		moneyInfoTbl.setMoneyTypeInfoTbl(null);

		return moneyInfoTbl;
	}

}