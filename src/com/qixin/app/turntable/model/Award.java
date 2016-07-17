package com.qixin.app.turntable.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zjtbl_dzp_award")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Award
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "persistenceGenerator", strategy = "increment")
    @Column(name = "id", nullable = false)
    private int id;

    private int min;

    private int max;

    private int isPrize;

    private String name;

    private String prompt;

    private int v;

    private int num;
    
    @Column(name = "giftid")
    private String giftid;

    public int getMin()
    {
        return min;
    }

    public void setMin(int min)
    {
        this.min = min;
    }

    public int getMax()
    {
        return max;
    }

    public void setMax(int max)
    {
        this.max = max;
    }

    public int getV()
    {
        return v;
    }

    public void setV(int v)
    {
        this.v = v;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
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

    public int getIsPrize()
    {
        return isPrize;
    }

    public void setIsPrize(int isPrize)
    {
        this.isPrize = isPrize;
    }

    public int getNum()
    {
        return num;
    }

    public void setNum(int num)
    {
        this.num = num;
    }

    public String getPrompt()
    {
        return prompt;
    }

    public void setPrompt(String prompt)
    {
        this.prompt = prompt;
    }

    public String getGiftid()
    {
        return giftid;
    }

    public void setGiftid(String giftid)
    {
        this.giftid = giftid;
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

        retValue = "Award ( " + super.toString() + TAB + "id = " + this.id
                + TAB + "min = " + this.min + TAB + "max = " + this.max + TAB
                + "isPrize = " + this.isPrize + TAB + "name = " + this.name
                + TAB + "prompt = " + this.prompt + TAB + "v = " + this.v + TAB
                + "num = " + this.num + TAB + "giftid = " + this.giftid + TAB
                + " )";

        return retValue;
    }

    
    
    
    
    
    private Integer badgeCount;
    private Integer chanceCount;

    @Column(updatable=false)
	public Integer getBadgeCount() {
		return badgeCount;
	}

	public void setBadgeCount(Integer badgeCount) {
		this.badgeCount = badgeCount;
	}

	@Column(updatable=false)
	public Integer getChanceCount() {
		return chanceCount;
	}

	public void setChanceCount(Integer chanceCount) {
		this.chanceCount = chanceCount;
	}

	
    
    
    
    
    
    
}
