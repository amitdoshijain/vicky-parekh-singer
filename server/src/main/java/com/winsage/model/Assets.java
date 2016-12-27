package com.winsage.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "assets")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Assets extends BaseEntity {

	private static final long serialVersionUID = 1L;


	@Column(name = "category")
	private String category;

	@Column(name = "url")
	private String url;

	@Column(name = "description")
	private String description;

	@Column(name = "uploadedby")
	private String uploadedby;

	@Column(name = "deleted")
	private Boolean deleted;

	@Column(name = "updatedon")
	private Date updatedOn;

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUploadedby() {
		return uploadedby;
	}

	public void setUploadedby(String uploadedby) {
		this.uploadedby = uploadedby;
	}

}
