/**
 * 
 */
package com.qixin.app.zjmall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 支付方式
 * @author sky
 *
 */
@Entity
@Table(name = "zjtbl_mall_paytype")
public class PayType {

	/**
	 * 支付方式ID
	 */
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 2)
	private String id;
	
	/**
	 * 支付类型名称
	 */
	@Column(name = "name", unique = true, nullable = false, length = 32)
	private String name;
	
	/**
	 * 是否支持此种支付
	 */
	@Column(name = "issupport", length = 2)
	private String isSupport;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsSupport() {
		return isSupport;
	}

	public void setIsSupport(String isSupport) {
		this.isSupport = isSupport;
	}
	
	public PayType(String id, String name,String isSupport){
		this.id = id;
		this.name = name;
		this.isSupport = isSupport;
	}
	
	public PayType(){
		
	}
}
