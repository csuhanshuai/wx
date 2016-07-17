package com.qixin.app.zjminweb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_coupon")
public class Coupon
{

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "name", length = 32)
    private String name;

    @Column(name = "money", length = 32)
    private String money;

    @Column(name = "validitystart", length = 32)
    private Date validitystart;

    @Column(name = "validityend", length = 32)
    private Date validityend;

    @Column(name = "usablerange", length = 32)
    private float usablerange;

    @Column(name = "sum", length = 32)
    private int sum;

    /**
     * 是否被停用 1停用 0正常
     */
    @Column(name = "status", length = 10)
    private String status;

    /**
     * 是否用于积分兑换用 1用于积分兑换 其他值不用于兑换
     */
    @Column(name = "type", length = 10)
    private String type;

    /**
     * 是否限制 1.不限制 其他值限制
     */
    @Column(name = "islimit", length = 10)
    private String islimit;

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

    public String getMoney()
    {
        return money;
    }

    public void setMoney(String money)
    {
        this.money = money;
    }

    public Date getValiditystart()
    {
        return validitystart;
    }

    public void setValiditystart(Date validitystart)
    {
        this.validitystart = validitystart;
    }

    public Date getValidityend()
    {
        return validityend;
    }

    public void setValidityend(Date validityend)
    {
        this.validityend = validityend;
    }

    public void setSum(int sum)
    {
        this.sum = sum;
    }

    public float getUsablerange()
    {
        return usablerange;
    }

    public void setUsablerange(float usablerange)
    {
        this.usablerange = usablerange;
    }

    public String getBizid()
    {
        return bizid;
    }

    public void setBizid(String bizid)
    {
        this.bizid = bizid;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public int getSum()
    {
        return sum;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getIslimit()
    {
        return islimit;
    }

    public void setIslimit(String islimit)
    {
        this.islimit = islimit;
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

        retValue = "Coupon ( " + super.toString() + TAB + "id = " + this.id
                + TAB + "name = " + this.name + TAB + "money = " + this.money
                + TAB + "validitystart = " + this.validitystart + TAB
                + "validityend = " + this.validityend + TAB + "usablerange = "
                + this.usablerange + TAB + "sum = " + this.sum + TAB
                + "status = " + this.status + TAB + "type = " + this.type + TAB
                + "islimit = " + this.islimit + TAB + "memberlevelid = "
                + this.memberlevelid + TAB + "bizid = " + this.bizid + TAB
                + " )";

        return retValue;
    }

}
