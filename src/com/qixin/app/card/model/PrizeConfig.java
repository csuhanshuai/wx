package com.qixin.app.card.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_card_prizeconfig")
public class PrizeConfig
{

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    @Column(name = "v")
    private int v;

    @Column(name = "isprize")
    private int isprize;

    @Column(name = "giftid")
    private String giftid;

    /**
     * 奖品数量
     */
    @Column(name = "number")
    private int number;

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

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
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

    public String getGiftid()
    {
        return giftid;
    }

    public void setGiftid(String giftid)
    {
        this.giftid = giftid;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
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

        retValue = "PrizeConfig ( " + super.toString() + TAB + "id = "
                + this.id + TAB + "name = " + this.name + TAB + "path = "
                + this.path + TAB + "v = " + this.v + TAB + "isprize = "
                + this.isprize + TAB + "giftid = " + this.giftid + TAB
                + "number = " + this.number + TAB + " )";

        return retValue;
    }

}
