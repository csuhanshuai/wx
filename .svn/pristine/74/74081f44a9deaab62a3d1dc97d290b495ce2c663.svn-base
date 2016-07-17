package com.qixin.app.lanterngame.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
/**
 * 
 * @author liufei
 * 附件信息表
 */
@Entity
@Table(name="attach_info")
public class AttachInfo {
	private String id;//id
	private String imgDir;//路径
	private String suffix;//附件后缀
	private String description;//描述
	private String creater;//
	private Date createdDate;//
	private String updater;//
	private Date updateDate;//
	@GenericGenerator(name="generator", strategy="uuid.hex")
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id", unique=true, nullable=false, length=32)
	public String getId() {
		return id;
	}
	@Column(name="IMG_DIR",length=255)
	public String getImgDir() {
		return imgDir;
	}
	@Column(name="SUFFIX",length=20)
	public String getSuffix() {
		return suffix;
	}
	@Column(name="DESCRIPTION",length=500)
	public String getDescription() {
		return description;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	public void setImgDir(String imgDir) {
		this.imgDir = imgDir;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="CREATER",length=32)
	public String getCreater() {
		return creater;
	}
	@Column(name="CREATED_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}
	@Column(name="UPDATER",length=32)
	public String getUpdater() {
		return updater;
	}
	@Column(name="UPDATE_DATE")
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "AttachInfo [id=" + id + ", imgDir=" + imgDir + ", suffix="
				+ suffix + ", description=" + description + ", creater="
				+ creater + ", createdDate=" + createdDate + ", updater="
				+ updater + ", updateDate=" + updateDate + "]";
	}
	
}
