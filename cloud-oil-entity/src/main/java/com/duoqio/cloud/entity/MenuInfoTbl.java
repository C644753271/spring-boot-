package com.duoqio.cloud.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the menu_info_tbl database table.
 * 
 */
@Entity
@Table(name="menu_info_tbl")
public class MenuInfoTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="menu_id")
	private Integer menuId;

	@Column(name="menu_delete_flag")
	private Short menuDeleteFlag;

	@Column(name="menu_level")
	private Short menuLevel;

	@Column(name="menu_name")
	private String menuName;

	@Column(name="menu_p_id")
	private Integer menuPId;

	@Column(name="menu_url")
	private String menuUrl;
	
	@Column(name="menu_icon")
	private String menuIcon;

	//bi-directional many-to-one association to RoleMenuInfo
	@OneToMany(mappedBy="menuInfoTbl")
	@JsonIgnore
	private List<RoleMenuInfo> roleMenuInfoTbls;

	public MenuInfoTbl() {
	}

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Short getMenuDeleteFlag() {
		return this.menuDeleteFlag;
	}

	public void setMenuDeleteFlag(Short menuDeleteFlag) {
		this.menuDeleteFlag = menuDeleteFlag;
	}

	public Short getMenuLevel() {
		return this.menuLevel;
	}

	public void setMenuLevel(Short menuLevel) {
		this.menuLevel = menuLevel;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getMenuPId() {
		return this.menuPId;
	}

	public void setMenuPId(Integer menuPId) {
		this.menuPId = menuPId;
	}

	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public List<RoleMenuInfo> getRoleMenuInfoTbls() {
		return this.roleMenuInfoTbls;
	}

	public void setRoleMenuInfoTbls(List<RoleMenuInfo> roleMenuInfoTbls) {
		this.roleMenuInfoTbls = roleMenuInfoTbls;
	}

	public RoleMenuInfo addRoleMenuInfoTbl(RoleMenuInfo roleMenuInfoTbl) {
		getRoleMenuInfoTbls().add(roleMenuInfoTbl);
		roleMenuInfoTbl.setMenuInfoTbl(this);

		return roleMenuInfoTbl;
	}

	public RoleMenuInfo removeRoleMenuInfoTbl(RoleMenuInfo roleMenuInfoTbl) {
		getRoleMenuInfoTbls().remove(roleMenuInfoTbl);
		roleMenuInfoTbl.setMenuInfoTbl(null);

		return roleMenuInfoTbl;
	}

}