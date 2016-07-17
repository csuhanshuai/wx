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
 * 员工得分表
 */
@Entity
@Table(name="emp_score")
public class EmpScore {
	private String id;//id
	private String jobNumber;//工号
	private String empName;//员工姓名
	private String mobile;//手机号
	private Integer score;//得分
	private Integer playCount;//总答题数
	private Integer canPlayCount;//可答题数
	private Integer empBadgeCount;//员工约章数
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
	@Column(name="JOB_NUMBER", length=32)
	public String getJobNumber() {
		return jobNumber;
	}
	@Column(name="EMP_NAME", length=32)
	public String getEmpName() {
		return empName;
	}
	@Column(name="MOBILE", length=20)
	public String getMobile() {
		return mobile;
	}
	@Column(name="SCORE", length=20)
	public Integer getScore() {
		return score;
	}
	@Column(name="PLAY_COUNT", length=10)
	public Integer getPlayCount() {
		return playCount;
	}
	@Column(name="CAN_PLAY_COUNT", length=10)
	public Integer getCanPlayCount() {
		return canPlayCount;
	}
	@Column(name="EMP_BADGE_COUNT", length=10)
	public Integer getEmpBadgeCount() {
		return empBadgeCount;
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
		this.mobile = mobile;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public void setPlayCount(Integer playCount) {
		this.playCount = playCount;
	}
	public void setCanPlayCount(Integer canPlayCount) {
		this.canPlayCount = canPlayCount;
	}
	public void setEmpBadgeCount(Integer empBadgeCount) {
		this.empBadgeCount = empBadgeCount;
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
