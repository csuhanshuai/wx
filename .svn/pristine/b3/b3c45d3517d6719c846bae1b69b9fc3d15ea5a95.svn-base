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
@Table(name = "zjtbl_minweb_activities")
public class Activities
{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "name", length = 32, nullable = false)
    private String name;

    @Column(name = "photourl", length = 1000, nullable = false)
    private String photourl;

    @Lob
    @Column(name = "description", columnDefinition = "LongText", nullable = false)
    private String description;

    @Column(name = "url", length = 1000, nullable = false)
    private String url;

    @Column(name = "starttime", length = 32, nullable = false)
    private Date starttime;

    @Column(name = "endtime", length = 32, nullable = false)
    private Date endtime;

    /**
     * 1报名类活动 0/空：非报名类活动 2:摇一摇 3：刮刮卡 4：大转盘
     */
    @Column(name = "type", length = 32)
    private String type;

    @Column(name = "memberlevelid", length = 32)
    private String memberlevelid;

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

    public String getPhotourl()
    {
        return photourl;
    }

    public void setPhotourl(String photourl)
    {
        this.photourl = photourl;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getBizid()
    {
        return bizid;
    }

    public void setBizid(String bizid)
    {
        this.bizid = bizid;
    }

    public Date getStarttime()
    {
        return starttime;
    }

    public void setStarttime(Date starttime)
    {
        this.starttime = starttime;
    }

    public Date getEndtime()
    {
        return endtime;
    }

    public void setEndtime(Date endtime)
    {
        this.endtime = endtime;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getMemberlevelid()
    {
        return memberlevelid;
    }

    public void setMemberlevelid(String memberlevelid)
    {
        this.memberlevelid = memberlevelid;
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

        retValue = "Activities ( " + super.toString() + TAB + "id = " + this.id
                + TAB + "name = " + this.name + TAB + "photourl = "
                + this.photourl + TAB + "description = " + this.description
                + TAB + "url = " + this.url + TAB + "starttime = "
                + this.starttime + TAB + "endtime = " + this.endtime + TAB
                + "type = " + this.type + TAB + "memberlevelid = "
                + this.memberlevelid + TAB + "bizid = " + this.bizid + TAB
                + " )";

        return retValue;
    }

}
