package com.qixin.app.wobble.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_wobble_prizerecord")
public class Wobbleprizerecord
{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "activitiesid")
    private String activitiesid;

    @Column(name = "openid")
    private String openid;

    @Column(name = "name")
    private String name;

    @Column(name = "mobilephone")
    private String mobilephone;

    @Column(name = "number")
    private int number;

    @Column(name = "prizeid")
    private String prizeid;

    @Column(name = "isprizes")
    private int isprizes;

    @Column(name = "isreg")
    private int isreg;

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

    public String getOpenid()
    {
        return openid;
    }

    public void setOpenid(String openid)
    {
        this.openid = openid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMobilephone()
    {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone)
    {
        this.mobilephone = mobilephone;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public String getPrizeid()
    {
        return prizeid;
    }

    public void setPrizeid(String prizeid)
    {
        this.prizeid = prizeid;
    }

    public int getIsprizes()
    {
        return isprizes;
    }

    public void setIsprizes(int isprizes)
    {
        this.isprizes = isprizes;
    }

    public int getIsreg()
    {
        return isreg;
    }

    public void setIsreg(int isreg)
    {
        this.isreg = isreg;
    }

    public String getBizid()
    {
        return bizid;
    }

    public void setBizid(String bizid)
    {
        this.bizid = bizid;
    }

    public String getActivitiesid()
    {
        return activitiesid;
    }

    public void setActivitiesid(String activitiesid)
    {
        this.activitiesid = activitiesid;
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

        retValue = "Prizerecord ( " + super.toString() + TAB + "id = "
                + this.id + TAB + "activitiesid = " + this.activitiesid + TAB
                + "openid = " + this.openid + TAB + "name = " + this.name + TAB
                + "mobilephone = " + this.mobilephone + TAB + "number = "
                + this.number + TAB + "prizeid = " + this.prizeid + TAB
                + "isprizes = " + this.isprizes + TAB + "isreg = " + this.isreg
                + TAB + "bizid = " + this.bizid + TAB + " )";

        return retValue;
    }

}
