package com.duoqio.cloud.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;


/**
 * The persistent class for the oil_info_tbl database table.
 * 
 */
@Entity
@Table(name="batch_oil_info_tbl")
public class BatchOilInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="oil_id")
	private Integer oilId;

	@Column(name="oil_delete_flag")
	private Short oilDeleteFlag;

	@Column(name="oil_market_price")
	private BigDecimal oilMarketPrice;

	@Column(name="oil_order_count")
	private Integer oilOrderCount;

	@Column(name="oil_price")
	private BigDecimal oilPrice;

	//bi-directional many-to-one association to OilBrandInfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="oil_brand_id")
	@JsonIgnore
	private OilBrandInfo oilBrandInfoTbl;

	//bi-directional many-to-one association to OilTypeInfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="oil_type_id")
	private OilTypeInfo oilTypeInfoTbl;

	public BatchOilInfo() {
	}

	public Integer getOilId() {
		return this.oilId;
	}

	public void setOilId(Integer oilId) {
		this.oilId = oilId;
	}

	public Short getOilDeleteFlag() {
		return this.oilDeleteFlag;
	}

	public void setOilDeleteFlag(Short oilDeleteFlag) {
		this.oilDeleteFlag = oilDeleteFlag;
	}

	public BigDecimal getOilMarketPrice() {
		return this.oilMarketPrice;
	}

	public void setOilMarketPrice(BigDecimal oilMarketPrice) {
		this.oilMarketPrice = oilMarketPrice;
	}

	public Integer getOilOrderCount() {
		return this.oilOrderCount;
	}

	public void setOilOrderCount(Integer oilOrderCount) {
		this.oilOrderCount = oilOrderCount;
	}

	public BigDecimal getOilPrice() {
		return this.oilPrice;
	}

	public void setOilPrice(BigDecimal oilPrice) {
		this.oilPrice = oilPrice;
	}

	public OilBrandInfo getOilBrandInfoTbl() {
		return this.oilBrandInfoTbl;
	}

	public void setOilBrandInfoTbl(OilBrandInfo oilBrandInfoTbl) {
		this.oilBrandInfoTbl = oilBrandInfoTbl;
	}

	public OilTypeInfo getOilTypeInfoTbl() {
		return this.oilTypeInfoTbl;
	}

	public void setOilTypeInfoTbl(OilTypeInfo oilTypeInfoTbl) {
		this.oilTypeInfoTbl = oilTypeInfoTbl;
	}

	public OilTypeInfo addOilTypeInfoTbl(OilTypeInfo oilTypeInfoTbl) {
		return oilTypeInfoTbl;
	}

	public OilTypeInfo removeOilTypeInfoTbl(OilTypeInfo oilTypeInfoTbl) {
		return oilTypeInfoTbl;
	}
}