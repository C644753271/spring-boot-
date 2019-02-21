package com.duoqio.cloud.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oil_card_type_info database table.
 * 
 */
@Entity
@Table(name="oil_card_type_info_tbl")
public class OilCardTypeInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="oil_card_type_id")
	private Integer oilCardTypeId;

	@Column(name="bind_position")
	private Short bindPosition;

	@Column(name="delete_flag")
	private Short deleteFlag;

	@Column(name="oil_card_name")
	private String oilCardName;

	@Column(name="oil_card_virtual")
	private Short oilCardVirtual;

	public OilCardTypeInfo() {
	}

	public Integer getOilCardTypeId() {
		return this.oilCardTypeId;
	}

	public void setOilCardTypeId(Integer oilCardTypeId) {
		this.oilCardTypeId = oilCardTypeId;
	}

	public Short getBindPosition() {
		return this.bindPosition;
	}

	public void setBindPosition(Short bindPosition) {
		this.bindPosition = bindPosition;
	}

	public Short getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(Short deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getOilCardName() {
		return this.oilCardName;
	}

	public void setOilCardName(String oilCardName) {
		this.oilCardName = oilCardName;
	}

	public Short getOilCardVirtual() {
		return this.oilCardVirtual;
	}

	public void setOilCardVirtual(Short oilCardVirtual) {
		this.oilCardVirtual = oilCardVirtual;
	}

}