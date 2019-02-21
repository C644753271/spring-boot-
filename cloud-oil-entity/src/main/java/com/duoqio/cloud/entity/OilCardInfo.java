package com.duoqio.cloud.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * The persistent class for the oil_card_info_tbl database table.
 * 
 */
@Entity
@Table(name="oil_card_info_tbl")
public class OilCardInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="oil_card_id")
	private Integer oilCardId;

	@Column(name="oil_card_number")
	private String oilCardNumber;

	@Column(name="oil_card_type")
	private Short oilCardType;
	
	@Column(name="idcard_delete_flag")
	private Short idcardDeleteFlag;

	@Column(name="idcard_img")
	private String idcardImg;

	@Column(name="idcard_img_reverse")
	private String idcardImgReverse;
	
	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	@JsonIgnore
	private UserInfo userInfoTbl;
	
	//bi-directional many-to-one association to OilOrderInfo
	@OneToMany(mappedBy="oilCardInfoTbl")
	@JsonIgnore
	private List<OilOrderInfo> oilOrderInfoTbls;
	
	@Temporal(TemporalType.DATE)
	@Column(name="bind_time")
	private Date bindTime;

	public OilCardInfo() {
	}

	public Integer getOilCardId() {
		return this.oilCardId;
	}

	public void setOilCardId(Integer oilCardId) {
		this.oilCardId = oilCardId;
	}

	public String getOilCardNumber() {
		return this.oilCardNumber;
	}

	public void setOilCardNumber(String oilCardNumber) {
		this.oilCardNumber = oilCardNumber;
	}

	public Short getOilCardType() {
		return this.oilCardType;
	}

	public void setOilCardType(Short oilCardType) {
		this.oilCardType = oilCardType;
	}

	public UserInfo getUserInfoTbl() {
		return this.userInfoTbl;
	}

	public void setUserInfoTbl(UserInfo userInfoTbl) {
		this.userInfoTbl = userInfoTbl;
	}
	
	public List<OilOrderInfo> getOilOrderInfoTbls() {
		return this.oilOrderInfoTbls;
	}

	public void setOilOrderInfoTbls(List<OilOrderInfo> oilOrderInfoTbls) {
		this.oilOrderInfoTbls = oilOrderInfoTbls;
	}

	public OilOrderInfo addOilOrderInfoTbl(OilOrderInfo oilOrderInfoTbl) {
		getOilOrderInfoTbls().add(oilOrderInfoTbl);
		oilOrderInfoTbl.setOilCardInfoTbl(this);

		return oilOrderInfoTbl;
	}

	public OilOrderInfo removeOilOrderInfoTbl(OilOrderInfo oilOrderInfoTbl) {
		getOilOrderInfoTbls().remove(oilOrderInfoTbl);
		oilOrderInfoTbl.setOilCardInfoTbl(null);

		return oilOrderInfoTbl;
	}

	public Short getIdcardDeleteFlag() {
		return idcardDeleteFlag;
	}

	public void setIdcardDeleteFlag(Short idcardDeleteFlag) {
		this.idcardDeleteFlag = idcardDeleteFlag;
	}

	public String getIdcardImg() {
		return idcardImg;
	}

	public void setIdcardImg(String idcardImg) {
		this.idcardImg = idcardImg;
	}

	public String getIdcardImgReverse() {
		return idcardImgReverse;
	}

	public void setIdcardImgReverse(String idcardImgReverse) {
		this.idcardImgReverse = idcardImgReverse;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getBindTime() {
		return bindTime;
	}

	public void setBindTime(Date bindTime) {
		this.bindTime = bindTime;
	}


}