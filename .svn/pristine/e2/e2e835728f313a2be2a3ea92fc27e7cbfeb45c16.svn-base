package com.qixin.app.wobble.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_wobble_prize")
public class Wobbleprize
{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "v")
    private int v;

    @Column(name = "isprize")
    private int isprize;

    /**
     * 奖品数量
     */
    @Column(name = "number")
    private int number;

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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getV()
    {
        return v;
    }

    public void setV(int v)
    {
        this.v = v;
    }

    public int getIsprize()
    {
        return isprize;
    }

    public void setIsprize(int isprize)
    {
        this.isprize = isprize;
    }

    public String getBizid()
    {
        return bizid;
    }

    public void setBizid(String bizid)
    {
        this.bizid = bizid;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
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

        retValue = "Wobbleprize ( " + super.toString() + TAB + "id = "
                + this.id + TAB + "name = " + this.name + TAB
                + "description = " + this.description + TAB + "v = " + this.v
                + TAB + "isprize = " + this.isprize + TAB + "number = "
                + this.number + TAB + "giftid = " + this.giftid + TAB
                + "bizid = " + this.bizid + TAB + " )";

        return retValue;
    }

}
