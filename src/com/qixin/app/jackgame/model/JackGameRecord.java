package com.qixin.app.jackgame.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="jack_game_record")
public class JackGameRecord {
	private String id;//id
	private String jobNumber;//工号
	private String empName;//员工姓名
	private Date beginTime;//开始时间
	private Date endTime;//结束时间
	private Integer score;//得分
	private Integer badgeCount;//获得约章数
	private String openId;
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
	@Column(name="BEGIN_TIME")
	public Date getBeginTime() {
		return beginTime;
	}
	@Column(name="END_TIME")
	public Date getEndTime() {
		return endTime;
	}
	@Column(name="SCORE")
	public Integer getScore() {
		return score;
	}
	@Column(name="BADGE_COUNT")
	public Integer getBadgeCount() {
		return badgeCount;
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
	@Column(name="openid",length=100)
	public String getOpenId() {
		return openId;
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
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public void setBadgeCount(Integer badgeCount) {
		this.badgeCount = badgeCount;
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
	@Override
	public String toString() {
		return "JackGameRecord [id=" + id + ", jobNumber=" + jobNumber
				+ ", empName=" + empName + ", beginTime=" + beginTime
				+ ", endTime=" + endTime + ", score=" + score + ", badgeCount="
				+ badgeCount + ", creater=" + creater + ", createdDate="
				+ createdDate + ", updater=" + updater + ", updateDate="
				+ updateDate + "]";
	}
	
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	
}
