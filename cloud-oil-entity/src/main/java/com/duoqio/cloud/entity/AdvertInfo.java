package com.duoqio.cloud.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the advert_info_tbl database table.
 * 
 */
@Entity
@Table(name="advert_info_tbl")
public class AdvertInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="advert_id")
	private Integer advertId;

	@Column(name="advert_delete_flag")
	private Short advertDeleteFlag;

	@Column(name="advert_img")
	private String advertImg;

	@Column(name="advert_name")
	private String advertName;
	
	@Lob
	@Column(name="advert_content")
	private String advertContent;
	
	public AdvertInfo() {
	}

	public Integer getAdvertId() {
		return this.advertId;
	}

	public void setAdvertId(Integer advertId) {
		this.advertId = advertId;
	}

	public Short getAdvertDeleteFlag() {
		return this.advertDeleteFlag;
	}

	public void setAdvertDeleteFlag(Short advertDeleteFlag) {
		this.advertDeleteFlag = advertDeleteFlag;
	}

	public String getAdvertImg() {
		return this.advertImg;
	}

	public void setAdvertImg(String advertImg) {
		this.advertImg = advertImg;
	}

	public String getAdvertName() {
		return this.advertName;
	}

	public void setAdvertName(String advertName) {
		this.advertName = advertName;
	}

	public String getAdvertContent() {
		return advertContent;
	}

	public void setAdvertContent(String advertContent) {
		this.advertContent = advertContent;
	}
	
}