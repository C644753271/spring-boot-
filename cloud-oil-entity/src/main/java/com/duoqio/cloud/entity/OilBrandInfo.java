package com.duoqio.cloud.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the oil_brand_info_tbl database table.
 * 
 */
@Entity
@Table(name="oil_brand_info_tbl")
public class OilBrandInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="oil_brand_id")
	private Integer oilBrandId;

	@Column(name="oil_brand_delete_flag")
	private Short oilBrandDeleteFlag;

	@Column(name="oil_brand_name")
	private String oilBrandName;

	//bi-directional many-to-one association to OilInfo
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="oil_id")
//	private OilInfo oilInfoTbl;

	//bi-directional many-to-one association to OilInfo
	@OneToMany(mappedBy="oilBrandInfoTbl")
	@JsonIgnore
	private List<OilInfo> oilInfoTbls;
	
	
	@OneToMany(mappedBy="oilBrandInfoTbl")
	@JsonIgnore
	private List<BatchOilInfo> batchOilInfoTbls;

	public OilBrandInfo() {
	}

	public Integer getOilBrandId() {
		return this.oilBrandId;
	}

	public void setOilBrandId(Integer oilBrandId) {
		this.oilBrandId = oilBrandId;
	}

	public Short getOilBrandDeleteFlag() {
		return this.oilBrandDeleteFlag;
	}

	public void setOilBrandDeleteFlag(Short oilBrandDeleteFlag) {
		this.oilBrandDeleteFlag = oilBrandDeleteFlag;
	}

	public String getOilBrandName() {
		return this.oilBrandName;
	}

	public void setOilBrandName(String oilBrandName) {
		this.oilBrandName = oilBrandName;
	}

//	public OilInfo getOilInfoTbl() {
//		return this.oilInfoTbl;
//	}
//
//	public void setOilInfoTbl(OilInfo oilInfoTbl) {
//		this.oilInfoTbl = oilInfoTbl;
//	}

	public List<OilInfo> getOilInfoTbls() {
		return this.oilInfoTbls;
	}

	public void setOilInfoTbls(List<OilInfo> oilInfoTbls) {
		this.oilInfoTbls = oilInfoTbls;
	}

	public OilInfo addOilInfoTbl(OilInfo oilInfoTbl) {
		getOilInfoTbls().add(oilInfoTbl);
		oilInfoTbl.setOilBrandInfoTbl(this);

		return oilInfoTbl;
	}

	public OilInfo removeOilInfoTbl(OilInfo oilInfoTbl) {
		getOilInfoTbls().remove(oilInfoTbl);
		oilInfoTbl.setOilBrandInfoTbl(null);

		return oilInfoTbl;
	}

	public List<BatchOilInfo> getBatchOilInfoTbls() {
		return batchOilInfoTbls;
	}

	public void setBatchOilInfoTbls(List<BatchOilInfo> batchOilInfoTbls) {
		this.batchOilInfoTbls = batchOilInfoTbls;
	}
	
	public BatchOilInfo addBatchOilInfoTbl(BatchOilInfo batchOilInfoTbl) {
		getBatchOilInfoTbls().add(batchOilInfoTbl);
		batchOilInfoTbl.setOilBrandInfoTbl(this);

		return batchOilInfoTbl;
	}

	public BatchOilInfo removeBatchOilInfoTbl(BatchOilInfo batchOilInfoTbl) {
		getBatchOilInfoTbls().remove(batchOilInfoTbl);
		batchOilInfoTbl.setOilBrandInfoTbl(null);

		return batchOilInfoTbl;
	}


}