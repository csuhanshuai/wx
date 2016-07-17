package com.qixin.app.flexWechatMain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "wxtbl_wechatwall")
public class WeChatWall {

	private String id;
	
	private String openid;

	private String msgtxg;

	private String isreg;
	
	private String gamenumber;

	private String updatetime;

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    
	@Column(name = "openid", length = 50)
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Column(name = "msgtxg")
	public String getMsgtxg() {
		return msgtxg;
	}

	public void setMsgtxg(String msgtxg) {
		this.msgtxg = msgtxg;
	}
	@Column(name = "isreg", length = 3)
	public String getIsreg() {
		return isreg;
	}
	@Column(name = "gamenumber", length = 32)
	public String getGamenumber() {
		return gamenumber;
	}

	public void setGamenumber(String gamenumber) {
		this.gamenumber = gamenumber;
	}

	public void setIsreg(String isreg) {
		this.isreg = isreg;
	}

	@Column(name = "updatetime", length = 32)
	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

}
