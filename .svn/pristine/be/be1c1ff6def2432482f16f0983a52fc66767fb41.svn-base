package com.qixin.app.zjminweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_couponrecord")
public class Couponrecord
{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "couponid", length = 32)
    private String couponid;

    /**
     * 是否已被领用 0未领用 1已领用
     */
    @Column(name = "isreceive", length = 32)
    private String isreceive;

    /**
     * 领用人
     */
    @Column(name = "memberid", length = 32)
    private String memberid;

    /**
     * 领用日期
     */
    @Column(name = "receivetime", length = 32)
    private String receivetime;

    /**
     * 是否被使用 0未使用 1已使用
     */
    @Column(name = "isuse", length = 32)
    private String isuse;

    /**
     * 使用日期
     */
    @Column(name = "usertime", length = 32)
    private String usertime;

    /**
     * 关联消费ID
     */
    @Column(name = "consumptionid", length = 32)
    private String consumptionid;

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

    public String getCouponid()
    {
        return couponid;
    }

    public void setCouponid(String couponid)
    {
        this.couponid = couponid;
    }

    public String getIsreceive()
    {
        return isreceive;
    }

    public void setIsreceive(String isreceive)
    {
        this.isreceive = isreceive;
    }

    public String getMemberid()
    {
        return memberid;
    }

    public void setMemberid(String memberid)
    {
        this.memberid = memberid;
    }

    public String getReceivetime()
    {
        return receivetime;
    }

    public void setReceivetime(String receivetime)
    {
        this.receivetime = receivetime;
    }

    public String getIsuse()
    {
        return isuse;
    }

    public void setIsuse(String isuse)
    {
        this.isuse = isuse;
    }

    public String getUsertime()
    {
        return usertime;
    }

    public void setUsertime(String usertime)
    {
        this.usertime = usertime;
    }

    public String getConsumptionid()
    {
        return consumptionid;
    }

    public void setConsumptionid(String consumptionid)
    {
        this.consumptionid = consumptionid;
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

        retValue = "CouponRecord ( " + super.toString() + TAB + "id = "
                + this.id + TAB + "couponid = " + this.couponid + TAB
                + "isreceive = " + this.isreceive + TAB + "memberid = "
                + this.memberid + TAB + "receivetime = " + this.receivetime
                + TAB + "isuse = " + this.isuse + TAB + "usertime = "
                + this.usertime + TAB + "consumptionid = " + this.consumptionid
                + TAB + "bizid = " + this.bizid + TAB + " )";

        return retValue;
    }

}
