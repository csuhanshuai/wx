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
@Table(name = "zjtbl_minweb_integralexchange")
public class Integralexchange
{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "validity", length = 32)
    private Date validity;

    @Column(name = "score", length = 32)
    private String score;

    @Column(name = "sum", length = 32)
    private int sum;

    @Column(name = "intime", length = 32, nullable = false)
    private String intime;

    @Lob
    @Column(name = "description", columnDefinition = "LongText", nullable = false)
    private String description;

    /**
     * 0/空值：礼品券 1：优惠券 -1:大转盘 2:刮刮卡 3:摇一摇
     */
    @Column(name = "type", length = 10, nullable = false)
    private String type;

    @Column(name = "imgurl", length = 1000)
    private String imgurl;

    /**
     * type=1时非空
     */
    @Column(name = "couponid", length = 32)
    private String couponid;

    /**
     * 是否限制 1.不限制 其他值限制
     */
    @Column(name = "islimit", length = 10)
    private String islimit;

    @Column(name = "activitiesid", length = 32)
    private String activitiesid;

    @Column(name = "giftid", length = 32)
    private String giftid;

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

    public Date getValidity()
    {
        return validity;
    }

    public void setValidity(Date validity)
    {
        this.validity = validity;
    }

    public String getScore()
    {
        return score;
    }

    public void setScore(String score)
    {
        this.score = score;
    }

    public String getIntime()
    {
        return intime;
    }

    public void setIntime(String intime)
    {
        this.intime = intime;
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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getCouponid()
    {
        return couponid;
    }

    public void setCouponid(String couponid)
    {
        this.couponid = couponid;
    }

    public int getSum()
    {
        return sum;
    }

    public void setSum(int sum)
    {
        this.sum = sum;
    }

    public String getImgurl()
    {
        return imgurl;
    }

    public void setImgurl(String imgurl)
    {
        this.imgurl = imgurl;
    }

    public String getIslimit()
    {
        return islimit;
    }

    public void setIslimit(String islimit)
    {
        this.islimit = islimit;
    }

    public String getActivitiesid()
    {
        return activitiesid;
    }

    public void setActivitiesid(String activitiesid)
    {
        this.activitiesid = activitiesid;
    }

    public String getGiftid()
    {
        return giftid;
    }

    public void setGiftid(String giftid)
    {
        this.giftid = giftid;
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

        retValue = "Integralexchange ( " + super.toString() + TAB + "id = "
                + this.id + TAB + "name = " + this.name + TAB + "validity = "
                + this.validity + TAB + "score = " + this.score + TAB
                + "sum = " + this.sum + TAB + "intime = " + this.intime + TAB
                + "description = " + this.description + TAB + "type = "
                + this.type + TAB + "imgurl = " + this.imgurl + TAB
                + "couponid = " + this.couponid + TAB + "islimit = "
                + this.islimit + TAB + "activitiesid = " + this.activitiesid
                + TAB + "giftid = " + this.giftid + TAB + "memberlevelid = "
                + this.memberlevelid + TAB + "bizid = " + this.bizid + TAB
                + " )";

        return retValue;
    }

}
