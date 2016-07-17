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
 * 员工信息表
 */
@Entity
@Table(name="emp_info")
public class EmpInfo {
	private String id;//id
	private String openid;// openid
	
	private String jobNumber;//工号
	private String empName;//员工姓名
	private Date entryDate;//员工入职日期
	private Integer sex;//性别 1 男 2女
	private String businessLine;//业务线
	private String bug;//bug
	private String budu;//budu
	private String depart;//交付部
	private String area;//所造区域
	private String creater;//
	private Date createdDate;//
	@Column(name="ERROR_NUM")
	public Integer getErrorNum() {
		return errorNum;
	}
	public void setErrorNum(Integer errorNum) {
		this.errorNum = errorNum;
	}
	private String updater;//
	private Date updateDate;//
	

	private Integer errorNum=0;
	
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
	@Column(name="ENTRY_DATE")
	public Date getEntryDate() {
		return entryDate;
	}
	@Column(name="SEX")
	public Integer getSex() {
		return sex;
	}
	@Column(name="BUSINESS_LINE",length=100)
	public String getBusinessLine() {
		return businessLine;
	}
	@Column(name="BUG",length=100)
	public String getBug() {
		return bug;
	}
	@Column(name="BUDU",length=100)
	public String getBudu() {
		return budu;
	}
	@Column(name="DEPART",length=100)
	public String getDepart() {
		return depart;
	}
	@Column(name="AREA",length=100)
	public String getArea() {
		return area;
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
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public void setBusinessLine(String businessLine) {
		this.businessLine = businessLine;
	}
	public void setBug(String bug) {
		this.bug = bug;
	}
	public void setBudu(String budu) {
		this.budu = budu;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public void setArea(String area) {
		this.area = area;
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
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Override
	public String toString() {
		return "EmpInfo [id=" + id + ", jobNumber=" + jobNumber + ", empName="
				+ empName + ", entryDate=" + entryDate + ", sex=" + sex
				+ ", businessLine=" + businessLine + ", bug=" + bug + ", budu="
				+ budu + ", depart=" + depart + ", area=" + area + ", creater="
				+ creater + ", createdDate=" + createdDate + ", updater="
				+ updater + ", updateDate=" + updateDate + "]";
	}
	
	
}
