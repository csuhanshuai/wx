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
 * 活动信息表
 */

@Entity
@Table(name="act_info")
public class ActInfo {
	private String id;//id
	private String title;//标题
	private String content;//内容
	private Date beginTime;//开始时间
	private Date endTime;//结束时间
	
	
	private String imgId;//图片路径
	
	private String bgMusic;//背景音乐
	private Integer lookCount;//活动浏览数
	private String creater;//
	private Date createdDate;//创建时间
	private String updater;//
	private Date updateDate;//
	private String imgDirec;
	
	
	@GenericGenerator(name="generator", strategy="uuid.hex")
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id", unique=true, nullable=false, length=32)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name="title", length=100)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="content", length=5000)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name="BEGIN_TIME")
	public Date getBeginTime() {
		return beginTime;
	}
	@Column(name="END_TIME")
	public Date getEndTime() {
		return endTime;
	}
	
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	@Column(name="IMG_ID", length=32)
	public String getImgId() {
		return imgId;
	}
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	
	@Column(name="bg_music", length=32)
	public String getBgMusic() {
		return bgMusic;
	}
	public void setBgMusic(String bgMusic) {
		this.bgMusic = bgMusic;
	}
	@Column(name="LOOK_COUNT", length=32)
	public Integer getLookCount() {
		return lookCount;
	}
	public void setLookCount(Integer lookCount) {
		this.lookCount = lookCount;
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
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@Column(name="img_Direc", length=100)
	public String getImgDirec() {
		return imgDirec;
	}
	public void setImgDirec(String imgDirec) {
		this.imgDirec = imgDirec;
	}
	@Override
	public String toString() {
		return "ActInfo [id=" + id + ", title=" + title + ", content="
				+ content + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", imgId=" + imgId + ", bgMusic=" + bgMusic + ", lookCount="
				+ lookCount + ", creater=" + creater + ", createdDate="
				+ createdDate + ", updater=" + updater + ", updateDate="
				+ updateDate + ", imgDirec=" + imgDirec + "]";
	}
	
}
