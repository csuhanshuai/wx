package com.qixin.app.zjminweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_integralrule")
public class Integralrule
{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "moneyproportion", nullable = false, length = 32)
    private String moneyproportion;

    @Column(name = "integralproportion", nullable = false, length = 32)
    private String integralproportion;

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

    public String getBizid()
    {
        return bizid;
    }

    public void setBizid(String bizid)
    {
        this.bizid = bizid;
    }

    public String getMoneyproportion()
    {
        return moneyproportion;
    }

    public void setMoneyproportion(String moneyproportion)
    {
        this.moneyproportion = moneyproportion;
    }

    public String getIntegralproportion()
    {
        return integralproportion;
    }

    public void setIntegralproportion(String integralproportion)
    {
        this.integralproportion = integralproportion;
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

        retValue = "Integralrule ( " + super.toString() + TAB + "id = "
                + this.id + TAB + "moneyproportion = " + this.moneyproportion
                + TAB + "integralproportion = " + this.integralproportion + TAB
                + "bizid = " + this.bizid + TAB + " )";

        return retValue;
    }

}
