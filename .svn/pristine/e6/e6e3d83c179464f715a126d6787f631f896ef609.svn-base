package com.qixin.app.zjminweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_titleitems")
public class TitleItems {
	
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
	public String id;
	
	@Column(name="titleId", nullable=false)
	public String titleId;
	
	@Column(name = "content", nullable=false)
	public String content;
	
	@Column(name="selectedTimes")
	public String selectedTimes;
	
	@Column(name="selectName")
	public String selectName;
	
	@Column(name="bizid")
	public String bizid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSelectedTimes() {
		return selectedTimes;
	}

	public void setSelectedTimes(String selectedTimes) {
		this.selectedTimes = selectedTimes;
	}

	public String getBizid() {
		return bizid;
	}

	public void setBizid(String bizid) {
		this.bizid = bizid;
	}

	public String getSelectName() {
		return selectName;
	}

	public void setSelectName(String selectName) {
		this.selectName = selectName;
	}
	
	

}
