/**
 * 
 */
package com.qixin.app.zjmall.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 数据库订单详情表实体对象
 * @author sky
 *
 */
@Entity
@Table(name="zjtbl_mall_order_detail")
public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	
	@Column(name = "orderid", length = 32)
	private String orderId;
	
	/**
	 * 此值 对应表zjtbl_mall_product中的id
	 */
	@Column(name = "pid", length = 32)
	private String pid;
	
	@Column(name="ptitle",length=60)
	private String ptitle;
	
	@Column(name = "buynum")
	private Integer buyNum;
	
	/**
	 * 某一订单中某种商品的金额总数
	 */
	@Column(name = "totalmoney")
	private Float totalMoney;

	/**
	 * 产品的图片路径
	 * 非订单详情表的字段，但订单列表中要显示，在联合查询时把产品表中的图片路径的字段值放到这个订单详情中
	 */
	@Column(name = "imgpath")
	private String imgPath;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public Integer getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}
	public Float getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Float totalMoney) {
		this.totalMoney = totalMoney;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * @param id
	 * @param orderId
	 * @param id2
	 * @param buyNum
	 * @param totalMoney
	 */
	public OrderDetail(String id, String orderId, String pid,String ptitle, Integer buyNum,
			Float totalMoney, String imgPath) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.pid = pid;
		this.ptitle = ptitle;
		this.buyNum = buyNum;
		this.totalMoney = totalMoney;
		this.imgPath = imgPath;
	}

	/**
	 * 
	 */
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}
