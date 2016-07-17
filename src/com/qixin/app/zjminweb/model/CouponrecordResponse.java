package com.qixin.app.zjminweb.model;

public class CouponrecordResponse
{
    private String id;

    private Coupon coupon;

    /**
     * 是否已被领用 0未领用 1已领用
     */
    private String isreceive;

    /**
     * 领用人
     */
    private Member member;

    /**
     * 领用日期
     */
    private String receivetime;

    /**
     * 是否被使用 0未使用 1已使用
     */
    private String isuse;

    /**
     * 使用日期
     */
    private String usertime;

    /**
     * 关联消费ID
     */
    private Consumption consumption;

    /**
     * 是否过期
     */
    private String isexpire;

    private String bizid;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Coupon getCoupon()
    {
        return coupon;
    }

    public void setCoupon(Coupon coupon)
    {
        this.coupon = coupon;
    }

    public String getIsreceive()
    {
        return isreceive;
    }

    public void setIsreceive(String isreceive)
    {
        this.isreceive = isreceive;
    }

    public Member getMember()
    {
        return member;
    }

    public void setMember(Member member)
    {
        this.member = member;
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

    public Consumption getConsumption()
    {
        return consumption;
    }

    public void setConsumption(Consumption consumption)
    {
        this.consumption = consumption;
    }

    public String getBizid()
    {
        return bizid;
    }

    public void setBizid(String bizid)
    {
        this.bizid = bizid;
    }

    public String getIsexpire()
    {
        return isexpire;
    }

    public void setIsexpire(String isexpire)
    {
        this.isexpire = isexpire;
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

        retValue = "CouponrecordResponse ( " + super.toString() + TAB + "id = "
                + this.id + TAB + "coupon = " + this.coupon + TAB
                + "isreceive = " + this.isreceive + TAB + "member = "
                + this.member + TAB + "receivetime = " + this.receivetime + TAB
                + "isuse = " + this.isuse + TAB + "usertime = " + this.usertime
                + TAB + "consumption = " + this.consumption + TAB
                + "isexpire = " + this.isexpire + TAB + "bizid = " + this.bizid
                + TAB + " )";

        return retValue;
    }

}
