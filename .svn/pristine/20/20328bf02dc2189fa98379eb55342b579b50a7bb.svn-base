package com.qixin.app.zjminweb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_signin")
public class Signin
{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "name", length = 32)
    private String name;

    @Column(name = "url", length = 1000)
    private String url;

    @Column(name = "path", length = 1000)
    private String path;

    @Lob
    @Column(name = "description", columnDefinition = "LongText", nullable = false)
    private String description;

    /**
     * 是否被停用 1停用 0正常
     */
    @Column(name = "status", length = 10)
    private String status;

    @Column(name = "intime", length = 32)
    private Date intime;

    @Column(name = "bizid")
    private String bizid;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    public Date getIntime()
    {
        return intime;
    }

    public void setIntime(Date intime)
    {
        this.intime = intime;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    /**
     * Constructs a <code>String</code> with all attributes in name = value
     * format.
     * 
     * @return a <code>String</code> representation of this object.
     */
    public String toString()
    {
        final String TAB = "    ";

        String retValue = "";

        retValue = "Signin ( " + super.toString() + TAB + "id = " + this.id
                + TAB + "name = " + this.name + TAB + "url = " + this.url + TAB
                + "path = " + this.path + TAB + "description = "
                + this.description + TAB + "status = " + this.status + TAB
                + "intime = " + this.intime + TAB + "bizid = " + this.bizid
                + TAB + " )";

        return retValue;
    }

}
