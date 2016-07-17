package com.qixin.app.zjminweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_diaoyanuser")
public class DiaoyanUser 
{
	@GenericGenerator(name="generator",strategy="uuid.hex")
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id", unique=true, nullable=false,length=32)
	public String id;
	
	@Column(name="name", nullable=false)
	public String name;
	
	@Column(name="mobile",unique=true, nullable=false)
	public String mobile;
	
	@Column(name="remark")
	public String remark;
	
	@Column(name="bizid")
	public String bizid;
	
	@Column(name="relationTitleId")
	public String relationTitleId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBizid() {
		return bizid;
	}

	public void setBizid(String bizid) {
		this.bizid = bizid;
	}
	
	

}
