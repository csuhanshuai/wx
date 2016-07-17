package com.qixin.app.zjmall.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_mall_cart")
public class Cart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;

	// 商品id
	@Column(name = "pid", length = 50)
	private String pid;

	// 用户id
	@Column(name = "uid", length = 50)
	private String uid;

	// 加入时间
	@Column(name = "addtime", length = 50)
	private String addtime;

	@Column(name = "number")
	private Integer number;

	public Cart(String pid, String uid, String addtime, Integer number) {
		this.uid = uid;
		this.pid = pid;
		this.addtime = addtime;
		this.number = number;
	}

	public Cart(String id, String pid, String uid, String addtime,
			Integer number) {
		this.id = id;
		this.uid = uid;
		this.pid = pid;
		this.addtime = addtime;
		this.number = number;
	}

	public Cart() {
	}

	public String getId() {

		return id;
	}

	public void setId(String id) {

		this.id = id;
	}

	public String getPid() {

		return pid;
	}

	public void setPid(String pid) {

		this.pid = pid;
	}

	public String getUid() {

		return uid;
	}

	public void setUid(String uid) {

		this.uid = uid;
	}

	public String getAddtime() {

		return addtime;
	}

	public void setAddtime(String addtime) {

		this.addtime = addtime;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
