/**
 * 
 */
package com.qixin.app.zjmall.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 数据库订单表实体对象
 * @author sky
 *
 */
@Entity
@Table(name="zjtbl_mall_order")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id", unique = true, nullable = false, length = 8)
	private String id;
	
	@Column(name = "uid", length = 50)
	private String uid;
	
	@Column(name = "receiver", length = 255)
	private String receiver;
	
	@Column(name = "receiveaddr", length = 255)
	private String receiveAddr;
	
	@Column(name = "phonenum", length = 15)
	private String phoneNum;
	
	@Column(name = "postnum", length = 8)
	private String postNum;
	
	@Column(name = "ordertime", length = 50)
	private Date orderTime;
	
	@Column(name = "expcompany", length = 100)
	private String expCompany;
	
	@Column(name = "expnum", length = 50)
	private String expNum;
	
	@Column(name = "status" )
	private Integer status;

	/**
	 * 该订单的总金额
	 */
	@Column(name = "totalmoney")
	private Float totalMoney;
	
	/**
	 * 支付方式
	 */
	@Column(name = "paytype", length = 20)
	private String payType;
	
	/**
	 * 优惠金额
	 */
	@Column(name = "couponMoney")
	private Float couponMoney;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiveAddr() {
		return receiveAddr;
	}

	public void setReceiveAddr(String receiveAddr) {
		this.receiveAddr = receiveAddr;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPostNum() {
		return postNum;
	}

	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getExpCompany() {
		return expCompany;
	}

	public void setExpCompany(String expCompany) {
		this.expCompany = expCompany;
	}

	public String getExpNum() {
		return expNum;
	}

	public void setExpNum(String expNum) {
		this.expNum = expNum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Float getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Float totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	/**
	 * @param id
	 * @param uid
	 * @param receiver
	 * @param receiveAdrr
	 * @param phoneNum
	 * @param postNum
	 * @param orderTime
	 * @param expCompany
	 * @param expNum
	 * @param status
	 */
	public Order(String id, String uid, String receiver, String receiveAddr,
			String phoneNum, String postNum, Date orderTime,
			String expCompany, String expNum, Integer status, Float totalMoney, String payType, Float couponMoney) {
		super();
		this.id = id;
		this.uid = uid;
		this.receiver = receiver;
		this.receiveAddr = receiveAddr;
		this.phoneNum = phoneNum;
		this.postNum = postNum;
		this.orderTime = orderTime;
		this.expCompany = expCompany;
		this.expNum = expNum;
		this.status = status;
		this.totalMoney = totalMoney;
		this.payType = payType;
		this.couponMoney = couponMoney;
	}

	/**
	 * 
	 */
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Float getCouponMoney() {
		return couponMoney;
	}

	public void setCouponMoney(Float couponMoney) {
		this.couponMoney = couponMoney;
	}
	
	
}
