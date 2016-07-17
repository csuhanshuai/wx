package com.qixin.app.zjmall.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zxtbl_mall_user")
public class MallUser implements Serializable
{
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
    
    // 商家id
    @Column(name = "bid", length = 32)
    private String bid;
    
    // 外部id
    @Column(name = "extid", length = 128)
    private String extid;
    
    // 权级标识
    @Column(name = "level", length = 32)
    private String level;
    
    //登录名
    @Column(name = "uname", length = 64)
    private String uname;
    //密码
    @Column(name = "pwd", length = 64)
    private String pwd;
    //邮箱
    @Column(name = "mail", length = 96)
    private String mail;
    //状态
    @Column(name = "status", length = 16)
    private String status;
    //注册时间
    @Column(name = "addtime", length = 64)
    private String addtime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getExtid() {
		return extid;
	}
	public void setExtid(String extid) {
		this.extid = extid;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
