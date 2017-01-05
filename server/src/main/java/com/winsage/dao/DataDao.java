package com.winsage.dao;

import java.util.List;

import com.winsage.exception.DAOException;
import com.winsage.model.BaseEntity;
import com.winsage.model.Products;
import com.winsage.model.User;

public interface DataDao {
 
	public boolean addEntity(BaseEntity entity) throws Exception;
	public Products getEntityById(long id) throws Exception;
	public List<Products> getCatalog() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	public User authenticateUser(User user) throws DAOException;
	public boolean updateUserSession(User user) throws DAOException;
	public List<Products> getProductList(int limit) throws Exception ;
	public Long saveUser(User user) throws DAOException;
	public Long updateCatalogDetails(Long catalogId, Products Products) throws DAOException;
}
