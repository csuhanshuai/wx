package com.qixin.app.zjmall.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 产品信息
 */
@Entity
@Table(name = "zjtbl_mall_product")
public class Product implements Serializable
{

    public String getId()
    {

	return id;
    }

    public void setId(String id)
    {

	this.id = id;
    }

    public String getPtitle()
    {

	return ptitle;
    }

    public void setPtitle(String ptitle)
    {

	this.ptitle = ptitle;
    }

    public String getPid()
    {

	return pid;
    }

    public void setPid(String pid)
    {

	this.pid = pid;
    }

    public String getPric()
    {

	return pric;
    }

    public void setPric(String pric)
    {

	this.pric = pric;
    }

    public String getPtype()
    {

	return ptype;
    }

    public void setPtype(String ptype)
    {

	this.ptype = ptype;
    }

    public String getStatus()
    {

	return status;
    }

    public void setStatus(String status)
    {

	this.status = status;
    }

    public String getImgpath()
    {

	return imgpath;
    }

    public void setImgpath(String imgpath)
    {

	this.imgpath = imgpath;
    }

    public String getImgcount()
    {

	return imgcount;
    }

    public void setImgcount(String imgcount)
    {

	this.imgcount = imgcount;
    }

    public String getDescription()
    {

	return description;
    }

    public void setDescription(String description)
    {

	this.description = description;
    }

    public String getLastupdate()
    {

	return lastupdate;
    }

    public void setLastupdate(String lastupdate)
    {

	this.lastupdate = lastupdate;
    }

    public String getRemark()
    {

	return remark;
    }

    public void setRemark(String remark)
    {

	this.remark = remark;
    }

    public static long getSerialversionuid()
    {

	return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

    public Product()
    {

    }

    public Product(String pname, String pid,String uid, String pric,String opric, String ptype,
	    String imgpath, String imgcount, String status, String description,
	    String lastupdate, String remark,int fristimgh,int fristimgw,String category,String isshow)
    {

	this.ptitle = pname;
	this.pid = pid;
	this.uid=uid;
	this.pric = pric;
	this.opric = opric;
	this.ptype = ptype;
	this.imgpath = imgpath;
	this.imgcount = imgcount;
	this.status = status;
	this.description = description;
	this.remark = remark;
	this.lastupdate = lastupdate;
	this.fristimgh=fristimgh;
	this.fristimgw=fristimgw;
	this.category = category;
	this.isshow = isshow;
    }
    
    public Product(String pname, String pid,String uid, String pric,String opric, String ptype,
            String imgpath, String imgcount, String status, String description,
            String lastupdate, String remark,int fristimgh,int fristimgw,String category)
        {

        this.ptitle = pname;
        this.pid = pid;
        this.uid=uid;
        this.pric = pric;
        this.opric = opric;
        this.ptype = ptype;
        this.imgpath = imgpath;
        this.imgcount = imgcount;
        this.status = status;
        this.description = description;
        this.remark = remark;
        this.lastupdate = lastupdate;
        this.fristimgh=fristimgh;
        this.fristimgw=fristimgw;
        this.category = category;
        }

    // Fields
    
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 8)
    private String id;

    // 名称
    @Column(name = "ptitle", length = 60)
    private String ptitle;

    // 存储在其它平台的编号
    @Column(name = "pid", length = 8)
    private String pid;
    
    // 归属商家
    @Column(name = "uid", length = 32)
    private String uid;

    public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	// 价格
    @Column(name = "pric", length = 30)
    private String pric;
    
    // 参考价格
    @Column(name = "opric", length = 30)
    private String opric;
    
    /**
     * 商品类别（1实物商品、2虚拟商品）
     */
    @Column(name = "category", length = 8)
    private String category;

    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOpric()
    {
    
        return opric;
    }

    
    public void setOpric(String opric)
    {
    
        this.opric = opric;
    }

    // 分类标识
    @Column(name = "ptype", length = 8)
    private String ptype;

    // 状态
    @Column(name = "status", length = 5)
    private String status;

    // 图片路径
    @Column(name = "imgpath", length = 150)
    private String imgpath;
    
    @Column(name = "fristimgh")
    private Integer  fristimgh;
   
    @Column(name = "fristimgw")
    private Integer  fristimgw;

  
    private Integer ptop;

    private Integer pleft;
    
    @Column(name = "isshow", length = 5)
    private String isshow;
    
    public String getIsshow()
    {
        return isshow;
    }

    public void setIsshow(String isshow)
    {
        this.isshow = isshow;
    }

    public Integer getPtop()
    {
    
        return ptop;
    }

    
    public void setPtop(Integer ptop)
    {
    
        this.ptop = ptop;
    }

    
    public Integer getPleft()
    {
    
        return pleft;
    }

    
    public void setPleft(Integer pleft)
    {
    
        this.pleft = pleft;
    }

    public Integer getFristimgh()
    {
    
        return fristimgh;
    }

    
    public void setFristimgh(Integer fristimgh)
    {
    
        this.fristimgh = fristimgh;
    }

    
    public Integer getFristimgw()
    {
    
        return fristimgw;
    }

    
    public void setFristimgw(Integer fristimgw)
    {
    
        this.fristimgw = fristimgw;
    }

    // 图片组
    @Column(name = "imgcount", length = 5)
    private String imgcount;

    // 描述Description
    @Column(name = "description", length = 300)
    private String description;

    // 更新时间
    @Column(name = "lastupdate", length = 20)
    private String lastupdate;

    // remark
    @Column(name = "remark", length = 500)
    private String remark;

    /**
     * @return
     */
    @Override
    public String toString()
    {

	StringBuffer sb = new StringBuffer();
	sb.append("[ptitle");
	sb.append(this.ptitle);
	sb.append("][pid_");
	sb.append(this.pid);
	sb.append("][Uid_");
	sb.append(this.uid);
	sb.append("][pric");
	sb.append(this.pric);
	sb.append("][ptype");
	sb.append(this.ptype);
	sb.append("][status");
	sb.append(this.status);
	sb.append("][imgpath");
	sb.append(this.imgpath);
	sb.append("][imgcount");
	sb.append(this.imgcount);
	sb.append("][description");
	sb.append(this.description);
	sb.append("][lastupdate");
	sb.append(this.lastupdate);
	sb.append("][remark");
	sb.append(this.remark);
	sb.append("][isshow");
    sb.append(this.isshow);
	sb.append("]");
	return sb.toString();
    }

}
