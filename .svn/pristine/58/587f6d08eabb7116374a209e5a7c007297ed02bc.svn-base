package com.qixin.app.zjminweb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_consumption")
public class Consumption
{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "memberid", length = 32)
    private String memberid;

    /**
     * 消费金额
     */
    @Column(name = "money", length = 32)
    private String money;

    /**
     * 消费时间
     */
    @Column(name = "intime", length = 32)
    private Date intime;

    /**
     * 消费项目
     */
    @Column(name = "reasons", length = 5000)
    private String reasons;

    @Column(name = "status", length = 10)
    private String status;

    /**
     * 0：空/消费 1：充值/收入
     */
    @Column(name = "type", length = 10)
    private String type;

    @Column(name = "balance", length = 32)
    private String balance;

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

    public String getMemberid()
    {
        return memberid;
    }

    public void setMemberid(String memberid)
    {
        this.memberid = memberid;
    }

    public String getMoney()
    {
        return money;
    }

    public void setMoney(String money)
    {
        this.money = money;
    }

    public Date getIntime()
    {
        return intime;
    }

    public void setIntime(Date intime)
    {
        this.intime = intime;
    }

    public String getReasons()
    {
        return reasons;
    }

    public void setReasons(String reasons)
    {
        this.reasons = reasons;
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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getBalance()
    {
        return balance;
    }

    public void setBalance(String balance)
    {
        this.balance = balance;
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

        retValue = "Consumption ( " + super.toString() + TAB + "id = "
                + this.id + TAB + "memberid = " + this.memberid + TAB
                + "money = " + this.money + TAB + "intime = " + this.intime
                + TAB + "reasons = " + this.reasons + TAB + "status = "
                + this.status + TAB + "type = " + this.type + TAB
                + "balance = " + this.balance + TAB + "bizid = " + this.bizid
                + TAB + " )";

        return retValue;
    }

}
