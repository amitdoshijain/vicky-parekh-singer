package com.winsage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.winsage.dao.DataDao;
import com.winsage.model.BaseEntity;
import com.winsage.model.User;

public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;
	
	@Override
	public boolean addEntity(BaseEntity entity) throws Exception {
		return dataDao.addEntity(entity);
	}

	@Override
	public User getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}

	@Override
	public List<User> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}

}
