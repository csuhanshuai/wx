package com.qixin.app.zjminweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_memberlevel")
public class Memberlevel
{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "name", length = 32)
    private String name;

    @Column(name = "type", length = 32)
    private String type;

    @Column(name = "integralstart", length = 32)
    private String integralstart;

    @Column(name = "integralend", length = 32)
    private String integralend;

    @Column(name = "description", length = 32)
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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getIntegralstart()
    {
        return integralstart;
    }

    public void setIntegralstart(String integralstart)
    {
        this.integralstart = integralstart;
    }

    public String getIntegralend()
    {
        return integralend;
    }

    public void setIntegralend(String integralend)
    {
        this.integralend = integralend;
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

        retValue = "Memberlevel ( " + super.toString() + TAB + "id = "
                + this.id + TAB + "name = " + this.name + TAB + "type = "
                + this.type + TAB + "integralstart = " + this.integralstart
                + TAB + "integralend = " + this.integralend + TAB
                + "description = " + this.description + TAB + "bizid = "
                + this.bizid + TAB + " )";

        return retValue;
    }

}
