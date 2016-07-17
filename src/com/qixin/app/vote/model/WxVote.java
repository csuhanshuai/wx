package com.qixin.app.vote.model;
/**
 * 微信_投票表
 */
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "wx_vote")
public class WxVote {
	private String id;//id
	private String voteId;//投票id
	private String openId;//投票微信号
	private String empNumber;//员工工号
	private Date voteTime;//投票时间
	private String creater;//
	private String createDate;//
	private String updater;//
	private String updaterTime;//
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
   
	
	
	@Column(name = "id",length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "vote_id",length = 32)
	public String getVoteId() {
		return voteId;
	}

	public void setVoteId(String voteId) {
		this.voteId = voteId;
	}
	@Column(name = "open_id",length = 100)
	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	@Column(name = "emp_number", length = 32)
	public String getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}
	@Column(name = "vote_time", length = 32)
	public Date getVoteTime() {
		return voteTime;
	}

	public void setVoteTime(Date voteTime) {
		this.voteTime = voteTime;
	}
	@Column(name = "creater",length=100)
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	@Column(name = "create_date",length=100)
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Column(name = "updater",length=100)
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	@Column(name = "update_date",length=100)
	public String getUpdaterTime() {
		return updaterTime;
	}
	public void setUpdaterTime(String updaterTime) {
		this.updaterTime = updaterTime;
	}
	
	
	
}
