package com.qixin.app.zjminweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zjtbl_minweb_integralexchangerecord")
public class Integralexchangerecord
{
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 9)
    private String id;

    @Column(name = "integralexchangeid", length = 32)
    private String integralexchangeid;

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
     * 是否被兑换0未兑换 1已兑换
     */
    @Column(name = "isuse", length = 32)
    private String isuse;

    /**
     * 使用日期
     */
    @Column(name = "usertime", length = 32)
    private String usertime;

    /**
     * 为空代表积分兑换 1.大转盘 2.刮刮卡 3.摇一摇
     */
    @Column(name = "type")
    private String type;

    /**
     * type非空时此字段不为空
     */
    @Column(name = "activitiesid")
    private String activitiesid;

    /**
     * type非空时此字段不为空
     */
    @Column(name = "giftid")
    private String giftid;

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

    public String getIntegralexchangeid()
    {
        return integralexchangeid;
    }

    public void setIntegralexchangeid(String integralexchangeid)
    {
        this.integralexchangeid = integralexchangeid;
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

        retValue = "Integralexchangerecord ( " + super.toString() + TAB
                + "id = " + this.id + TAB + "integralexchangeid = "
                + this.integralexchangeid + TAB + "isreceive = "
                + this.isreceive + TAB + "memberid = " + this.memberid + TAB
                + "receivetime = " + this.receivetime + TAB + "isuse = "
                + this.isuse + TAB + "usertime = " + this.usertime + TAB
                + "type = " + this.type + TAB + "activitiesid = "
                + this.activitiesid + TAB + "giftid = " + this.giftid + TAB
                + "bizid = " + this.bizid + TAB + " )";

        return retValue;
    }

}
