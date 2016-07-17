/**
 * 
 */
package com.qixin.app.zjmall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author sky
 * 商品标签
 */
@Entity
@Table(name = "zjtbl_mall_label")
public class Label {
	/**
	 * 标签ID
	 */
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	
	/**
	 * 标签名
	 */
	@Column(name = "name", unique = true, nullable = false, length = 50)
	private String name;

	@Column(name = "addtime", length = 30)
    private String addtime;
	
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
	
	public Label(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	public Label(){
		
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
}
