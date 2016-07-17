package com.qixin.app.lanterngame.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author liufei
 * 员勋章表
 */
@Entity
@Table(name="user_medal")
public class UserMedal {
	private String id;//id
	private String jobNumber;//工号
	private String empName;//员工姓名
	private String Mobile;//手机
	private Integer badgeCount;//员工勋章数
	private Integer type;
	private String link;
	private String creater;//
	private Date createdDate;//
	private String updater;//
	private Date updateDate;//
	@GenericGenerator(name="generator", strategy="uuid.hex")
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id", unique=true, nullable=false, length=32)
	public String getId() {
		return id;
	}
	@Column(name="JOB_NUMBER",length=32)
	public String getJobNumber() {
		return jobNumber;
	}
	@Column(name="EMP_NAME",length=100)
	public String getEmpName() {
		return empName;
	}
	@Column(name="MOBILE",length=20)
	public String getMobile() {
		return Mobile;
	}
	@Column(name="BADGE_COUNT",length=5)
	public Integer getBadgeCount() {
		return badgeCount;
	}
	@Column(name="TYPE",length=5)
	public Integer getType() {
		return type;
	}
	@Column(name="LINK",length=255)
	public String getLink() {
		return link;
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
	@Column(name="UPDATE_DATE")
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public void setBadgeCount(Integer badgeCount) {
		this.badgeCount = badgeCount;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public void setLink(String link) {
		this.link = link;
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
