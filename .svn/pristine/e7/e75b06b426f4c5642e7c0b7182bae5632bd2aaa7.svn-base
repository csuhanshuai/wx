package com.qixin.app.zjmall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_mall_navset")
public class NavSet {
	public NavSet() {
	}

	public NavSet(String bizid, int skinid, int navindex, 
			String setkey, String setvalue, String updatetime) {
		this.bizid = bizid;
		this.skinid = skinid;
		this.navindex = navindex;
		this.setkey = setkey;
		this.setvalue = setvalue;
		this.updatetime = updatetime;

	}

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;

	@Column(name = "bizid", nullable = false, length = 32)
	private String bizid;
	//
	@Column(name = "skinid")
	private Integer skinid;
	// 设置id
	@Column(name = "navindex")
	private Integer navindex;
	// 更新时间
	@Column(name = "updatetime", length = 20)
	private String updatetime;

	@Column(name = "setkey", length = 128)
	private String setkey;

	@Column(name = "setvalue", length = 128)
	private String setvalue;

	public String getBizid() {
		return bizid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setBizid(String bizid) {
		this.bizid = bizid;
	}

	public Integer getNavindex() {
		return navindex;
	}

	public void setNavindex(Integer navindex) {
		this.navindex = navindex;
	}

	public Integer getSkinid() {
		return skinid;
	}

	public void setSkinid(Integer skinid) {
		this.skinid = skinid;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getSetvalue() {
		return setvalue;
	}

	public void setSetvalue(String setvalue) {
		this.setvalue = setvalue;
	}

	public String getSetkey() {
		return setkey;
	}

	public void setSetkey(String setkey) {
		this.setkey = setkey;
	}

}
