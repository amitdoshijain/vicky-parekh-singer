/**
 * 
 */
package com.winsage.model;

import java.util.Date;
import com.winsage.model.Products;
import com.winsage.model.User;
import org.springframework.stereotype.Component;

/**
 * @author msingh
 *
 */
@Component("paramVO")
public class ParamVO {
	
	private Long id;
	private Products products;
	private User userVO;
	private String status;
	private Date completedon;
	private int limit;
	private String sessionid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products catalogVO) {
		this.products = catalogVO;
	}
	@Override
	public String toString() {
		return "ParamVO [id=" + id + ", products=" + products + "]";
	}
	public User getUserVO() {
		return userVO;
	}
	public void setUserVO(User userVO) {
		this.userVO = userVO;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCompletedon() {
		return completedon;
	}
	public void setCompletedon(Date completedon) {
		this.completedon = completedon;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

}
