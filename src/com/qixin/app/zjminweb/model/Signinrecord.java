package com.qixin.app.zjminweb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_signinrecord")
public class Signinrecord
{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "signinid", length = 32)
    private String signinid;

    @Column(name = "name", length = 32)
    private String name;

    @Column(name = "telephone", length = 32)
    private String telephone;

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

    public String getSigninid()
    {
        return signinid;
    }

    public void setSigninid(String signinid)
    {
        this.signinid = signinid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getBizid()
    {
        return bizid;
    }

    public void setBizid(String bizid)
    {
        this.bizid = bizid;
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

        retValue = "Signinrecord ( " + super.toString() + TAB + "id = "
                + this.id + TAB + "signinid = " + this.signinid + TAB
                + "name = " + this.name + TAB + "telephone = " + this.telephone
                + TAB + "intime = " + this.intime + TAB + "bizid = "
                + this.bizid + TAB + " )";

        return retValue;
    }

}
