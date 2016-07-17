package com.qixin.app.turntable.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "zjtbl_dzp_lottery_record")
public class LotteryRecord {
	@GenericGenerator(name="generator", strategy="uuid.hex")
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id", unique=true, nullable=false, length=32)
	private String id;
	
	@Column(name = "JOB_NUMBER", nullable = false)
	private String jobNumber;//工号
	
	@Column(name = "EMP_NAME")
	private String empName;//员工姓名
	
	@Column(name = "openid")
	private String openid;//微信号

	@Column(name = "MOBILE")
	private String mobile;//手机号
	
	@Column(name = "USE_BADGE_COUNT")
    private Integer userBadgeCount;//使用约章数
	

	@Column(name = "activitiesid")
    private String activitiesid;//抽奖活动ID
	
	@Column(name = "award")
	private String award;//奖项
	
	
	@Column(name = "IS_PRIZE")
	private Integer isPrize;//是否中奖
	
	@Column(name = "IS_GET")
	private Integer isGet;//是否已兑奖
	
	
	@Column(name = "GET_TIME")
	private Date getTime;//兑奖时间	

	@Column(name = "S_GET_TIME")
	private String sGetTime;
	
	@Column(name = "GOT_AWARD_TIME")
	private Date gotAwardTime;
	
	public Date getGotAwardTime() {
		return gotAwardTime;
	}


	public void setGotAwardTime(Date gotAwardTime) {
		this.gotAwardTime = gotAwardTime;
	}


	public String getSGetTime() {
		return sGetTime;
	}


	public void setSGetTime(String getTime) {
		sGetTime = getTime;
	}


	public String getJobNumber() {
		return jobNumber;
	}


	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getOpenid() {
		return openid;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public void setOpenid(String openid) {
		this.openid = openid;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public Integer getUserBadgeCount() {
		return userBadgeCount;
	}


	public void setUserBadgeCount(Integer userBadgeCount) {
		this.userBadgeCount = userBadgeCount;
	}


	public String getActivitiesid() {
		return activitiesid;
	}


	public void setActivitiesid(String activitiesid) {
		this.activitiesid = activitiesid;
	}


	public String getAward() {
		return award;
	}


	public void setAward(String award) {
		this.award = award;
	}


	public Integer getIsPrize() {
		return isPrize;
	}


	public void setIsPrize(Integer isPrize) {
		this.isPrize = isPrize;
	}


	public Integer getIsGet() {
		return isGet;
	}


	public void setIsGet(Integer isGet) {
		this.isGet = isGet;
	}


	public Date getGetTime() {
		return getTime;
	}


	public void setGetTime(Date getTime) {
		this.getTime = getTime;
	}


	public String getsGetTime() {
		return sGetTime;
	}


	public void setsGetTime(String sGetTime) {
		this.sGetTime = sGetTime;
	}
	
}
