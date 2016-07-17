package com.qixin.app.zjminweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_membernotice")
public class Membernotice
{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "name", length = 32)
    private String name;

    @Lob
    @Column(name = "description", columnDefinition = "LongText", nullable = false)
    private String description;

    @Column(name = "intime", length = 32, nullable = false)
    private String intime;

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

    public String getIntime()
    {
        return intime;
    }

    public void setIntime(String intime)
    {
        this.intime = intime;
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

        retValue = "Membernotice ( " + super.toString() + TAB + "id = "
                + this.id + TAB + "name = " + this.name + TAB + "intime = "
                + this.intime + TAB + "description = " + this.description + TAB
                + "bizid = " + this.bizid + TAB + " )";

        return retValue;
    }

}
