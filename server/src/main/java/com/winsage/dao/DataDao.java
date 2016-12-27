package com.winsage.dao;

import java.util.List;

import com.winsage.model.BaseEntity;
import com.winsage.model.Events;
import com.winsage.model.Products;

public interface DataDao {

	public boolean addEntity(BaseEntity entity) throws Exception;
	public Events getEntityById(long id) throws Exception;
	public List<Products> getProducts() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
