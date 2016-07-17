package com.qixin.app.turntable.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "zjtbl_dzp_winners")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Winners {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "persistenceGenerator", strategy = "increment")
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "openid")
	private String openid;

	@Column(name = "name")
	private String name;
	

	@Column(name = "tel")
	private String tel;


	@Column(name = "company")
	private String company;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "award")
	private String award;
	/**是否兑奖**/
	@Column(name = "ticket")
	private int ticket;
	
	@Column(name = "activitiesid")
    private String activitiesid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
	}
	public int getTicket() {
		return ticket;
	}
	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
    public String getActivitiesid()
    {
        return activitiesid;
    }
    public void setActivitiesid(String activitiesid)
    {
        this.activitiesid = activitiesid;
    }
    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     *
     * @return a <code>String</code> representation 
     * of this object.
     */
    public String toString()
    {
        final String TAB = "    ";
        
        String retValue = "";
        
        retValue = "Winners ( "
            + super.toString() + TAB
            + "id = " + this.id + TAB
            + "openid = " + this.openid + TAB
            + "name = " + this.name + TAB
            + "tel = " + this.tel + TAB
            + "company = " + this.company + TAB
            + "department = " + this.department + TAB
            + "award = " + this.award + TAB
            + "ticket = " + this.ticket + TAB
            + "activitiesid = " + this.activitiesid + TAB
            + " )";
    
        return retValue;
    }
	
	
}
