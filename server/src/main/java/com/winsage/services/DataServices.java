package com.winsage.services;

import java.util.List;

import com.winsage.model.BaseEntity;
import com.winsage.model.User;

public interface DataServices {
	public boolean addEntity(BaseEntity entity) throws Exception;
	public User getEntityById(long id) throws Exception;
	public List<User> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
