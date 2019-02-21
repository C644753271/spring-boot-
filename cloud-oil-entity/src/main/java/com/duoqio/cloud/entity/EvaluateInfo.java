package com.duoqio.cloud.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the evaluate_info_tbl database table.
 * 
 */
@Entity
@Table(name="evaluate_info_tbl")
@NamedEntityGraph(name = "EvaluateInfo.lazy", attributeNodes = {@NamedAttributeNode("evaluateImgInfoTbls"), @NamedAttributeNode("userInfoTbl")})
public class EvaluateInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="evaluate_id")
	private Integer evaluateId;

	@Column(name="evaluate_content")
	private String evaluateContent;

	@Column(name="evaluate_delete_flag")
	private Short evaluateDeleteFlag;

	@Temporal(TemporalType.DATE)
	@Column(name="evaluate_time")
	private Date evaluateTime;

	//bi-directional many-to-one association to EvaluateImgInfo
	@OneToMany(mappedBy="evaluateInfoTbl", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<EvaluateImgInfo> evaluateImgInfoTbls;

	//bi-directional many-to-one association to ProductInfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id")
	@JsonIgnore
	private ProductInfo productInfoTbl;
	
	//bi-directional one-to-one association to OrderInfo
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	@JsonIgnore
	private OrderInfo orderInfoTbl;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserInfo userInfoTbl;

	public EvaluateInfo() {
	}

	public Integer getEvaluateId() {
		return this.evaluateId;
	}

	public void setEvaluateId(Integer evaluateId) {
		this.evaluateId = evaluateId;
	}

	public String getEvaluateContent() {
		return this.evaluateContent;
	}

	public void setEvaluateContent(String evaluateContent) {
		this.evaluateContent = evaluateContent;
	}

	public Short getEvaluateDeleteFlag() {
		return this.evaluateDeleteFlag;
	}

	public void setEvaluateDeleteFlag(Short evaluateDeleteFlag) {
		this.evaluateDeleteFlag = evaluateDeleteFlag;
	}

	public Date getEvaluateTime() {
		return this.evaluateTime;
	}

	public void setEvaluateTime(Date evaluateTime) {
		this.evaluateTime = evaluateTime;
	}

	public List<EvaluateImgInfo> getEvaluateImgInfoTbls() {
		return this.evaluateImgInfoTbls;
	}

	public void setEvaluateImgInfoTbls(List<EvaluateImgInfo> evaluateImgInfoTbls) {
		this.evaluateImgInfoTbls = evaluateImgInfoTbls;
	}

	public EvaluateImgInfo addEvaluateImgInfoTbl(EvaluateImgInfo evaluateImgInfoTbl) {
		getEvaluateImgInfoTbls().add(evaluateImgInfoTbl);
		evaluateImgInfoTbl.setEvaluateInfoTbl(this);

		return evaluateImgInfoTbl;
	}

	public EvaluateImgInfo removeEvaluateImgInfoTbl(EvaluateImgInfo evaluateImgInfoTbl) {
		getEvaluateImgInfoTbls().remove(evaluateImgInfoTbl);
		evaluateImgInfoTbl.setEvaluateInfoTbl(null);

		return evaluateImgInfoTbl;
	}

	public ProductInfo getProductInfoTbl() {
		return this.productInfoTbl;
	}

	public void setProductInfoTbl(ProductInfo productInfoTbl) {
		this.productInfoTbl = productInfoTbl;
	}

	public UserInfo getUserInfoTbl() {
		return this.userInfoTbl;
	}

	public void setUserInfoTbl(UserInfo userInfoTbl) {
		this.userInfoTbl = userInfoTbl;
	}

	public OrderInfo getOrderInfoTbl() {
		return orderInfoTbl;
	}

	public void setOrderInfoTbl(OrderInfo orderInfoTbl) {
		this.orderInfoTbl = orderInfoTbl;
	}
	
}