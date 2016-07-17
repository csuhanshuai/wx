package com.qixin.app.zjminweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_membercard")
public class Membercard
{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "name", length = 32)
    private String name;

    @Column(name = "namecolor", length = 10)
    private String namecolor;

    @Column(name = "numbercolor", length = 10)
    private String numbercolor;

    @Column(name = "bgurl", length = 1000)
    private String bgurl;

    @Column(name = "logourl", length = 1000)
    private String logourl;

    @Column(name = "shopname", length = 1000)
    private String shopname;

    @Column(name = "shopaddress", length = 1000)
    private String shopaddress;

    @Column(name = "shoptelephone", length = 32)
    private String shoptelephone;

    @Lob
    @Column(name = "shopdescription", columnDefinition = "LongText", nullable = false)
    private String shopdescription;

    @Column(name = "cardnoinit", length = 32)
    private String cardnoinit = "800001";

    /**
     * 经度
     */
    @Column(name = "longitude", length = 32)
    private String longitude;

    /**
     * 纬度
     */
    @Column(name = "latitude", length = 32)
    private String latitude;

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

    public String getNamecolor()
    {
        return namecolor;
    }

    public void setNamecolor(String namecolor)
    {
        this.namecolor = namecolor;
    }

    public String getNumbercolor()
    {
        return numbercolor;
    }

    public void setNumbercolor(String numbercolor)
    {
        this.numbercolor = numbercolor;
    }

    public String getBgurl()
    {
        return bgurl;
    }

    public void setBgurl(String bgurl)
    {
        this.bgurl = bgurl;
    }

    public String getLogourl()
    {
        return logourl;
    }

    public void setLogourl(String logourl)
    {
        this.logourl = logourl;
    }

    public String getShopname()
    {
        return shopname;
    }

    public void setShopname(String shopname)
    {
        this.shopname = shopname;
    }

    public String getShoptelephone()
    {
        return shoptelephone;
    }

    public void setShoptelephone(String shoptelephone)
    {
        this.shoptelephone = shoptelephone;
    }

    public String getBizid()
    {
        return bizid;
    }

    public void setBizid(String bizid)
    {
        this.bizid = bizid;
    }

    public String getShopaddress()
    {
        return shopaddress;
    }

    public void setShopaddress(String shopaddress)
    {
        this.shopaddress = shopaddress;
    }

    public String getShopdescription()
    {
        return shopdescription;
    }

    public void setShopdescription(String shopdescription)
    {
        this.shopdescription = shopdescription;
    }

    public String getCardnoinit()
    {
        return cardnoinit;
    }

    public void setCardnoinit(String cardnoinit)
    {
        this.cardnoinit = cardnoinit;
    }

    public String getLongitude()
    {
        return longitude;
    }

    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }

    public String getLatitude()
    {
        return latitude;
    }

    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
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

        retValue = "Membercard ( " + super.toString() + TAB + "id = " + this.id
                + TAB + "name = " + this.name + TAB + "namecolor = "
                + this.namecolor + TAB + "numbercolor = " + this.numbercolor
                + TAB + "bgurl = " + this.bgurl + TAB + "logourl = "
                + this.logourl + TAB + "shopname = " + this.shopname + TAB
                + "shopaddress = " + this.shopaddress + TAB
                + "shoptelephone = " + this.shoptelephone + TAB
                + "shopdescription = " + this.shopdescription + TAB
                + "cardnoinit = " + this.cardnoinit + TAB + "longitude = "
                + this.longitude + TAB + "latitude = " + this.latitude + TAB
                + "bizid = " + this.bizid + TAB + " )";

        return retValue;
    }

}
