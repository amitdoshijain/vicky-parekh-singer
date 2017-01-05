package com.winsage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "users")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "password")
	private String password;

	@Column(name = "username")
	private String username;
	
	@Column(name="sessionid")
	private String sessionid;

	public User(){
		
	}

	public User(Long id,String password, String username, String sessionid) {
		super(id);
		this.password = password;
		this.username = username;
		this.sessionid = sessionid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

}
