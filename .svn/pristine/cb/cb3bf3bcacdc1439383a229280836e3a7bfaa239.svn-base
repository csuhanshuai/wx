package com.qixin.app.zjminweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_baoming")
public class Baoming {

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
	public String id;
	
	@Column(name = "name", length = 32, nullable = false)
	public String name;
	
	@Column(name = "mobile", length = 32, nullable = false)
	public String mobile;
	
	@Column(name="activitiesid")
	public String activitiesid;
	
	@Column(name = "bizid")
	public String bizid;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBizid() {
		return bizid;
	}

	public void setBizid(String bizid) {
		this.bizid = bizid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActivitiesid() {
		return activitiesid;
	}

	public void setActivitiesid(String activitiesid) {
		this.activitiesid = activitiesid;
	}
	
	
}
