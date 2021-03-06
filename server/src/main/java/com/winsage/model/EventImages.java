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
@Table(name = "eventimages")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class EventImages extends BaseEntity {

	private static final long serialVersionUID = 1L;


	@Column(name = "eventid")
	private long eventid;

	@Column(name = "imageurl")
	private String imageURL;

	@Column(name = "description")
	private String description;

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

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public long getEventid() {
		return eventid;
	}

	public void setEventid(long eventid) {
		this.eventid = eventid;
	}

}
