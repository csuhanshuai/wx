package com.qixin.app.zjminweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_photo")
public class Photo
{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "almid")
    private String almid;

    @Column(name = "url", length = 1000)
    private String url;

    @Column(name = "iscovers", length = 1)
    private String iscovers;

    @Column(name = "description", length = 1000)
    private String description;

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

    public String getAlmid()
    {
        return almid;
    }

    public void setAlmid(String almid)
    {
        this.almid = almid;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getIscovers()
    {
        return iscovers;
    }

    public void setIscovers(String iscovers)
    {
        this.iscovers = iscovers;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getBizid()
    {
        return bizid;
    }

    public void setBizid(String bizid)
    {
        this.bizid = bizid;
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

        retValue = "Photo ( " + super.toString() + TAB + "id = " + this.id
                + TAB + "almid = " + this.almid + TAB + "url = " + this.url
                + TAB + "iscovers = " + this.iscovers + TAB + "description = "
                + this.description + TAB + "bizid = " + this.bizid + TAB + " )";

        return retValue;
    }

}
