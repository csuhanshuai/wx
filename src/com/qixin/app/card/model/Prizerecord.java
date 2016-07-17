package com.qixin.app.card.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_card_prizerecord")
public class Prizerecord
{

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "openid")
    private String openid;

    @Column(name = "name")
    private String name;

    @Column(name = "mobilephone")
    private String mobilephone;

    @Column(name = "number")
    private int number;

    @Column(name = "prizename")
    private String prizename;

    @Column(name = "isprizes")
    private int isprizes;

    @Column(name = "isreg")
    private int isreg;

    @Column(name = "activitiesid")
    private String activitiesid;

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

    public String getPrizename()
    {
        return prizename;
    }

    public void setPrizename(String prizename)
    {
        this.prizename = prizename;
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
                + this.id + TAB + "openid = " + this.openid + TAB + "name = "
                + this.name + TAB + "mobilephone = " + this.mobilephone + TAB
                + "number = " + this.number + TAB + "prizename = "
                + this.prizename + TAB + "isprizes = " + this.isprizes + TAB
                + "isreg = " + this.isreg + TAB + "activitiesid = "
                + this.activitiesid + TAB + " )";

        return retValue;
    }

}
