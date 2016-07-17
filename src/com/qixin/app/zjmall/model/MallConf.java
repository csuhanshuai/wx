package com.qixin.app.zjmall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zjtbl_mall_mallconf")
public class MallConf
{
    // 商家标识
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String bizid;

    // 商城名
    @Column(name = "mallname", length = 50)
    private String mallname;
    // 主页logo
    @Column(name = "skinid")
    private Integer skinid;
    // 客服热线
    @Column(name = "cstel", length = 20)
    private String cstel;
    // 更新时间
    @Column(name = "updatetime", length = 20)
    private String updatetime;
    // 商城状态 1、正常 模式 0、锁定 模式 2、试用 模式 3、全开模式
    @Column(name = "status", length = 20)
    private String status;
    
    @Column(name = "outtimeset", length = 3)
    private String outtimeset;
    
    public String getOuttimeset() {
		return outtimeset;
	}



	public void setOuttimeset(String outtimeset) {
		this.outtimeset = outtimeset;
	}

	@Column(name = "footword", length = 64)
    private String footword;
    
    
    public String getFootword() {
		return footword;
	}



	public void setFootword(String footword) {
		this.footword = footword;
	}

	// 商城URL 首页
    @Column(name = "url", length = 128)
    private String url;
    
     public String getMallname()
    {
        return mallname;
    }

    

	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public Integer getSkinid() {
		return skinid;
	}



	public void setSkinid(Integer skinid) {
		this.skinid = skinid;
	}



	public void setMallname(String mallname)
    {
        this.mallname = mallname;
    }

    public String getCstel()
    {
        return cstel;
    }

    public void setCstel(String cstel)
    {
        this.cstel = cstel;
    }

    public String getUpdatetime()
    {
        return updatetime;
    }

    public void setUpdatetime(String updatetime)
    {
        this.updatetime = updatetime;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getBizid()
    {
        return bizid;
    }

    public void setBizid(String bizid)
    {
        this.bizid = bizid;
    }

}
