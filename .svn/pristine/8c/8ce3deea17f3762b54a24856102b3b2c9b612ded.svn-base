package com.qixin.app.zjminweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_pagebaseinfo")
public class BaseInfo
{

    // 模板ID
    private String id;
    
    //业务ID
    private String bizid;
    
    // 页脚
    private String footer;

    // 开发商
    private String developer;

    // 开发商介绍URL
    private String dvlUrl;
    
    //背景图片
    private String backgroundUrl;    
    
    //模板ID
    private String modelid;
    

    @Column(name = "modelid", length = 32)
    public String getModelid()
    {
        return modelid;
    }

    public void setModelid(String modelid)
    {
        this.modelid = modelid;
    }

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

    @Column(name = "footer", length = 1000)
    public String getFooter()
    {
        return footer;
    }

    public void setFooter(String footer)
    {
        this.footer = footer;
    }

    @Column(name = "developer", length = 1000)
    public String getDeveloper()
    {
        return developer;
    }

    public void setDeveloper(String developer)
    {
        this.developer = developer;
    }

    @Column(name = "dvlUrl", length = 1000)
    public String getDvlUrl()
    {
        return dvlUrl;
    }

    public void setDvlUrl(String dvlUrl)
    {
        this.dvlUrl = dvlUrl;
    }

    @Column(name = "backgroundUrl", length = 1000)
    public String getBackgroundUrl()
    {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl)
    {
        this.backgroundUrl = backgroundUrl;
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
