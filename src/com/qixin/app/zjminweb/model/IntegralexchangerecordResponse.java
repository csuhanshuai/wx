package com.qixin.app.zjminweb.model;

public class IntegralexchangerecordResponse
{
    private String id;

    private Integralexchange integralexchange;

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
     * 是否被兑换0未兑换 1已兑换
     */
    private String isuse;

    /**
     * 使用日期
     */
    private String usertime;

    /**
     * 为空代表积分兑换 1.大转盘 2.刮刮卡 3.摇一摇
     */
    private String type;

    /**
     * type非空时此字段不为空
     */
    private Activities activities;

    /**
     * type非空时此字段不为空
     */
    private Gift gift;

    private String bizid;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Integralexchange getIntegralexchange()
    {
        return integralexchange;
    }

    public void setIntegralexchange(Integralexchange integralexchange)
    {
        this.integralexchange = integralexchange;
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

    public Activities getActivities()
    {
        return activities;
    }

    public void setActivities(Activities activities)
    {
        this.activities = activities;
    }

    public Gift getGift()
    {
        return gift;
    }

    public void setGift(Gift gift)
    {
        this.gift = gift;
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

        retValue = "IntegralexchangerecordResponse ( " + super.toString() + TAB
                + "id = " + this.id + TAB + "integralexchange = "
                + this.integralexchange + TAB + "isreceive = " + this.isreceive
                + TAB + "member = " + this.member + TAB + "receivetime = "
                + this.receivetime + TAB + "isuse = " + this.isuse + TAB
                + "usertime = " + this.usertime + TAB + "type = " + this.type
                + TAB + "activities = " + this.activities + TAB + "gift = "
                + this.gift + TAB + "bizid = " + this.bizid + TAB + " )";

        return retValue;
    }

}
