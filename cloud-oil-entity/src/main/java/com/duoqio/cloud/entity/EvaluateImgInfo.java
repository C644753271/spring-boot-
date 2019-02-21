package com.duoqio.cloud.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the evaluate_img_info_tbl database table.
 * 
 */
@Entity
@Table(name="evaluate_img_info_tbl")
public class EvaluateImgInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="evaluate_img_id")
	private int evaluateImgId;

	@Column(name="evaluate_delete_flag")
	private short evaluateDeleteFlag;

	@Column(name="evaluate_img")
	private String evaluateImg;

	//bi-directional many-to-one association to EvaluateInfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="evaluate_id")
	@JsonIgnore
	private EvaluateInfo evaluateInfoTbl;

	public EvaluateImgInfo() {
	}

	public int getEvaluateImgId() {
		return this.evaluateImgId;
	}

	public void setEvaluateImgId(int evaluateImgId) {
		this.evaluateImgId = evaluateImgId;
	}

	public short getEvaluateDeleteFlag() {
		return this.evaluateDeleteFlag;
	}

	public void setEvaluateDeleteFlag(short evaluateDeleteFlag) {
		this.evaluateDeleteFlag = evaluateDeleteFlag;
	}

	public String getEvaluateImg() {
		return this.evaluateImg;
	}

	public void setEvaluateImg(String evaluateImg) {
		this.evaluateImg = evaluateImg;
	}

	public EvaluateInfo getEvaluateInfoTbl() {
		return this.evaluateInfoTbl;
	}

	public void setEvaluateInfoTbl(EvaluateInfo evaluateInfoTbl) {
		this.evaluateInfoTbl = evaluateInfoTbl;
	}

}