package com.qixin.app.zjminweb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_salespromotion")
public class Salespromotion
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

    @Column(name = "starttime", length = 32)
    private Date starttime;

    @Column(name = "endtime", length = 32)
    private Date endtime;

    @Column(name = "usablerange", length = 32)
    private long usablerange;

    /**
     * 是否被停用 1停用 0正常
     */
    @Column(name = "status", length = 10)
    private String status;

    /**
     * 0：充值促销活动 其他值待扩展
     */
    @Column(name = "type", length = 10)
    private String type;

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

    public String getMoney()
    {
        return money;
    }

    public void setMoney(String money)
    {
        this.money = money;
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

    public long getUsablerange()
    {
        return usablerange;
    }

    public void setUsablerange(long usablerange)
    {
        this.usablerange = usablerange;
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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Date getIntime()
    {
        return intime;
    }

    public void setIntime(Date intime)
    {
        this.intime = intime;
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

        retValue = "Salespromotion ( " + super.toString() + TAB + "id = "
                + this.id + TAB + "name = " + this.name + TAB + "money = "
                + this.money + TAB + "starttime = " + this.starttime + TAB
                + "endtime = " + this.endtime + TAB + "usablerange = "
                + this.usablerange + TAB + "status = " + this.status + TAB
                + "type = " + this.type + TAB + "intime = " + this.intime + TAB
                + "bizid = " + this.bizid + TAB + " )";

        return retValue;
    }

}
