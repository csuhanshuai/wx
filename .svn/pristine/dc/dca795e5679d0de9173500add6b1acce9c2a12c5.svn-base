package com.qixin.app.lanterngame.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
/**
 * 
 * @author liufei
 * 游戏竞猜题目答题表
 */

@Entity
@Table(name="quiz_topic_reply")
public class QuizTopicReply {
	private String id;//id
	private String gameRecordId;//游戏记录id
	private String replyJobNumber;//答题工号
	private String empName;//员工姓名
	private String topicId;//题目id
	private String answerResult;//答案
	private Integer replySpendTime;//答题花费时间
	private Integer score;//得分
	private Date beginTime;//开始时间
	private Date endTime;//结束时间
	private String creater;//
	private Date createdDate;//
	private String updater;//
	private Date updateDate;//
	
	private String topicTitle;
	
	@Transient
	public String getTopicTitle() {
		return topicTitle;
	}
	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}
	
	
	@GenericGenerator(name="generator", strategy="uuid.hex")
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id", unique=true, nullable=false, length=32)
	public String getId() {
		return id;
	}
	@Column(name="GAME_RECORD_ID",length=32)
	public String getGameRecordId() {
		return gameRecordId;
	}
	@Column(name="REPLY_JOB_NUMBER",length=32)
	public String getReplyJobNumber() {
		return replyJobNumber;
	}
	@Column(name="EMP_NAME",length=32)
	public String getEmpName() {
		return empName;
	}
	@Column(name="TOPIC_ID",length=32)
	public String getTopicId() {
		return topicId;
	}
	@Column(name="ANSWER_RESULT",length=100)
	public String getAnswerResult() {
		return answerResult;
	}
	@Column(name="REPLY_SPEND_TIME",length=100)
	public Integer getReplySpendTime() {
		return replySpendTime;
	}
	@Column(name="SCORE",length=100)
	public Integer getScore() {
		return score;
	}
	@Column(name="BEGIN_TIME",length=100)
	public Date getBeginTime() {
		return beginTime;
	}
	@Column(name="END_TIME",length=100)
	public Date getEndTime() {
		return endTime;
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
	public void setGameRecordId(String gameRecordId) {
		this.gameRecordId = gameRecordId;
	}
	public void setReplyJobNumber(String replyJobNumber) {
		this.replyJobNumber = replyJobNumber;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	public void setAnswerResult(String answerResult) {
		this.answerResult = answerResult;
	}
	
	

	public void setReplySpendTime(Integer replySpendTime) {
		this.replySpendTime = replySpendTime;
	}

	

	public void setScore(Integer score) {
		this.score = score;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "QuizTopicReply [id=" + id + ", gameRecordId=" + gameRecordId
				+ ", replyJobNumber=" + replyJobNumber + ", empName=" + empName
				+ ", topicId=" + topicId + ", answerResult=" + answerResult
				+ ", replySpendTime=" + replySpendTime + ", score=" + score
				+ ", beginTime=" + beginTime + ", endTime=" + endTime + "]";
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
