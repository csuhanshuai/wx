package com.qixin.app.zjminweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_IndexModel")
public class IndexModel
{
    // 模板ID
    private String id;

    // 模板类型
    private int type;

    // 模板名称
    private String name;

    // 业务ID
    private String bizid;

    // 模板风格展示图片
    private String imgurl;

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

    @Column(name = "type", length = 4)
    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    @Column(name = "name", length = 1000)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public String getImgurl()
    {
        return imgurl;
    }

    @Column(name = "imgurl", length = 1000)
    public void setImgurl(String imgurl)
    {
        this.imgurl = imgurl;
    }

}
