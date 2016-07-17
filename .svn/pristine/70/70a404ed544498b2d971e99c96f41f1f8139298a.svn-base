package com.qixin.app.zjmall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_mall_skin")
public class Skin
{
  
    // Fields
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;
    // 
    @Column(name = "skinid")
    private Integer skinid;
    
    @Column(name = "skinname",length = 32)
    private String skinname;
      // 设置id
    @Column(name = "navindex")
    private Integer navindex;
    // 商城状态 1、URL 2、Text 3、链接id
    @Column(name = "settype")
    private Integer settype;
        // 商城状态 1、正常 模式 0、锁定 模式 2、试用 模式 3、全开模式
    @Column(name = "description",length = 128)
    private String description;
    
    @Column(name = "defaultvalue",length = 128)
    private String defaultvalue;
    @Column(name = "defaultkey",length = 128)
    private String defaultkey;
    public String getDefaultkey()
    {
        return defaultkey;
    }

    public void setDefaultkey(String defaultkey)
    {
        this.defaultkey = defaultkey;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Integer getSkinid()
    {
        return skinid;
    }

    public void setSkinid(Integer skinid)
    {
        this.skinid = skinid;
    }

    public Integer getNavindex()
    {
        return navindex;
    }

    public void setNavindex(Integer navindex)
    {
        this.navindex = navindex;
    }

    public Integer getSettype()
    {
        return settype;
    }

    public void setSettype(Integer settype)
    {
        this.settype = settype;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDefaultvalue()
    {
        return defaultvalue;
    }

    public void setDefaultvalue(String targetlab)
    {
        this.defaultvalue = targetlab;
    }
    public String getSkinname()
    {
        return skinname;
    }

    public void setSkinname(String skinname)
    {
        this.skinname = skinname;
    }
     
}
