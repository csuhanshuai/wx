package com.qixin.app.vote.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.qixin.app.system.user.model.SystemmgtUser;

//晒祝福报名表	_报名
@Entity
@Table(name = "vote_apply")
public class VoteApply {
	
    private String id;//id
	private String code;//编号
	private String name;//
	private String title;//
	private String content;//
	private String imgId;//
	private String linkMan;//
	private String linkMobelNumber;//
	private String description;//
	private Integer voteCount;//
	private Integer status;//
	private String checkId;//
	private Date checkTime;//
	
	private String creater;
	private Date createTime;
	private String updater;
	private Date updateTime;
	
	private String checkName;
	
	


	@Column(name = "check_name",  length = 220)
	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String systemUser) {
		this.checkName = systemUser;
	}

	private String imgUrl;
	
	
	@Column(name = "img_url",  length = 220)
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	 @Column(name = "code",  length = 32)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name",  length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "title",  length = 100)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content",  length = 2000)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "img_id",  length = 2000)
	public String getImgId() {
		return imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	@Column(name = "link_man",  length = 100)
	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	@Column(name = "linkMobelNumber", length = 500)
	public String getLinkMobelNumber() {
		return linkMobelNumber;
	}

	public void setLinkMobelNumber(String linkMobelNumber) {
		this.linkMobelNumber = linkMobelNumber;
	}
	
    @Column(name = "description",  length = 500)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "vote_count", length = 32)
	public Integer getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}

	@Column(name = "status", length = 32)
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "check_id", length = 32)
	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	@Column(name = "check_time",length = 32)
	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	@Column(name="creater", length=100)
	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	@Column(name="createTime", length=100)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
	@Column(name="updater", length=100)
	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	@Column(name="updateTime", length=100)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
