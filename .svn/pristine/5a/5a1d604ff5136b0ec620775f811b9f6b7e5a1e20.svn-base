package com.qixin.app.vote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "act_vote")
public class Vote {
	private String id;//id
	private String title;//标题
	private String content;//内容
	private String beginTime;//开始时间
	private String endTime;//结束时间
	private String imgId;//图片地址
	private String createTime;//创建时间
	private String bgMusic;//背景音乐
	private Integer passCount;//审核通过数
	private Integer signCount;//报名数
	private Integer lookCount;//浏览数
	private Integer voteTotalCount;//总投票数
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
	@Column(name = "title",length = 100)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name = "content",length = 5000)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name = "begin_time",length=32)
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	@Column(name = "end_time",length=32)
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Column(name = "img_id",length=100)
	public String getImgId() {
		return imgId;
	}
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	@Column(name = "create_time",length=32)
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Column(name = "bg_music",length=100)
	public String getBgMusic() {
		return bgMusic;
	}
	public void setBgMusic(String bgMusic) {
		this.bgMusic = bgMusic;
	}
	@Column(name = "pass_count",length=32)
	public Integer getPassCount() {
		return passCount;
	}
	public void setPassCount(Integer passCount) {
		this.passCount = passCount;
	}
	@Column(name = "sign_count",length=32)
	public Integer getSignCount() {
		return signCount;
	}
	public void setSignCount(Integer signCount) {
		this.signCount = signCount;
	}
	@Column(name = "look_count",length=32)
	public Integer getLookCount() {
		return lookCount;
	}
	public void setLookCount(Integer lookCount) {
		this.lookCount = lookCount;
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
	
	
	@Column(name = "VOTE_COUNT",length=100)
	public Integer getVoteTotalCount() {
		return voteTotalCount;
	}
	public void setVoteTotalCount(Integer voteTotalCount) {
		this.voteTotalCount = voteTotalCount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
