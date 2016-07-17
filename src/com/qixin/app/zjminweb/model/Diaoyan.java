package com.qixin.app.zjminweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_diaoyan")
public class Diaoyan 
{
	@GenericGenerator(name="generator",strategy="uuid.hex")
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id", unique=true, nullable=false,length=32)
	private String id;
	
	@Column(name="openId", length=100)
	private String openId;
    
	@Column(name="activeName", length=100)
	private String activeName;
    
	@Column(name="keyword", length=100)
	private String keyword;
	
	@Column(name="activeStartTime", length=32)
	private String activeStartTime;
	
	@Column(name="activeEndTime",length=32)
	private String activeEndTime;
	
	@Column(name="imgPath",length=100)
	private String imgPath;
	
	@Column(name="remark",length=2000)
	private String remark;
	
	@Column(name="relationActive", length=32)
	private String relationActive;
	
	@Column(name="operationTime",length=32)
	private String operationTime;
	
	@Column(name="status",length=10)
	private String status;
	
	@Column(name="bizid")
	private String bizid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getActiveName() {
		return activeName;
	}

	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getBizid() {
		return bizid;
	}

	public void setBizid(String bizid) {
		this.bizid = bizid;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRelationActive() {
		return relationActive;
	}

	public void setRelationActive(String relationActive) {
		this.relationActive = relationActive;
	}

	public String getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}

	public String getActiveStartTime() {
		return activeStartTime;
	}

	public void setActiveStartTime(String activeStartTime) {
		this.activeStartTime = activeStartTime;
	}

	public String getActiveEndTime() {
		return activeEndTime;
	}

	public void setActiveEndTime(String activeEndTime) {
		this.activeEndTime = activeEndTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
