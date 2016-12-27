package com.winsage.services;

import java.util.List;

import com.winsage.model.BaseEntity;
import com.winsage.model.Events;
import com.winsage.model.Products;

public interface DataServices {
	public boolean addEntity(BaseEntity entity) throws Exception;
	public BaseEntity getEntityById(long id) throws Exception;
	public List<Products> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
