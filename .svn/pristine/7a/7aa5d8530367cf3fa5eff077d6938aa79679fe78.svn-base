package com.qixin.app.zjminweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_retailstore")
public class Retailstore
{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "name", length = 32)
    private String name;

    @Column(name = "address", length = 1000)
    private String address;

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

    @Column(name = "url", length = 1000)
    private String url;

    @Column(name = "telephone", length = 32)
    private String telephone;

    @Column(name = "description", length = 1000)
    private String description;

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

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getBizid()
    {
        return bizid;
    }

    public void setBizid(String bizid)
    {
        this.bizid = bizid;
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

        retValue = "Retailstore ( " + super.toString() + TAB + "id = "
                + this.id + TAB + "name = " + this.name + TAB + "address = "
                + this.address + TAB + "longitude = " + this.longitude + TAB
                + "latitude = " + this.latitude + TAB + "url = " + this.url
                + TAB + "telephone = " + this.telephone + TAB
                + "description = " + this.description + TAB + "bizid = "
                + this.bizid + TAB + " )";

        return retValue;
    }

}
