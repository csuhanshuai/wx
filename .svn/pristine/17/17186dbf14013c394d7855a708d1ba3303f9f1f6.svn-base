package com.qixin.app.zjminweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_scorllpic")
public class ScrollPicture
{

    //滚动图片ID
    private String id;    
    
    //滚动图片图片地址
    private String picurl;
    
    //点击超链接地址
    private String url;
    
    //业务ID
    private String bizid;

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }


    @Column(name="picurl", length=1000)
    public String getPicUrl()
    {
      return this.picurl;
    }

    public void setPicUrl(String picUrl)
    {
      this.picurl = picUrl;
    }

    @Column(name="url", length=1000)
    public String getUrl()
    {
      return this.url;
    }
    
    public void setUrl(String url)
    {
      this.url = url;
    }
    
    @Column(name = "bizid", length = 1000)
    public String getBizid()
    {
        return bizid;
    }

    public void setBizid(String bizid)
    {
        this.bizid = bizid;
    } 
    
}
