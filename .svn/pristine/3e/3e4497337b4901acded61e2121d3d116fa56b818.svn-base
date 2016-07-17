package com.qixin.app.lanterngame.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author liufei
 * 解放号_用户表
 */
@Entity
@Table(name="ijfer_user")
public class IjferUser {
	private Integer id;//id
	private String workNo;//工号
	private String empName;//员工姓名
	private String mobile;//手机
	private Integer badgeCount;//员工勋章数
	private String link;//链接
	private String remark;//备注
	private String creater;//
	private Date createdDate;//
	private String updater;//
	private Date updateDate;//
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false, length=32)
	public Integer getId() {
		return id;
	}
	@Column(name="WORK_NO",length=32)
	public String getWorkNo() {
		return workNo;
	}
	@Column(name="NAME",length=100)
	public String getEmpName() {
		return empName;
	}
	@Column(name="TEL_NO",length=20)
	public String getMobile() {
		return mobile;
	}
	@Column(name="medal_num",length=5)
	public Integer getBadgeCount() {
		return badgeCount;
	}
	@Column(name="LINK",length=255)
	public String getLink() {
		return link;
	}
	@Column(name="REMARK",length=255)
	public String getRemark() {
		return remark;
	}
	@Column(name="CREATER",length=32)
	public String getCreater() {
		return creater;
	}
	@Column(name="CREATED_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}
	@Column(name="UPDATER",length=32)
	public String getUpdater() {
		return updater;
	}
	@Column(name="updated_date")
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setBadgeCount(Integer badgeCount) {
		this.badgeCount = badgeCount;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
