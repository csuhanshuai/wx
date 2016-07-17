package com.qixin.app.zjminweb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_integral")
public class Integral
{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "memberid", length = 32, nullable = false)
    private String memberid;

    /**
     * 0增加 1减少
     */
    @Column(name = "type", length = 10, nullable = false)
    private String type;

    @Column(name = "score", length = 32, nullable = false)
    private String score;

    @Column(name = "intime", length = 32, nullable = false)
    private Date intime;

    @Column(name = "description", length = 10)
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

    public String getMemberid()
    {
        return memberid;
    }

    public void setMemberid(String memberid)
    {
        this.memberid = memberid;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getScore()
    {
        return score;
    }

    public void setScore(String score)
    {
        this.score = score;
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

        retValue = "Integral ( " + super.toString() + TAB + "id = " + this.id
                + TAB + "memberid = " + this.memberid + TAB + "type = "
                + this.type + TAB + "score = " + this.score + TAB + "intime = "
                + this.intime + TAB + "description = " + this.description + TAB
                + "bizid = " + this.bizid + TAB + " )";

        return retValue;
    }

}
