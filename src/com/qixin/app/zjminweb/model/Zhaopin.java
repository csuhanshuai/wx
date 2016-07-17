package com.qixin.app.zjminweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_minweb_zhaopin")
public class Zhaopin
{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "name", length = 32, nullable = false)
    private String name;

    @Column(name = "education", length = 10, nullable = false)
    private String education;

    @Column(name = "endtime", length = 32, nullable = false)
    private String endtime;

    @Column(name = "sex", length = 32, nullable = false)
    private String sex;

    @Column(name = "age", length = 32, nullable = false)
    private String age;

    @Column(name = "workingplace", length = 100, nullable = false)
    private String workingplace;

    @Column(name = "pay", length = 100, nullable = false)
    private String pay;

    @Lob
    @Column(name = "description", columnDefinition = "LongText", nullable = false)
    private String description;

    @Column(name = "numbers", length = 100, nullable = false)
    private String numbers;

    @Column(name = "workingnum", length = 100, nullable = false)
    private String workingnum;

    @Column(name = "workingtype", length = 10, nullable = false)
    private String workingtype;

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

    @Column(name = "name", length = 10)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEducation()
    {
        return education;
    }

    public void setEducation(String education)
    {
        this.education = education;
    }

    public String getEndtime()
    {
        return endtime;
    }

    public void setEndtime(String endtime)
    {
        this.endtime = endtime;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    public String getWorkingplace()
    {
        return workingplace;
    }

    public void setWorkingplace(String workingplace)
    {
        this.workingplace = workingplace;
    }

    public String getPay()
    {
        return pay;
    }

    public void setPay(String pay)
    {
        this.pay = pay;
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

    public String getNumbers()
    {
        return numbers;
    }

    public void setNumbers(String numbers)
    {
        this.numbers = numbers;
    }

    public String getWorkingnum()
    {
        return workingnum;
    }

    public void setWorkingnum(String workingnum)
    {
        this.workingnum = workingnum;
    }

    public String getWorkingtype()
    {
        return workingtype;
    }

    public void setWorkingtype(String workingtype)
    {
        this.workingtype = workingtype;
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

        retValue = "Zhaopin ( " + super.toString() + TAB + "id = " + this.id
                + TAB + "name = " + this.name + TAB + "education = "
                + this.education + TAB + "endtime = " + this.endtime + TAB
                + "sex = " + this.sex + TAB + "age = " + this.age + TAB
                + "workingplace = " + this.workingplace + TAB + "pay = "
                + this.pay + TAB + "description = " + this.description + TAB
                + "numbers = " + this.numbers + TAB + "workingnum = "
                + this.workingnum + TAB + "workingtype = " + this.workingtype
                + TAB + "bizid = " + this.bizid + TAB + " )";

        return retValue;
    }

}
