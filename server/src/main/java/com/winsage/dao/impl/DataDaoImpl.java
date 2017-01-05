package com.winsage.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.winsage.dao.DataDao;
import com.winsage.exception.DAOException;
import com.winsage.model.BaseEntity;
import com.winsage.model.Products;
import com.winsage.model.User;

@Repository("dataDao")
public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(BaseEntity entity) throws DAOException {
		
		Long id = 0L;
		try{		
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			id = (Long) session.save(entity);		
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException(e.getMessage(),e);
		}finally{
			session.close();
		}		
		if(id != null && id != 0){
			return true;
		}else
		return false;
	}

	@Override
	public Products getEntityById(long id) throws DAOException {
		Products product = null;
		try{
			session = sessionFactory.openSession();
			product = (Products) session.load(Products.class,
					new Long(id));
			tx = session.getTransaction();
			session.beginTransaction();
			tx.commit();
		}catch(EmptyResultDataAccessException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException(e.getMessage(),e);
		}finally{
			session.close();
		}		
		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Products> getCatalog() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Products> productList = session.createCriteria(Products.class)
				.list();
		tx.commit();
		session.close();
		return productList;
	}
	
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(User.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public User authenticateUser(User user) throws DAOException {		
		List<User> authenticatedUserList = null;
		User authenticatedUser = null;
		try{		
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			authenticatedUserList = session.createCriteria(User.class)
					.add(Restrictions.eq("username", user.getUsername()))
					.list();
			tx.commit();
		}catch(EmptyResultDataAccessException e){
			e.printStackTrace();
			authenticatedUserList = null;
		}
		catch(Exception e){
			e.printStackTrace();
			throw new DAOException(e.getMessage(),e);
		}finally{
			session.close();
		}
		if(!authenticatedUserList.isEmpty() && authenticatedUserList.size() !=0){
			authenticatedUser = authenticatedUserList.get(0);
		}
		return authenticatedUser;		
	}
	
	@Override
	public boolean updateUserSession(User user) throws DAOException {		
		boolean isUpdatedUser = false;
		try{		
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
			isUpdatedUser = true;
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException(e.getMessage(),e);
		}finally{
			session.close();
		}
		
		return isUpdatedUser;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Products> getProductList(int limit) throws DAOException {
		
		List<Products> catalogList = null;
		try{
			
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		catalogList = session.createCriteria(Products.class)
				//.add(Restrictions.eq("status", status))				
				.addOrder(Order.asc("updatedOn"))
				.setMaxResults(limit)
				.list();
		tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException(e.getMessage(), e);
		}finally{
			session.close();
		}	
		return catalogList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Long saveUser(User user) throws DAOException {		
		Long userId = 0L;
		try{		
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			userId = (long) session.save(user);					
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException(e.getMessage(),e);
		}finally{
			session.close();
		}		
		return userId;		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Long updateCatalogDetails(Long catalogId, Products Products) throws DAOException {		
		Long userId = 0L;
		try{		
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(Products);					
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException(e.getMessage(),e);
		}finally{
			session.close();
		}		
		return userId;		
	}
	

}
