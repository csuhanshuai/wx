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
 * 竞猜题目表
 */
@Entity
@Table(name="quiz_topic")
public class QuizTopic {
	private String id;//id
	private String title;//标题
	private String content;//内容
	private String imgId;//图片ID
	private String rightTitle;//正确答案
	private Integer maxSubmitTime;//最长答题时间
	private Integer topicScore;//题目分数
	
	private String creater;
	private Date createTime;
	private String updater;
	private Date updateTime;
	
	private String imgUrl;
	
	
	//private int imgDir;//图片路径
	@Column(name="imgUrl", length=100)
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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

	@GenericGenerator(name="generator", strategy="uuid.hex")
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id", unique=true, nullable=false, length=32)
	public String getId() {
		return id;
	}
	
//	@Column(name="img_dir", length=100)
//	public String getImgDir() {
//		return imgDir;
//	}
	
	
	@Column(name="title", length=100)
	public String getTitle() {
		return title;
	}
	@Column(name="CONTENT", length=500)
	public String getContent() {
		return content;
	}
	
	@Column(name="IMG_ID", length=500)
	public String getImgId() {
		return imgId;
	}
	
	@Column(name="RIGHT_TITLE", length=100)
	public String getRightTitle() {
		return rightTitle;
	}
	@Column(name="MAX_SUBMIT_TIME", length=100)
	public Integer getMaxSubmitTime() {
		return maxSubmitTime;
	}
	@Column(name="TOPIC_SCORE", length=100)
	public Integer getTopicScore() {
		return topicScore;
	}
	
	
	
	public void setId(String id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setRightTitle(String rightTitle) {
		this.rightTitle = rightTitle;
	}
	public void setMaxSubmitTime(Integer maxSubmitTime) {
		this.maxSubmitTime = maxSubmitTime;
	}
	public void setTopicScore(Integer topicScore) {
		this.topicScore = topicScore;
	}
//	public void setImgDir(String imgDir) {
//		this.imgDir = imgDir;
//	}
	@Override
	public String toString() {
		return "QuizTopic [id=" + id + ", title=" + title + ", content="
				+ content + ", imgId=" + imgId + ", rightTitle=" + rightTitle
				+ ", maxSubmitTime=" + maxSubmitTime + ", topicScore="
				+ topicScore + "]";
	}

	

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	

	
	
	
	
}
