package com.qixin.app.zjminweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_member")
public class Member
{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "name", length = 32)
    private String name;

    /**
     * 会员卡号
     */
    @Column(name = "cardno", length = 10)
    private String cardno;

    @Column(name = "sex", length = 10)
    private String sex;

    @Column(name = "telephone", length = 32)
    private String telephone;

    @Column(name = "birthday", length = 32)
    private String birthday;

    @Column(name = "addr_prov", length = 32)
    private String addr_prov;

    @Column(name = "addr_city", length = 32)
    private String addr_city;

    @Column(name = "addr_area", length = 32)
    private String addr_area;

    @Column(name = "address", length = 1000)
    private String address;

    @Column(name = "qq", length = 32)
    private String qq;

    /**
     * 积分
     */
    @Column(name = "integral", length = 32)
    private String integral = "0";

    /**
     * 余额
     */
    @Column(name = "balance", length = 32)
    private String balance = "0";

    @Column(name = "intime", length = 32)
    private String intime;

    /**
     * 2锁定/1解锁(正常)
     */
    @Column(name = "status", length = 32)
    private String status;

    @Column(name = "openid")
    private String openid;

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

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getQq()
    {
        return qq;
    }

    public void setQq(String qq)
    {
        this.qq = qq;
    }

    public String getBizid()
    {
        return bizid;
    }

    public void setBizid(String bizid)
    {
        this.bizid = bizid;
    }

    public String getOpenid()
    {
        return openid;
    }

    public void setOpenid(String openid)
    {
        this.openid = openid;
    }

    public String getIntegral()
    {
        return integral;
    }

    public void setIntegral(String integral)
    {
        this.integral = integral;
    }

    public String getBalance()
    {
        return balance;
    }

    public void setBalance(String balance)
    {
        this.balance = balance;
    }

    public String getIntime()
    {
        return intime;
    }

    public void setIntime(String intime)
    {
        this.intime = intime;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getCardno()
    {
        return cardno;
    }

    public void setCardno(String cardno)
    {
        this.cardno = cardno;
    }

    public String getAddr_prov()
    {
        return addr_prov;
    }

    public void setAddr_prov(String addr_prov)
    {
        this.addr_prov = addr_prov;
    }

    public String getAddr_city()
    {
        return addr_city;
    }

    public void setAddr_city(String addr_city)
    {
        this.addr_city = addr_city;
    }

    public String getAddr_area()
    {
        return addr_area;
    }

    public void setAddr_area(String addr_area)
    {
        this.addr_area = addr_area;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
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

        retValue = "Member ( " + super.toString() + TAB + "id = " + this.id
                + TAB + "name = " + this.name + TAB + "cardno = " + this.cardno
                + TAB + "sex = " + this.sex + TAB + "telephone = "
                + this.telephone + TAB + "birthday = " + this.birthday + TAB
                + "addr_prov = " + this.addr_prov + TAB + "addr_city = "
                + this.addr_city + TAB + "addr_area = " + this.addr_area + TAB
                + "address = " + this.address + TAB + "qq = " + this.qq + TAB
                + "integral = " + this.integral + TAB + "balance = "
                + this.balance + TAB + "intime = " + this.intime + TAB
                + "status = " + this.status + TAB + "openid = " + this.openid
                + TAB + "bizid = " + this.bizid + TAB + " )";

        return retValue;
    }

}
